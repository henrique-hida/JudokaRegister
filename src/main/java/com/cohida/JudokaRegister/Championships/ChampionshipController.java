package com.cohida.JudokaRegister.Championships;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("championships")
public class ChampionshipController {

    @GetMapping("/list")
    public String listChampionships() {
        return "Championship showed";
    }

    @PostMapping("/create")
    public String createChampionship() {
        return "Championship created succesfully";
    }

    @PutMapping("/change")
    public String changeChampionship() {
        return "Championship changed succesfully";
    }

    @DeleteMapping("/delete")
    public String deleteChampionship() {
        return "Championship deleted succesfully";
    }

}
