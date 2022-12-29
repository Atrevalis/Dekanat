package com.dekanat.dekanat.server.requestbody;

import com.dekanat.dekanat.server.entity.Semester;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class LessonBody {
    private int id;

    private String name;

    private int lectureH;

    private int practiseH;

    private int laboratoryH;

    private int control;

    private String index;

    private int semester;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLectureH() {
        return lectureH;
    }

    public void setLectureH(int lectureH) {
        this.lectureH = lectureH;
    }

    public int getPractiseH() {
        return practiseH;
    }

    public void setPractiseH(int practiseH) {
        this.practiseH = practiseH;
    }

    public int getLaboratoryH() {
        return laboratoryH;
    }

    public void setLaboratoryH(int laboratoryH) {
        this.laboratoryH = laboratoryH;
    }

    public int getControl() {
        return control;
    }

    public void setControl(int control) {
        this.control = control;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }
}
