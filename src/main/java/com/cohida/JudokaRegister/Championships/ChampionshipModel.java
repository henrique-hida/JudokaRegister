package com.cohida.JudokaRegister.Championships;

import com.cohida.JudokaRegister.Enums.Countries;
import com.cohida.JudokaRegister.Judokas.JudokaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_championships")
@Data
@NoArgsConstructor
@AllArgsConstructor
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
