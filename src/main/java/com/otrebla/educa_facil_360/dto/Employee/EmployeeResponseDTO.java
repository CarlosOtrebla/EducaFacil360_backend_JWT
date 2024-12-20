package com.otrebla.educa_facil_360.dto.Employee;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.otrebla.educa_facil_360.enums.PersonRoleENUM;
import com.otrebla.educa_facil_360.model.Classroom;
import com.otrebla.educa_facil_360.model.Employee;
import java.util.Base64;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Data
public class EmployeeResponseDTO {
    private UUID id;
    private PersonRoleENUM role;
    private String name;
    private String email;
    private String cpf;
    private String phoneNumber;
    private LocalDateTime registerTime;
    private Boolean active;
    private String profilePicture;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<UUID> classrooms; // IDs das salas associadas ao funcionário

    public EmployeeResponseDTO(Employee employee) {
        this.id = employee.getId();
        this.name = employee.getName();
        this.email = employee.getEmail();
        this.cpf = employee.getCpf();
        this.phoneNumber = employee.getPhoneNumber();
        this.registerTime = employee.getRegisterTime();
        this.active = employee.getActive();
        this.role = employee.getRole();
        this.profilePicture = employee.getProfilePicture() != null
            ? Base64.getEncoder().encodeToString(employee.getProfilePicture())
            : null; // Converte o byte[] para Base64, ou mantém null se não houver imagem

        if (this.role == PersonRoleENUM.TEACHER) {
            this.classrooms = employee.getClassrooms() != null && !employee.getClassrooms().isEmpty()
                ? employee.getClassrooms().stream()
                .map(Classroom::getId)
                .collect(Collectors.toList())
                : Collections.emptyList();
        }
    }
}
