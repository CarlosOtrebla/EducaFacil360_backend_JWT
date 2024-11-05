package com.otrebla.educa_facil_360.enums;

import lombok.Getter;

@Getter
public enum ClassroomENUM {
    PRIMEIRO_PERIODO("primeiro_periodo"),
    SEGUNDO_PERIODO("segundo_periodo"),
    TERCEIRO_PERIODO("terceiro_periodo"),
    QUARTO_PERIODO("quarto_periodo"),
    QUINTO_PERIODO("quinto_periodo"),
    
    PRIMEIRO_ANO("primeiro_ano"),
    SEGUNDO_ANO("segundo_ano"),
    TERCEIRO_ANO("terceiro_ano"),
    QUARTO_ANO("quarto_ano"),
    QUINTO_ANO("quinto_ano"),
    SEXTO_ANO("sexto_ano"),
    SETIMO_ANO("setimo_ano"),
    OITAVO_ANO("oitavo_ano"),
    NONO_ANO("novo_ano"),;
    
    private final String classroomENUM;
    
    ClassroomENUM(String classroom) {
        this.classroomENUM = classroom;
    }
}
