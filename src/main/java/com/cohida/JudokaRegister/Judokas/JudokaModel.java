package com.cohida.JudokaRegister.Judokas;

import com.cohida.JudokaRegister.Championships.ChampionshipModel;
import com.cohida.JudokaRegister.Enums.Countries;
import com.cohida.JudokaRegister.Enums.Obis;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "tb_judokas")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "championship")
public class JudokaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private Long id;

    @Column (name = "name")
    private String name;

    @Column (name = "weight")
    private float weight;

    @Column (name = "age")
    private int age;

    @Column (name = "country")
    private int country;

    @Column (name = "belt")
    private int belt;

    @Column (name = "rank")
    private String rank;

    @ManyToOne
    @JoinColumn(name = "championship_id")
    private ChampionshipModel championship;

}

