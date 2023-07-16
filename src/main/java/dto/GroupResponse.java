package dto;

import entity.Course;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
@Getter
@Setter
public class GroupResponse {
    private Long id;
    private String groupName;
    private String dateOfStart;
    private String dateOfFinish;
    private LocalDate localDate;
    private Boolean isActivity;
    private Boolean isDelete;
    private List<Course> courses;
}
