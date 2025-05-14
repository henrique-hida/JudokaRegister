package com.cohida.JudokaRegister.Judokas;
import com.cohida.JudokaRegister.Enums.Countries;
import com.cohida.JudokaRegister.Enums.Obis;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/judokas/ui")
public class JudokaControllerUI {

    private final JudokaService judokaService;

    public JudokaControllerUI(JudokaService judokaService) {
        this.judokaService = judokaService;
    }

    // Show all judokas (READ)
    @GetMapping("/list")
    public String showAllJudokas(Model model) {
        List<JudokaDTO> judokas = judokaService.showAllJudokas();
        model.addAttribute("judokas", judokas);
        return "listJudokas";
    }

    // Find judoka by ID (READ)
    @GetMapping("/details/{id}")
    public String showJudokaById(@PathVariable Long id, Model model) {
        JudokaDTO judoka = judokaService.showJudokaByID(id);
        if (judoka != null) {
            model.addAttribute("judoka", judoka);
            return "judokaDetails";
        } else {
            model.addAttribute("mensagem", "Judoka not found");
            return "redirect:/judokas/ui/list";
        }
    }

    // Add judoka (CREATE)
    @GetMapping("/add")
    public String showFormAddJudoka(Model model) {
        model.addAttribute("judoka", new JudokaDTO());
        model.addAttribute("allCountries", Countries.values());
        model.addAttribute("allBelts", Obis.values());
        return "addJudoka";
    }

    @PostMapping("/save")
    public String saveJudoka(@ModelAttribute JudokaDTO judokaDTO, RedirectAttributes redirectAttributes) {
        try {
            Countries country = judokaDTO.getCountryEnum();
            Obis belt = judokaDTO.getBeltEnum();

            if (country == null || belt == null) {
                redirectAttributes.addFlashAttribute("error", "Please select valid country and belt");
                return "redirect:/judokas/ui/add";
            }

            judokaService.newJudoka(judokaDTO);
            redirectAttributes.addFlashAttribute("mensagem", "Judoka registered successfully!");
            return "redirect:/judokas/ui/list";
        } catch (IllegalArgumentException e) {
            redirectAttributes.addFlashAttribute("error", "Invalid selection: " + e.getMessage());
            return "redirect:/judokas/ui/add";
        }
    }

    // Delete judoka (DELETE)
    @GetMapping("/delete/{id}")
    public String deleteJudoka(@PathVariable Long id) {
        judokaService.deleteJudoka(id);
        return "redirect:/judokas/ui/list";
    }
}

