package com.cohida.JudokaRegister;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class JudokaController {

    @GetMapping("/welcome")
    public String welcome() {
        return "Bem-vindo!";
    }

}
