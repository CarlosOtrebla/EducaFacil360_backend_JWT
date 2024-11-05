package com.otrebla.educa_facil_360.dto.Classrom;

import com.otrebla.educa_facil_360.enums.ClassroomENUM;
import com.otrebla.educa_facil_360.enums.PeriodOfTheDayENUM;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClassroomRequestDTO {
    
    @NotBlank
    private String name;
    @NotNull
    private ClassroomENUM classroomEnum;
    @NotNull
    private PeriodOfTheDayENUM periodOfTheDay;
    @NotNull
    private UUID schoolId;
    
    
   
}