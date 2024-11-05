package com.otrebla.educa_facil_360.dto.Classrom;

import com.otrebla.educa_facil_360.enums.ClassroomENUM;
import com.otrebla.educa_facil_360.enums.PeriodOfTheDayENUM;
import com.otrebla.educa_facil_360.model.Classroom;
import com.otrebla.educa_facil_360.model.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClassroomResponseDTO {
    
    private UUID id;
    private String name;
    private ClassroomENUM classroomENUM;
    private PeriodOfTheDayENUM periodRole;
    private List<Student> students;
    
    public ClassroomResponseDTO(Classroom classroom) {
        this.id = classroom.getId();
        this.name = classroom.getName();
        this.classroomENUM = classroom.getClassroomEnum();
        this.periodRole = classroom.getPeriodOfTheDay();
        this.students = classroom.getStudents();
    }
    
}