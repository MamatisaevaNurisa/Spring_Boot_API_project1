package dto;

import entity.Company;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class CourseResponse {
    private  Long id;
    private  String courseName;
    private  String durationMonth;
    private LocalDate localDate;
    private  Boolean isActivity;
    private  Boolean isDelete;
    private Company company;

}
