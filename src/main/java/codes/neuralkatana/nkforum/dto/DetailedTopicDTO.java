package codes.neuralkatana.nkforum.dto;

import codes.neuralkatana.nkforum.model.Answer;
import codes.neuralkatana.nkforum.model.Topic;
import codes.neuralkatana.nkforum.model.TopicStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DetailedTopicDTO {
    private long id;
    private String title;
    private String message;
    private LocalDateTime creationDate;
    private String authorName;
    private TopicStatus status;
    private List<AnswerDTO> answerDTOs;

    public DetailedTopicDTO(Topic topic) {
        this.id = topic.getId();
        this.title = topic.getTitle();
        this.message = topic.getMessage();
        this.creationDate = topic.getCreationDate();
        this.authorName = topic.getAuthor().getName();
        this.status = topic.getStatus();
        this.answerDTOs = new ArrayList<>();
        this.answerDTOs.addAll(topic.getAnswerList().stream().map(AnswerDTO::new).collect(Collectors.toList()));
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

    public String getAuthorName() {
        return authorName;
    }

    public TopicStatus getStatus() {
        return status;
    }

    public List<AnswerDTO> getAnswerDTOs() {
        return answerDTOs;
    }
}
