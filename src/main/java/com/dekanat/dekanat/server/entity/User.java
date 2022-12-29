package com.dekanat.dekanat.server.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "\"User\"")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"Id\"", nullable = false)
    private Integer id;

    @Column(name = "login", length = Integer.MAX_VALUE)
    private String login;

    @Column(name = "pswrd", length = Integer.MAX_VALUE)
    private String pswrd;

    @Column(name = "role")
    private Integer role;

    @Column(name = "\"FIO\"", length = Integer.MAX_VALUE)
    private String fio;

    public User(Integer id, String login, String pswrd, Integer role, String fio) {
        this.id = id;
        this.login = login;
        this.pswrd = pswrd;
        this.role = role;
        this.fio = fio;
    }

    public User() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPswrd() {
        return pswrd;
    }

    public void setPswrd(String pswrd) {
        this.pswrd = pswrd;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

}