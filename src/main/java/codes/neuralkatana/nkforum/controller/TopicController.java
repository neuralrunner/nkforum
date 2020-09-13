package codes.neuralkatana.nkforum.controller;

import codes.neuralkatana.nkforum.dto.TopicDTO;
import codes.neuralkatana.nkforum.form.TopicForm;
import codes.neuralkatana.nkforum.model.Course;
import codes.neuralkatana.nkforum.model.Topic;
import codes.neuralkatana.nkforum.repository.CourseRepository;
import codes.neuralkatana.nkforum.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.List;


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
    public ResponseEntity<TopicDTO> register(@RequestBody TopicForm topicForm,
                                             UriComponentsBuilder uriComponentsBuilder){
        //creates a Topic object from a TopicForm one to be able to save
        Topic topic = topicForm.convertFormToTopic(courseRepository);
        topicRepository.save(topic);
        URI uri = uriComponentsBuilder.path("/topics/{id}").buildAndExpand(topic.getId()).toUri();
        return ResponseEntity.created(uri).body(new TopicDTO(topic));
    }

    public List<TopicDTO> returnListDTOMock(){
        Topic t1 = new Topic("SpringBoot Not Running",
                "SpringBoot is giving a bean not found exception...",
                new Course("Spring Core","Programming"));
        t1.setId(111L);
        Topic t2 = new Topic("Android is not loading the Main Activity",
                "The Main Activity is return an exception",
                new Course("Android","Programming"));
        t2.setId(222L);
        Topic t3 = new Topic("How to do a correct Many to Many relationship",
                "My Many to Many Relationship is having some issues when I do a search with Joins",
                new Course("Postgres","Database"));
        t3.setId(333L);
        Topic t4 = new Topic("SpringData cannot map correctly a One To Many Relationship",
                "I'm having some issues to map a One To Many Relationship to MySQL Database",
                new Course("Spring Data","Programming"));
        t4.setId(444L);

        return TopicDTO.topicListToTopicDTOList(Arrays.asList(t1,t2,t3,t4));
    }
}
