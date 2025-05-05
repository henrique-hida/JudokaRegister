package com.cohida.JudokaRegister.Judokas;

import com.cohida.JudokaRegister.Championships.ChampionshipModel;
import com.cohida.JudokaRegister.Enums.Countries;
import com.cohida.JudokaRegister.Enums.Obis;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_judokas")
@Data
@NoArgsConstructor
@AllArgsConstructor
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


}

