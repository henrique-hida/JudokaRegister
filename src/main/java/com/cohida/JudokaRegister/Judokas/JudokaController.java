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
    @GetMapping("/list/{id}")
    public JudokaModel showJudokaById(@PathVariable Long id) {
        return judokaService.showJudokaByID(id);
    }

    // Add judoka (CREATE)
    @PostMapping("/create")
    public JudokaDTO newJudoka(@RequestBody JudokaDTO judoka) {
        return judokaService.newJudoka(judoka);
    }

    // Update judoka data (UPDATE)
    @PutMapping("/change/{id}")
    public JudokaModel updateJudoka(@PathVariable Long id, @RequestBody JudokaModel judokaUpdated) {
        return judokaService.updateJudoka(id, judokaUpdated);
    }

    // Delete judoka (DELETE)
    @DeleteMapping("/delete/{id}")
    public void deleteJudoka(@PathVariable Long id) {
        judokaService.deleteJudoka(id);
    }

}
