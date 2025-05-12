package com.cohida.JudokaRegister.Judokas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JudokaService {

    private JudokaRepository judokaRepository;
    private JudokaMapper judokaMapper;

    public JudokaService(JudokaRepository judokaRepository) {
        this.judokaRepository = judokaRepository;
    }

    public JudokaService(JudokaRepository judokaRepository, JudokaMapper judokaMapper) {
        this.judokaRepository = judokaRepository;
        this.judokaMapper = judokaMapper;
    }

    // List all judokas
    public List<JudokaModel> showAllJudokas() {
        return judokaRepository.findAll();
    }

    // List judoka by ID
    public JudokaModel showJudokaByID(Long id) {
        Optional<JudokaModel> judokaById = judokaRepository.findById(id);
        return judokaById.orElse(null);
    }

    // Create a new judoka
    public JudokaDTO newJudoka(JudokaDTO judokaDTO) {
        JudokaModel judoka = judokaMapper.map(judokaDTO);
        judoka = judokaRepository.save(judoka);
        return judokaMapper.map(judoka);
    }

    // Update judoka
    public JudokaModel updateJudoka(Long id, JudokaModel judokaUpdated) {
       if(judokaRepository.existsById(id)) {
           judokaUpdated.setId(id);
           return judokaRepository.save(judokaUpdated);
       }
       return null;
    }

    // Delete judoka
    public void deleteJudoka(Long id) {
        judokaRepository.deleteById(id);
    }
}
