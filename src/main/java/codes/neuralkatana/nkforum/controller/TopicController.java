package codes.neuralkatana.nkforum.controller;

import codes.neuralkatana.nkforum.dto.DetailedTopicDTO;
import codes.neuralkatana.nkforum.dto.TopicDTO;
import codes.neuralkatana.nkforum.form.TopicForm;
import codes.neuralkatana.nkforum.form.UpdateTopicForm;
import codes.neuralkatana.nkforum.model.Topic;
import codes.neuralkatana.nkforum.repository.CourseRepository;
import codes.neuralkatana.nkforum.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/topics")
public class TopicController {

    @Autowired
    private TopicRepository topicRepository;
    @Autowired
    private CourseRepository courseRepository;

    @GetMapping
    public List<TopicDTO> list(String courseName){
        List<Topic> topics;
        if(courseName == null) {
            topics = topicRepository.findAll();
        }else{
            topics = topicRepository.findByCourseName(courseName);
        }
        return TopicDTO.topicListToTopicDTOList(topics);
    }

    @PostMapping
    @Transactional
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
        if(topic.isPresent()){
            return ResponseEntity.ok(new DetailedTopicDTO(topic.get()));
        }
        return ResponseEntity.notFound().build();

    }

    @PutMapping("/{id}")
    @Transactional
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
    public ResponseEntity<?> delete(@PathVariable Long id){
        Optional<Topic> optionalTopic = topicRepository.findById(id);
        if(optionalTopic.isPresent()) {
            topicRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
