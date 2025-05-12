package com.cohida.JudokaRegister.Judokas;

import org.springframework.stereotype.Component;

@Component
public class JudokaMapper {

    public JudokaModel map(JudokaDTO judokaDTO) {
        JudokaModel judokaModel = new JudokaModel();
        judokaModel.setId(judokaDTO.getId());
        judokaModel.setName(judokaDTO.getName());
        judokaModel.setWeight(judokaDTO.getWeight());
        judokaModel.setAge(judokaDTO.getAge());
        judokaModel.setCountry(judokaDTO.getCountry());
        judokaModel.setBelt(judokaDTO.getBelt());
        judokaModel.setRank(judokaDTO.getRank());
        judokaModel.setChampionship(judokaDTO.getChampionship());

        return judokaModel;
    }

    public JudokaDTO map(JudokaModel judokaModel) {
        JudokaDTO judokaDTO = new JudokaDTO();
        judokaDTO.setId(judokaModel.getId());
        judokaDTO.setName(judokaModel.getName());
        judokaDTO.setWeight(judokaModel.getWeight());
        judokaDTO.setAge(judokaModel.getAge());
        judokaDTO.setCountry(judokaModel.getCountry());
        judokaDTO.setBelt(judokaModel.getBelt());
        judokaDTO.setRank(judokaModel.getRank());
        judokaDTO.setChampionship(judokaModel.getChampionship());

        return judokaDTO;
    }

}
