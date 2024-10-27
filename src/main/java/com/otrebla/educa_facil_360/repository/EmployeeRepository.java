package com.otrebla.educa_facil_360.repository;

import com.otrebla.educa_facil_360.model.Employee;
import com.otrebla.educa_facil_360.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, UUID> {
    
    @Query(value = "SELECT * FROM student WHERE email = :email " +
            "AND password = :password " +
            "AND is_deleted = false " +
            "AND active = true", nativeQuery = true)
    Optional<Employee> findByEmailAndPassword(String email, String password);
    
    Optional<Employee> findByEmail(String email);
    
    @Query(value = "SELECT * FROM student WHERE LOWER(name) LIKE LOWER(CONCAT('%', :search, '%')) AND is_deleted = false", nativeQuery = true)
    Page<Employee> findAllNonDeletedByName(String search, Pageable pageable);
    
    @Query(value = "SELECT * FROM student WHERE is_deleted = false", nativeQuery = true)
    Page<Employee> findAllNonDeleted(Pageable pageable);
    
    @Query(value = "SELECT * FROM student WHERE id = :id AND is_deleted = false", nativeQuery = true)
    Optional<Employee> findNonDeletedById(UUID id);
}
