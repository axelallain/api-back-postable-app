package fr.axelallain.raspapijava.controller;

import fr.axelallain.raspapijava.model.Letterbox;
import fr.axelallain.raspapijava.service.LetterboxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class LetterboxController {

    private LetterboxService letterboxService;

    @Autowired
    public LetterboxController(LetterboxService letterboxService) { this.letterboxService = letterboxService; }

    @GetMapping("/letterboxes/{id}")
    public Optional<Letterbox> findById(@PathVariable int id) { return letterboxService.findById(id); }

    @GetMapping("/letterboxes")
    public List<Letterbox> findAllByAvailable(@RequestParam Boolean available) {
        return letterboxService.findAllByAvailable(available);
    }

    @GetMapping("/letterboxesall")
    public List<Letterbox> findAll() {
        return letterboxService.findAll();
    }
}
