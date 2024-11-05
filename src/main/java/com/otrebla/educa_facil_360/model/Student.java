package com.otrebla.educa_facil_360.model;

import com.otrebla.educa_facil_360.dto.Student.StudentRequestDTO;
import com.otrebla.educa_facil_360.enums.PersonRoleENUM;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
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
public class Student extends Person implements UserDetails {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column
    private UUID id;
    
    @Column(nullable = false)
    private String password;
    
    @Column(nullable = false)
    private PersonRoleENUM role;
    
    @Column(nullable = false)
    private Boolean isDeleted;
    
    @ManyToOne
    @JoinColumn(name = "classroom_id")
    private Classroom classroom;
    
    // Construtor que aceita StudentRequestDTO
    public Student(StudentRequestDTO studentRequestDto) {
        super(studentRequestDto.getName(), studentRequestDto.getEmail(), studentRequestDto.getCpf(),
                studentRequestDto.getPhoneNumber(), LocalDateTime.now(), true); // Ajuste os valores conforme necessário
        this.password = studentRequestDto.getPassword();
        this.role = PersonRoleENUM.STUDENT;
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
