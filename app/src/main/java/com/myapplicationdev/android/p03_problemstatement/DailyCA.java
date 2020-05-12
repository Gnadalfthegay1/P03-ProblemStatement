package com.myapplicationdev.android.p03_problemstatement;

import java.io.Serializable;

public class DailyCA {
    private String dgGrade;
    private String moduleCode;
    private int week;

    public String getDgGrade() {
        return dgGrade;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public int getWeek() {
        return week;
    }

    public DailyCA(String dgGrade, String moduleCode, int week) {
        this.dgGrade = dgGrade;
        this.moduleCode = moduleCode;
        this.week = week;
    }
}
