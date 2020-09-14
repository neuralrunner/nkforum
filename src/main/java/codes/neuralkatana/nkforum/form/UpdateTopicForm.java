package codes.neuralkatana.nkforum.form;

import codes.neuralkatana.nkforum.model.Topic;
import codes.neuralkatana.nkforum.repository.TopicRepository;
import com.sun.istack.NotNull;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

public class UpdateTopicForm {

    @NotNull @NotEmpty @Length(min = 5)
    private String title;

    @NotNull @NotEmpty @Length(min = 5)
    private String message;

    public UpdateTopicForm() {
    }

    public UpdateTopicForm(@NotEmpty @Length(min = 5) String title, @NotEmpty @Length(min = 5) String message) {
        this.title = title;
        this.message = message;
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


    public Topic update(Long id, TopicRepository topicRepository) {
        Topic topic = topicRepository.getOne(id);
        topic.setTitle(this.title);
        topic.setMessage(this.message);
        return topic;
    }
}
