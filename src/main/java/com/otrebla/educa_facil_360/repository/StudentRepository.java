package com.otrebla.educa_facil_360.repository;

import com.otrebla.educa_facil_360.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface StudentRepository extends JpaRepository<Student, UUID> {
    
    @Query(value = "SELECT * FROM student WHERE email = :email " +
            "AND password = :password " +
            "AND is_deleted = false " +
            "AND active = true", nativeQuery = true)
    Optional<Student> findByEmailAndPassword(String email, String password);
    
    Optional<Student> findByEmail(String email);
    
    @Query(value = "SELECT * FROM student WHERE LOWER(name) LIKE LOWER(CONCAT('%', :search, '%')) AND is_deleted = false", nativeQuery = true)
    Page<Student> findAllNonDeletedByName(String search, Pageable pageable);
    
    @Query(value = "SELECT * FROM student WHERE is_deleted = false", nativeQuery = true)
    Page<Student> findAllNonDeleted(Pageable pageable);
    
    @Query(value = "SELECT * FROM student WHERE id = :id AND is_deleted = false", nativeQuery = true)
    Optional<Student> findNonDeletedById(UUID id);
}
