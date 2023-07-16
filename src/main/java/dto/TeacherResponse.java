package dto;

import entity.Course;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@Builder
public class TeacherResponse {
    private Long id;
    private String firstName;
    private  String lastName;
    private  String email;
    private  String roleName;
    private LocalDate localDate;
    private  Boolean isActivity;
    private  Boolean isDelete;
    private Course course;
}
