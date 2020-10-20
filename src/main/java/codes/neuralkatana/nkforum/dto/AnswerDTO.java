package codes.neuralkatana.nkforum.dto;

import codes.neuralkatana.nkforum.model.Answer;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class AnswerDTO {
    private long id;
    private String message;
    private String topicTitle;
    private LocalDateTime creationDate;
    private String authorName;

    public AnswerDTO(Answer answer){
        this.id = answer.getId();
        this.message = answer.getMessage();
        this.topicTitle = answer.getTopic().getTitle();
        this.creationDate = answer.getCreationDate();
        this.authorName = answer.getAuthor().getName();
    }

    public long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public String getTopicTitle() {
        return topicTitle;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public String getAuthorName() {
        return authorName;
    }


    public static List<AnswerDTO> answerListToAnswerDTOList(List<Answer> list){
        return list.stream().map(AnswerDTO::new).collect(Collectors.toList());
    }

    public static AnswerDTO converterAnswerToAnswerDTO(Answer answer){
        return new AnswerDTO(answer);
    }
}
