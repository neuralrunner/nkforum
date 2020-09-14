package codes.neuralkatana.nkforum.dto;

import codes.neuralkatana.nkforum.model.Topic;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class TopicDTO {
    private long id;
    private String title;
    private String message;
    private LocalDateTime creationDate;

    public TopicDTO(Topic topic) {
        this.id = topic.getId();
        this.title = topic.getTitle();
        this.message = topic.getMessage();
        this.creationDate = topic.getCreationDate();
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public static Page<TopicDTO> topicPageToTopicDTOPage(Page<Topic> list){
        return list.map(TopicDTO::new);
    }

    public static TopicDTO converterTopicToTopicDTO(Topic topic){
        return new TopicDTO(topic);
    }
}
