//package com.otrebla.educa_facil_360.model;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import java.util.List;
//import java.util.UUID;
//
//@Data
//@Entity
//@NoArgsConstructor
//@AllArgsConstructor
//public class ClassGroup {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.UUID)
//    private UUID id;
//
//    @Column(nullable = false)
//    private String name;
//
//    @ManyToOne
//    @JoinColumn(name = "school_id", nullable = false)
//    private School school; // Cada turma está associada a uma escola
//
//    @OneToMany(mappedBy = "classGroup", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Student> students; // Cada turma possui uma lista de alunos
//}
