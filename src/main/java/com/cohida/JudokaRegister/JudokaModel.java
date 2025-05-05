package com.cohida.JudokaRegister;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_register")
public class JudokaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private float weight;
    private int age;
    private Countries country;
    private Obis belt;

    public JudokaModel() {
    }

    public JudokaModel(String name, float weight, int age, Countries country, Obis belt) {
        this.name = name;
        this.weight = weight;
        this.age = age;
        this.country = country;
        this.belt = belt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Countries getCountry() {
        return country;
    }

    public void setCountry(Countries country) {
        this.country = country;
    }

    public Obis getBelt() {
        return belt;
    }

    public void setBelt(Obis belt) {
        this.belt = belt;
    }
}

