package codes.neuralkatana.nkforum.form;

import codes.neuralkatana.nkforum.model.Answer;

import java.time.LocalDateTime;

public class AnswerForm {
    private String message;
    private String topicTitle;
    private LocalDateTime creationDate;
    private String authorName;
    private boolean solved;

    public AnswerForm() {
    }

    public AnswerForm(String message, String topicTitle, LocalDateTime creationDate, String authorName, boolean solved) {
        this.message = message;
        this.topicTitle = topicTitle;
        this.creationDate = creationDate;
        this.authorName = authorName;
        this.solved = solved;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTopicTitle() {
        return topicTitle;
    }

    public void setTopicTitle(String topicTitle) {
        this.topicTitle = topicTitle;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public boolean isSolved() {
        return solved;
    }

    public void setSolved(boolean solved) {
        this.solved = solved;
    }
}
