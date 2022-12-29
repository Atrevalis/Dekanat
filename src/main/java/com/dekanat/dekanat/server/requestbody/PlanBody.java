package com.dekanat.dekanat.server.requestbody;

public class PlanBody {

    private int id;

    private int oldId;

    public int getOldId() {
        return oldId;
    }

    public void setOldId(int oldId) {
        this.oldId = oldId;
    }

    private int hours;

    private String startDate;

    private String endDate;

    private String specialityNumber;

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getSpecialityNumber() {
        return specialityNumber;
    }

    public PlanBody(int id, int hours, String startDate, String endDate, String specialityNumber) {
        this.id = id;
        this.hours = hours;
        this.startDate = startDate;
        this.endDate = endDate;
        this.specialityNumber = specialityNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSpecialityNumber(String specialityNumber) {
        this.specialityNumber = specialityNumber;
    }
}
