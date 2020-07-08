package com.wellington.edu.model;

import javax.persistence.*;

@Entity
@Table(name = "person_table")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private Long id;
    @Column(name = "person_name")
    private String name;
    @Column(name = "person_age")
    private int age;
    @Column(name = "person_profession")
    private Professions profession;

    public Person(String name, int age, Professions profession) {
        this.name = name;
        this.age = age;
        this.profession = profession;
    }

    public Person() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Professions getProfession() {
        return profession;
    }

    public void setProfession(Professions profession) {
        this.profession = profession;
    }

}
