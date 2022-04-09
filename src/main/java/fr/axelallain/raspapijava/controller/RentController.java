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

    @PostMapping("/rents")
    public Rent create(@RequestBody RentDto rentDto) {
        return rentService.create(rentDto);
    }

    @GetMapping("/rents")
    public List<Rent> findByUsername(@RequestParam String username, @RequestParam String status) {
        return rentService.findAllByUsernameAndStatus(username, status);
    }

    @GetMapping("/rents/{id}")
    public Optional<Rent> findById(@PathVariable int id) {
        return rentService.findById(id);
    }

    @GetMapping("/rentsbystatus")
    public List<Rent> findAllByStatus(@RequestParam String status) {
        return rentService.findAllByStatus(status);
    }

    /*
    @PutMapping("/rents/{id}")
    public Rent update(@PathVariable int id) {
        return rentService.update();
    }
    */

    @PutMapping("/endrent/{id}")
    public Rent endRent(@PathVariable int id) {
        // Should require the email of the user linked to this rent for security purpose.
        return rentService.endRent(id);
    }
}
