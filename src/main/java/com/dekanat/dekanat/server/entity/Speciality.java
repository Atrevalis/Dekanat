package com.dekanat.dekanat.server.entity;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "\"Speciality\"")
public class Speciality {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"numberSpec\"", nullable = false, length = Integer.MAX_VALUE)
    private String id;

    @Column(name = "name", length = Integer.MAX_VALUE)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "\"departmentId\"")
    private Department department;

    @OneToMany(mappedBy = "specialityNumber")
    private Set<StudentCard> studentCards = new LinkedHashSet<>();

    @OneToMany(mappedBy = "specialityNumber")
    private Set<Plan> plans = new LinkedHashSet<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Set<StudentCard> getStudentCards() {
        return studentCards;
    }

    public void setStudentCards(Set<StudentCard> studentCards) {
        this.studentCards = studentCards;
    }

    public Set<Plan> getPlans() {
        return plans;
    }

    public void setPlans(Set<Plan> plans) {
        this.plans = plans;
    }

}