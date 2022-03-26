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

    /*
    @PutMapping("/rents/{id}")
    public Rent update(@PathVariable int id) {
        return rentService.update();
    }
    */

    @DeleteMapping("/rents/{id}")
    public void deleteById(@PathVariable int id) {
        rentService.deleteById(id);
    }
}
