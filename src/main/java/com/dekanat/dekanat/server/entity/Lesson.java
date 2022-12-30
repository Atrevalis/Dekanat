package com.dekanat.dekanat.server.entity;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "\"lesson\"")
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = Integer.MAX_VALUE)
    private String name;

    @Column(name = "\"lectureH\"")
    private Integer lectureH;

    @Column(name = "\"practiseH\"")
    private Integer practiseH;

    @Column(name = "\"laboratoryH\"")
    private Integer laboratoryH;

    @Column(name = "control")
    private Integer control;

    @Column(name = "index", length = Integer.MAX_VALUE)
    private String index;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "\"semesterId\"")
    private Semester semester;

    @OneToMany(mappedBy = "lesson")
    private Set<Mark> marks = new LinkedHashSet<>();

    public Lesson() {

    }

    public Integer getId() {
        return id;
    }

    public Lesson(Integer id, String name, Integer lectureH, Integer practiseH, Integer laboratoryH, Integer control, String index, Semester semester) {
        this.id = id;
        this.name = name;
        this.lectureH = lectureH;
        this.practiseH = practiseH;
        this.laboratoryH = laboratoryH;
        this.control = control;
        this.index = index;
        this.semester = semester;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLectureH() {
        return lectureH;
    }

    public void setLectureH(Integer lectureH) {
        this.lectureH = lectureH;
    }

    public Integer getPractiseH() {
        return practiseH;
    }

    public void setPractiseH(Integer practiseH) {
        this.practiseH = practiseH;
    }

    public Integer getLaboratoryH() {
        return laboratoryH;
    }

    public void setLaboratoryH(Integer laboratoryH) {
        this.laboratoryH = laboratoryH;
    }

    public Integer getControl() {
        return control;
    }

    public void setControl(Integer control) {
        this.control = control;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    public Set<Mark> getMarks() {
        return marks;
    }

    public void setMarks(Set<Mark> marks) {
        this.marks = marks;
    }

}