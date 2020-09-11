package codes.neuralkatana.nkforum.controller;

import codes.neuralkatana.nkforum.model.Course;
import codes.neuralkatana.nkforum.model.Topic;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller
public class TopicController {

    @RequestMapping("/topics")
    @ResponseBody
    public List<Topic> list(){
        Topic t1 = new Topic("SpringBoot Not Runing",
                "SpringBoot is giving a bean not found exception...",
                new Course("Spring Core","Programming"));
        Topic t2 = new Topic("Android is not loading the Main Activity",
                "The Main Activity is return an exception",
                new Course("Android","Programming"));
        Topic t3 = new Topic("How to do a correct Many to Many relationship",
                "My Many to Many Relationship is having some issues when I do a search with Joins",
                new Course("Postgres","Database"));
        Topic t4 = new Topic("SpringData cannot map correctly a One To Many Relationship",
                "I'm having some issues to map a One To Many Relationship to MySQL Database",
                new Course("Spring Data","Programming"));

        return Arrays.asList(t1,t2,t3,t4);
    }
}
