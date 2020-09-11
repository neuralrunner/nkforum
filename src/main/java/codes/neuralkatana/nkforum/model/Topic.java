package codes.neuralkatana.nkforum.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Topic {
    private Long id;
    private String title;
    private String message;
    private LocalDateTime creationDate = LocalDateTime.now();
    private TopicStatus status = TopicStatus.NOT_ANSWERED;
    private User author;
    private Course course;
    private List<Answer> answerList = new ArrayList<>();

    public Topic() {
    }

    public Topic(String title, String message, Course course) {
        this.title = title;
        this.message = message;
        this.course = course;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public TopicStatus getStatus() {
        return status;
    }

    public void setStatus(TopicStatus status) {
        this.status = status;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<Answer> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(List<Answer> answerList) {
        this.answerList = answerList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Topic topic = (Topic) o;

        return id != null ? id.equals(topic.id) : topic.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
