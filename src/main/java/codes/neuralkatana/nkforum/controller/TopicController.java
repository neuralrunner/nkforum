package codes.neuralkatana.nkforum.controller;

import codes.neuralkatana.nkforum.dto.TopicDTO;
import codes.neuralkatana.nkforum.model.Course;
import codes.neuralkatana.nkforum.model.Topic;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;


@RestController
public class TopicController {

    @RequestMapping("/topics")
    public List<TopicDTO> list(){
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
