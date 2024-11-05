package com.otrebla.educa_facil_360.enums;

import lombok.Getter;

@Getter
public enum PersonRoleENUM {
    
    ADMIN("admin"),
    SCHOOL_PRINCIPAL("school_principal"),
    SCHOOL_COUNSELOR("school_counselor"),
    TEACHER("teacher"),
    STUDENT("student"),
    STUDENT_GUARDIAN("student_guardian");
    
    private final String personRoleENUM;
    
    PersonRoleENUM(String personRole) {
        this.personRoleENUM = personRole;
    }
    
}
