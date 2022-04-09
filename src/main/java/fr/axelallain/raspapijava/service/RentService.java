package fr.axelallain.raspapijava.service;

import fr.axelallain.raspapijava.dto.RentDto;
import fr.axelallain.raspapijava.model.Rent;

import java.util.List;
import java.util.Optional;

public interface RentService {

    Rent create(RentDto rentDto);

    List<Rent> findAllByUsernameAndStatus(String username, String status);

    Optional<Rent> findById(int id);

    List<Rent> findAllByStatus(String status);

    // Rent update(RentDto rentDto);

    void deleteById(int id);

    Rent endRent(int id);
}
