package com.dekanat.dekanat.server.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "\"Plan\"")
public class Plan {
    @Id
    @Column(name = "number", nullable = false)
    private Integer id;

    @Column(name = "hours")
    private Integer hours;

    @Column(name = "\"startDate\"")
    private LocalDate startDate;

    @Column(name = "\"endDate\"")
    private LocalDate endDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "\"specialityNumber\"")
    private Speciality specialityNumber;

    @OneToMany(mappedBy = "planNumber")
    private Set<Semester> semesters = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Speciality getSpecialityNumber() {
        return specialityNumber;
    }

    public void setSpecialityNumber(Speciality specialityNumber) {
        this.specialityNumber = specialityNumber;
    }

    public Set<Semester> getSemesters() {
        return semesters;
    }

    public void setSemesters(Set<Semester> semesters) {
        this.semesters = semesters;
    }

}