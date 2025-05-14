package com.cohida.JudokaRegister.Judokas;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(summary = "List all judokas", description = "List all judokas from db")
    @ApiResponses(value= {
            @ApiResponse(responseCode = "200", description = "Judoka found successfully")
    })
    public ResponseEntity<List<JudokaDTO>> showAllJudokas() {
        List<JudokaDTO> judokas = judokaService.showAllJudokas();
        return ResponseEntity.ok(judokas);
    }

    // Find judoka by ID (READ)
    @GetMapping("/list/{id}")
    @Operation(summary = "List a judoka by id", description = "List a judoka by its id")
    @ApiResponses(value= {
            @ApiResponse(responseCode = "200", description = "Judoka found successfully"),
            @ApiResponse(responseCode = "404", description = "Judoka not found")
    })
    public ResponseEntity<?> showJudokaById(@PathVariable Long id) {
        JudokaDTO judokaById = judokaService.showJudokaByID(id);
        if (judokaById != null) {
            return ResponseEntity.ok(judokaById);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Judoka not found");
        }
    }

    // Add judoka (CREATE)
    @PostMapping("/create")
    @Operation(summary = "Create a new judoka", description = "Create a new judoka and insert into the db")
    @ApiResponses(value= {
            @ApiResponse(responseCode = "201", description = "Judoka created successfully"),
            @ApiResponse(responseCode = "400", description = "Error in judoka creation")
    })
    public ResponseEntity<String> newJudoka(@RequestBody JudokaDTO judoka) {
        JudokaDTO newJudoka = judokaService.newJudoka(judoka);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Judoka registered successfully!: " + newJudoka.getName());
    }

    // Update judoka data (UPDATE)
    @PutMapping("/change/{id}")
    @Operation(summary = "Change judoka by id", description = "Edit judoka by id")
    @ApiResponses(value= {
            @ApiResponse(responseCode = "200", description = "Judoka updated successfully"),
            @ApiResponse(responseCode = "400", description = "Judoka not found")
    })
    public ResponseEntity<?> updateJudoka(
            @Parameter(description = "user sends id in the request path")
            @PathVariable Long id,
            @Parameter(description = "user sends judoka data in the request path")
            @RequestBody JudokaDTO judokaUpdated) {
        JudokaDTO updatedJudoka = judokaService.updateJudoka(id, judokaUpdated);
        if (updatedJudoka != null) {
            return ResponseEntity.ok(updatedJudoka);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Judoka not found");
        }

    }

    // Delete judoka (DELETE)
    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete judoka by id", description = "Delete judoka by id")
    public ResponseEntity<String> deleteJudoka(@PathVariable Long id) {
        if (judokaService.showJudokaByID(id) != null) {
            judokaService.deleteJudoka(id);
            return ResponseEntity.ok("Judoka deleted successfully!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Judoka not found");
        }
    }

}
