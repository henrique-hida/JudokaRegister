package com.cohida.JudokaRegister.Judokas;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("judokas")
public class JudokaController {

    private final JudokaService judokaService;

    public JudokaController(JudokaService judokaService) {
        this.judokaService = judokaService;
    }

    // Show all judokas (READ)
    @GetMapping("/list")
    public ResponseEntity<List<JudokaDTO>> showAllJudokas() {
        List<JudokaDTO> judokas = judokaService.showAllJudokas();
        return ResponseEntity.ok(judokas);
    }

    // Find judoka by ID (READ)
    @GetMapping("/list/{id}")
    public ResponseEntity<?> showJudokaById(@PathVariable Long id) {
        JudokaDTO judokaById = judokaService.showJudokaByID(id);
        if (judokaById != null) {
            return ResponseEntity.ok(judokaById);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Judoka não encontrado");
        }
    }

    // Add judoka (CREATE)
    @PostMapping("/create")
    public ResponseEntity<String> newJudoka(@RequestBody JudokaDTO judoka) {
        JudokaDTO newJudoka = judokaService.newJudoka(judoka);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Judoka cadastrado com sucesso: " + newJudoka.getName());
    }

    // Update judoka data (UPDATE)
    @PutMapping("/change/{id}")
    public ResponseEntity<?> updateJudoka(@PathVariable Long id, @RequestBody JudokaDTO judokaUpdated) {
        JudokaDTO updatedJudoka = judokaService.updateJudoka(id, judokaUpdated);
        if (updatedJudoka != null) {
            return ResponseEntity.ok(updatedJudoka);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Judoka não encontrado");
        }

    }

    // Delete judoka (DELETE)
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteJudoka(@PathVariable Long id) {
        if (judokaService.showJudokaByID(id) != null) {
            judokaService.deleteJudoka(id);
            return ResponseEntity.ok("Judoka deletado com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Judoka não encontrado");
        }
    }

}
