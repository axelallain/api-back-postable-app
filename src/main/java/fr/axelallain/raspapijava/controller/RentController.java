package fr.axelallain.raspapijava.controller;

import fr.axelallain.raspapijava.dto.RentDto;
import fr.axelallain.raspapijava.model.Rent;
import fr.axelallain.raspapijava.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class RentController {

    private RentService rentService;

    @Autowired
    public RentController(RentService rentService) {
        this.rentService = rentService;
    }

    @GetMapping("/rents")
    public List<Rent> findByUsername(@RequestParam String username, @RequestParam String status) {
        return rentService.findAllByUsernameAndStatus(username, status);
    }

    @PostMapping("/rents")
    public Rent save(@RequestBody RentDto rentDto) {
        return rentService.save(rentDto);
    }

    @GetMapping("/rents/{id}")
    public Optional<Rent> findById(@PathVariable int id) {
        return rentService.findById(id);
    }
}
