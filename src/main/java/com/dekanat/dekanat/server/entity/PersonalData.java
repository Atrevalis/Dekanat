package com.dekanat.dekanat.server.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "\"PersonalData\"")
public class PersonalData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"documentNumber\"", nullable = false, length = Integer.MAX_VALUE)
    private String id;

    @Column(name = "\"FIO\"", length = Integer.MAX_VALUE)
    private String fio;

    @Column(name = "citizenship", length = Integer.MAX_VALUE)
    private String citizenship;

    @Column(name = "\"PIPN\"", length = Integer.MAX_VALUE)
    private String pipn;

    @Column(name = "\"birthDate\"")
    private LocalDate birthDate;

    @Column(name = "\"documentType\"")
    private Integer documentType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "\"studentNumber\"")
    private StudentCard studentNumber;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

    public String getPipn() {
        return pipn;
    }

    public void setPipn(String pipn) {
        this.pipn = pipn;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getDocumentType() {
        return documentType;
    }

    public void setDocumentType(Integer documentType) {
        this.documentType = documentType;
    }

    public StudentCard getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(StudentCard studentNumber) {
        this.studentNumber = studentNumber;
    }

}