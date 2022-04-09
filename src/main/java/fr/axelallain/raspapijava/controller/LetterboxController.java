package fr.axelallain.raspapijava.controller;

import fr.axelallain.raspapijava.model.Letterbox;
import fr.axelallain.raspapijava.service.LetterboxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LetterboxController {

    private LetterboxService letterboxService;

    @Autowired
    public LetterboxController(LetterboxService letterboxService) { this.letterboxService = letterboxService; }

    @GetMapping("/letterboxes")
    public List<Letterbox> findAllByAvailable(@RequestParam Boolean available) {
        return letterboxService.findAllByAvailable(available);
    }
}
