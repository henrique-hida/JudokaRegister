package com.cohida.JudokaRegister.Judokas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("judokas")
public class JudokaController {

    private JudokaService judokaService;

    public JudokaController(JudokaService judokaService) {
        this.judokaService = judokaService;
    }

    // Show all judokas (READ)
    @GetMapping("/list")
    public List<JudokaModel> showAllJudokas() {
        return judokaService.showAllJudokas();
    }

    // Find judoka by ID (READ)
    @GetMapping("/list")
    public JudokaModel showJudokaById() {
        return judokaService.showJudokaByID();
    }

    // Add judoka (CREATE)
    @PostMapping("/create")
    public String newJudoka() {
        return "Judoka criado";
    }

    // Alter judoka data (UPDATE)
    @PutMapping("/change")
    public String alterJudoka() {
        return "Judoka alterado";
    }

    // Delete judoka (DELETE)
    @DeleteMapping("/delete")
    public String deleteJudoka() {
        return "Judoka deletado";
    }

}
