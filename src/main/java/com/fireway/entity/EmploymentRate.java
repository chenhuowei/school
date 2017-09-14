package com.fireway.entity;

public class EmploymentRate {
    /**
     * 
     */
    private String id;

    /**
     * 
     */
    private String academy;

    /**
     * 
     */
    private Double employmentRate;

    /**
     * 
     */
    private String schoolYear;

    /**
     * 
     */
    private String graduationYear;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAcademy() {
        return academy;
    }

    public void setAcademy(String academy) {
        this.academy = academy;
    }

    public Double getEmploymentRate() {
        return employmentRate;
    }

    public void setEmploymentRate(Double employmentRate) {
        this.employmentRate = employmentRate;
    }

    public String getSchoolYear() {
        return schoolYear;
    }

    public void setSchoolYear(String schoolYear) {
        this.schoolYear = schoolYear;
    }

    public String getGraduationYear() {
        return graduationYear;
    }

    public void setGraduationYear(String graduationYear) {
        this.graduationYear = graduationYear;
    }
}