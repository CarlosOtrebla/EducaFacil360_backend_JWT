package com.otrebla.educa_facil_360.model;

import com.otrebla.educa_facil_360.dto.Employee.EmployeeRequestDTO;
import com.otrebla.educa_facil_360.enums.PersonRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Entity
@Data // Gera os getters, setters, toString, equals e hashCode
@NoArgsConstructor // Gera o construtor padrão
@AllArgsConstructor // Gera o construtor com todos os atributos
@Builder // Permite o uso do padrão Builder
public class Employee extends Person implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column
    private UUID id;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private PersonRole role;

    @Column(nullable = false)
    private Boolean isDeleted;

    // Construtor que aceita EmployeeRequestDTO
    public Employee(EmployeeRequestDTO employeeRequestDto) {
        super(employeeRequestDto.getName(), employeeRequestDto.getEmail(), employeeRequestDto.getCpf(),
                employeeRequestDto.getPhoneNumber(), LocalDateTime.now(), true); // Ajuste os valores conforme necessário
        this.password = employeeRequestDto.getPassword();
        this.role = employeeRequestDto.getRole();
        this.isDeleted = false; // Ou outro valor padrão conforme sua lógica
    }

    // Sobrescrevendo métodos da interface UserDetails
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return password; // Retorna o atributo password
    }

    @Override
    public String getUsername() {
        return super.getEmail(); // Retorna o email como nome de usuário
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // Define se a conta está expirada
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Define se a conta está bloqueada
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Define se as credenciais estão expiradas
    }

    @Override
    public boolean isEnabled() {
        return !isDeleted; // Define se o usuário está ativo
    }
}
