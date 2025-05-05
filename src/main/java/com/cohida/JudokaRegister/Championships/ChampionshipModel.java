package com.cohida.JudokaRegister.Championships;

import com.cohida.JudokaRegister.Enums.Countries;
import com.cohida.JudokaRegister.Judokas.JudokaModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_championships")
public class ChampionshipModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Countries country;

    // Um campeonato pode ter vários judokas
    @OneToMany(mappedBy = "championship")
    private List<JudokaModel> judokas;


}
