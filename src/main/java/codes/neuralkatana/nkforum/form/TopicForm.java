package codes.neuralkatana.nkforum.form;

import codes.neuralkatana.nkforum.model.Topic;
import codes.neuralkatana.nkforum.repository.CourseRepository;

public class TopicForm {
    private String title;
    private String message;
    private String courseName;

    public TopicForm() {
    }

    public TopicForm(String title, String message, String courseName) {
        this.title = title;
        this.message = message;
        this.courseName = courseName;
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

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Topic convertFormToTopic(CourseRepository repository) {
        //Uses CourseRepository to find the Course and create a Topic object
        Topic topic = new Topic(this.title, this.message, repository.findByName(this.courseName));
        return topic;
    }
}
