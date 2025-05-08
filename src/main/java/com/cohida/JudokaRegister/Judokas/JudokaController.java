package com.cohida.JudokaRegister.Judokas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class JudokaController {

    @GetMapping("/welcome")
    public String welcome() {
        return "Bem-vindo!";
    }

    // Add judoka (CREATE)
    @PostMapping("/newjudoka")
    public String newJudoka() {
        return "Judoka criado";
    }

    // Show all judokas (READ)
    @GetMapping("/judokaslist")
    public String showAllJudokas() {
        return "Todos os judokas";
    }

    // Find judoka by (READ)
    @GetMapping("/judokaID")
    public String showAllJudokasById() {
        return "Judoka por ID";
    }

    // Alter judoka data (UPDATE)
    @PutMapping("/alterID")
    public String alterJudoka() {
        return "Judoka alterado";
    }

    // Delete judoka (DELETE)
    @DeleteMapping("/deleteID")
    public String deleteJudoka() {
        return "Judoka deletado";
    }

}
