package com.cohida.JudokaRegister.Judokas;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JudokaService {

    private final JudokaRepository judokaRepository;
    private final JudokaMapper judokaMapper;

    public JudokaService(JudokaRepository judokaRepository, JudokaMapper judokaMapper) {
        this.judokaRepository = judokaRepository;
        this.judokaMapper = judokaMapper;
    }

    // List all judokas
    public List<JudokaDTO> showAllJudokas() {
        List<JudokaModel> judokas = judokaRepository.findAll();
        return judokas.stream()
                .map(judokaMapper::map)
                .collect(Collectors.toList());
    }

    // List judoka by ID
    public JudokaDTO showJudokaByID(Long id) {
        Optional<JudokaModel> judokaById = judokaRepository.findById(id);
        return judokaById.map(judokaMapper::map).orElse(null);
    }

    // Create a new judoka
    public JudokaDTO newJudoka(JudokaDTO judokaDTO) {
        JudokaModel judoka = judokaMapper.map(judokaDTO);
        judoka = judokaRepository.save(judoka);
        return judokaMapper.map(judoka);
    }

    // Update judoka
    public JudokaDTO updateJudoka(Long id, JudokaDTO judokaDTO) {
       Optional<JudokaModel> existingJudoka = judokaRepository.findById(id);
       if (existingJudoka.isPresent()) {
           JudokaModel updatedJudoka = judokaMapper.map(judokaDTO);
           updatedJudoka.setId(id);
           JudokaModel savedJudoka = judokaRepository.save(updatedJudoka);
           return judokaMapper.map(savedJudoka);
       }
       return null;
    }

    // Delete judoka
    public void deleteJudoka(Long id) {
        judokaRepository.deleteById(id);
    }
}
