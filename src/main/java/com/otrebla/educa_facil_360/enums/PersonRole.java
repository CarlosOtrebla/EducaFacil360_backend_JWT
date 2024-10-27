package com.otrebla.educa_facil_360.enums;

public enum PersonRole {
    ADMIN("admin"),
    SCHOOL_COUNSELOR("scholl_counselor"),
    TEACHER("teacher"),
    STUDENT("student"),
    STUDENT_GUARDIAN("student_guardian");
    
    private String role;
    
    PersonRole(String role) {
        this.role = role;
    }
    
    public String getRole() {
        return role;
    }
    
}
