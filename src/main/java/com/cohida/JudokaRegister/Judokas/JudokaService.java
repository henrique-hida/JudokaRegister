package com.cohida.JudokaRegister.Judokas;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JudokaService {

    private JudokaRepository judokaRepository;

    public JudokaService(JudokaRepository judokaRepository) {
        this.judokaRepository = judokaRepository;
    }

    // List all judokas
    public List<JudokaModel> showAllJudokas() {
        return judokaRepository.findAll();
    }

    // List judoka by ID
    public JudokaModel showJudokaByID() {
        return judokaRepository.findById();
    }
}
