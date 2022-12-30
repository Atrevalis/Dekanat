package com.dekanat.dekanat.server.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "\"semester\"")
public class Semester {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "number", nullable = false)
    private Integer number;

    public Semester(Integer id, Integer number, LocalDate startDate, LocalDate endDate, Plan planNumber) {
        this.id = id;
        this.number = number;
        this.startDate = startDate;
        this.endDate = endDate;
        this.planNumber = planNumber;
    }

    @Column(name = "\"startDate\"")
    private LocalDate startDate;

    @Column(name = "\"endDate\"")
    private LocalDate endDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "\"planNumber\"")
    private Plan planNumber;

    @OneToMany(mappedBy = "semester")
    private Set<Lesson> lessons = new LinkedHashSet<>();

    public Semester() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
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

    public Plan getPlanNumber() {
        return planNumber;
    }

    public void setPlanNumber(Plan planNumber) {
        this.planNumber = planNumber;
    }

    public Set<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(Set<Lesson> lessons) {
        this.lessons = lessons;
    }

}