package com.dekanat.dekanat.server.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "\"mark\"")
public class Mark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "mark", nullable = false)
    private Integer mark;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "\"lessonId\"")
    private Lesson lesson;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "\"studentNumber\"")
    private StudentCard studentNumber;

    public Mark() {
    }

    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public Mark(Integer id, Integer mark, Lesson lesson, StudentCard studentNumber) {
        this.id = id;
        this.mark = mark;
        this.lesson = lesson;
        this.studentNumber = studentNumber;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public StudentCard getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(StudentCard studentNumber) {
        this.studentNumber = studentNumber;
    }

}