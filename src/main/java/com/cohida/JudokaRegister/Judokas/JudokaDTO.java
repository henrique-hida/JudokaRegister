package com.cohida.JudokaRegister.Judokas;
import com.cohida.JudokaRegister.Championships.ChampionshipModel;
import com.cohida.JudokaRegister.Enums.Countries;
import com.cohida.JudokaRegister.Enums.Obis;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JudokaDTO {

    private Long id;
    private String name;
    private float weight;
    private int age;
    private Integer country;
    private Integer belt;
    private String rank;
    private ChampionshipModel championship;

    public Countries getCountryEnum() {
        return country != null ? Countries.fromId(country) : null;
    }

    public Obis getBeltEnum() {
        return belt != null ? Obis.fromId(belt) : null;
    }

}
