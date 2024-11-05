package com.otrebla.educa_facil_360.model;

import com.otrebla.educa_facil_360.dto.Classrom.ClassroomRequestDTO;
import com.otrebla.educa_facil_360.enums.ClassroomENUM;
import com.otrebla.educa_facil_360.enums.PeriodOfTheDayENUM;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "classroom")
public class Classroom implements UserDetails {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    
    @Column(nullable = false)
    private String name;
    
    @Enumerated(EnumType.STRING)
    @NotNull(message = "O papel da sala é obrigatório")
    @Column
    private ClassroomENUM classroomEnum;
    
    @Enumerated(EnumType.STRING)
    @NotNull(message = "O período é obrigatorio")
    @Column
    private PeriodOfTheDayENUM periodOfTheDay;
    
    @ManyToOne
    @JoinColumn(name = "school_id", nullable = false)
    private School school;
    
    @ManyToMany
    @JoinTable(
            name = "classroom_student",
            joinColumns = @JoinColumn(name = "classroom_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private List<Student> students;
    
    @ManyToMany
    @JoinTable(
            name = "classroom_teacher",
            joinColumns = @JoinColumn(name = "classroom_id"),
            inverseJoinColumns = @JoinColumn(name = "teacher_id")
    )
    private List<Employee> teachers;
    
    public Classroom(ClassroomRequestDTO classroomRequestDTO) {
        this.name = classroomRequestDTO.getName();
        this.classroomEnum = classroomRequestDTO.getClassroomEnum();
        this.periodOfTheDay = classroomRequestDTO.getPeriodOfTheDay();
        this.school.setId(classroomRequestDTO.getSchoolId());
        
        
    }
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }
    
    @Override
    public String getPassword() {
        return "";
    }
    
    @Override
    public String getUsername() {
        return "";
    }
    
    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }
    
    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }
    
    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }
    
    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
