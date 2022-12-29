package com.dekanat.dekanat.server.entity;

import com.dekanat.dekanat.server.Utils.Time;
import com.dekanat.dekanat.server.requestbody.StudentCardBody;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "\"studentCard\"")
public class StudentCard {
    @Id
    @Column(name = "\"numberSB\"", nullable = false)
    private Integer id;

    @Column(name = "form")
    private Integer form;

    @Column(name = "finance")
    private Integer finance;

    @Column(name = "\"startDate\"")
    private LocalDate startDate;

    @Column(name = "\"endDate\"")
    private LocalDate endDate;

    @Column(name = "\"groupNumber\"")
    private Integer groupNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "\"specialityNumber\"")
    private Speciality specialityNumber;

    @OneToMany(mappedBy = "studentNumber")
    private Set<PersonalData> personalData = new LinkedHashSet<>();

    @OneToMany(mappedBy = "studentNumber")
    private Set<Mark> marks = new LinkedHashSet<>();

    public StudentCard(StudentCardBody studentCardBody, Speciality specialityNumber) {
        this.id = studentCardBody.getId();
        this.form = studentCardBody.getForm();
        this.endDate = Time.getLocalDate(studentCardBody.getEndDate());
        this.startDate = Time.getLocalDate(studentCardBody.getStartDate());
        this.finance = studentCardBody.getFinance();
        this.groupNumber = studentCardBody.getGroupNumber();
        this.specialityNumber = specialityNumber;
    }
    public StudentCard() {

    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getForm() {
        return form;
    }

    public void setForm(Integer form) {
        this.form = form;
    }

    public Integer getFinance() {
        return finance;
    }

    public void setFinance(Integer finance) {
        this.finance = finance;
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

    public Integer getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(Integer groupNumber) {
        this.groupNumber = groupNumber;
    }

    public Speciality getSpecialityNumber() {
        return specialityNumber;
    }

    public void setSpecialityNumber(Speciality specialityNumber) {
        this.specialityNumber = specialityNumber;
    }

    public Set<PersonalData> getPersonalData() {
        return personalData;
    }

    public void setPersonalData(Set<PersonalData> personalData) {
        this.personalData = personalData;
    }

    public Set<Mark> getMarks() {
        return marks;
    }

    public void setMarks(Set<Mark> marks) {
        this.marks = marks;
    }

}