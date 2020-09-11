package codes.neuralkatana.nkforum.model;

import java.time.LocalDateTime;

public class Answer {
    private Long id;
    private String message;
    private Topic topic;
    private LocalDateTime creationDate = LocalDateTime.now();
    private User author;
    private Boolean solved = false;

    public Answer() {
    }

    public Answer(String message, Topic topic, LocalDateTime creationDate, User author, Boolean solved) {
        this.message = message;
        this.topic = topic;
        this.creationDate = creationDate;
        this.author = author;
        this.solved = solved;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Boolean getSolved() {
        return solved;
    }

    public void setSolved(Boolean solved) {
        this.solved = solved;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Answer answer = (Answer) o;

        return id != null ? id.equals(answer.id) : answer.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
