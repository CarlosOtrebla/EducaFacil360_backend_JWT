package com.otrebla.educa_facil_360.enums;

import lombok.Getter;

@Getter
public enum PeriodOfTheDayENUM {
    MORNING("morning"),
    AFTERNOON("afternoon"),
    EVENING("evening");
    
    private final String periodOfTheDayENUM;
    
    PeriodOfTheDayENUM(String periodOfTheDay) {
        this.periodOfTheDayENUM = periodOfTheDay;
    }
}
