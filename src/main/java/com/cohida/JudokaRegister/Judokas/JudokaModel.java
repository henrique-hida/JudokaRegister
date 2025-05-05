package com.cohida.JudokaRegister.Judokas;

import com.cohida.JudokaRegister.Championships.ChampionshipModel;
import com.cohida.JudokaRegister.Enums.Countries;
import com.cohida.JudokaRegister.Enums.Obis;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_judokas")
public class JudokaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private float weight;
    private int age;
    private Countries country;
    private Obis belt;

    // Um judoka pode participar somente de um campeonato por vez
    @ManyToOne
    @JoinColumn(name = "championship_id") // FK
    private ChampionshipModel championship;

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

