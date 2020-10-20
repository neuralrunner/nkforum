package codes.neuralkatana.nkforum.dto;

import codes.neuralkatana.nkforum.model.Course;

import java.util.List;
import java.util.stream.Collectors;

public class CourseDTO {
    private long id;
    private String name;
    private String category;

    public CourseDTO(Course course){
        this.id = course.getId();
        this.name = course.getName();
        this.category = course.getCategory();
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public static List<CourseDTO> courseListToCourseDTOList(List<Course> list){
        return list.stream().map(CourseDTO::new).collect(Collectors.toList());
    }

    public static CourseDTO converterCourseToCourseDTO(Course course){
        return new CourseDTO(course);
    }
}
