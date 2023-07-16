package dto;

import entity.Group;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@Builder
public class StudentResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String roleName;
    private String studyFormat;
    private LocalDate localDate;
    private  Boolean isActivity;
    private  Boolean isDelete;
    private Group group;
}
