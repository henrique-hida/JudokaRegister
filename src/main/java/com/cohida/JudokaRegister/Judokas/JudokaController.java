package com.cohida.JudokaRegister.Judokas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("judokas")
public class JudokaController {

    // Show all judokas (READ)
    @GetMapping("/list")
    public String showAllJudokas() {
        return "Todos os judokas";
    }

    // Find judoka by (READ)
    @GetMapping("/listID")
    public String showAllJudokasById() {
        return "Judoka por ID";
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
