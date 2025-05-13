package com.cohida.JudokaRegister.Championships;
import com.cohida.JudokaRegister.Enums.Countries;
import com.cohida.JudokaRegister.Judokas.JudokaModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.List;

@Entity
@Table(name = "tb_championships")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ChampionshipModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Countries country;

    // Um campeonato pode ter vários judokas
    @OneToMany(mappedBy = "championship")
    @JsonIgnore
    private List<JudokaModel> judokas;


}
