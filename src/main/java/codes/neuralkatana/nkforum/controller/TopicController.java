package codes.neuralkatana.nkforum.controller;

import codes.neuralkatana.nkforum.dto.DetailedTopicDTO;
import codes.neuralkatana.nkforum.dto.TopicDTO;
import codes.neuralkatana.nkforum.form.TopicForm;
import codes.neuralkatana.nkforum.form.UpdateTopicForm;
import codes.neuralkatana.nkforum.model.Topic;
import codes.neuralkatana.nkforum.repository.CourseRepository;
import codes.neuralkatana.nkforum.repository.TopicRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;


@RestController
@RequestMapping("/topics")
public class TopicController {

    private final TopicRepository topicRepository;
    private final CourseRepository courseRepository;

    public TopicController(TopicRepository topicRepository, CourseRepository courseRepository) {
        this.topicRepository = topicRepository;
        this.courseRepository = courseRepository;
    }

    @GetMapping
    @Cacheable(value = "topicsList")
    public Page<TopicDTO> list(@RequestParam(required = false) String courseName,
                               @PageableDefault(sort="id",
                                       direction = Sort.Direction.ASC) Pageable pageable){
        Page<Topic> topics;

        if(courseName == null) {
            topics = topicRepository.findAll(pageable);
        }else{
            topics = topicRepository.findByCourseName(courseName,pageable);
        }
        return TopicDTO.topicPageToTopicDTOPage(topics);

    }

    @PostMapping
    @Transactional
    @CacheEvict(value = "topicsList", allEntries = true)
    public ResponseEntity<TopicDTO> register(@RequestBody @Valid TopicForm topicForm,
                                             UriComponentsBuilder uriComponentsBuilder){
        //creates a Topic object from a TopicForm one to be able to save
        Topic topic = topicForm.convertFormToTopic(courseRepository);
        topicRepository.save(topic);
        URI uri = uriComponentsBuilder.path("/topics/{id}").buildAndExpand(topic.getId()).toUri();
        return ResponseEntity.created(uri).body(new TopicDTO(topic));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetailedTopicDTO> detailTopic(@PathVariable Long id){
        Optional<Topic> topic = topicRepository.findById(id);
        return topic.map(value ->
                ResponseEntity.ok(new DetailedTopicDTO(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());

    }

    @PutMapping("/{id}")
    @Transactional
    @CacheEvict(value = "topicsList", allEntries = true)
    public ResponseEntity<TopicDTO> update(@PathVariable Long id, @RequestBody @Valid UpdateTopicForm uTopicForm){
        Optional<Topic> optionalTopic = topicRepository.findById(id);
        if(optionalTopic.isPresent()){
            Topic topic = uTopicForm.update(id,topicRepository);
            return ResponseEntity.ok(new TopicDTO(topic));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    @CacheEvict(value = "topicsList", allEntries = true)
    public ResponseEntity<Void> delete(@PathVariable Long id){
        Optional<Topic> optionalTopic = topicRepository.findById(id);
        if(optionalTopic.isPresent()) {
            topicRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
