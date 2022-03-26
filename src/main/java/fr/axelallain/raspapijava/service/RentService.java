package fr.axelallain.raspapijava.service;

import fr.axelallain.raspapijava.dto.RentDto;
import fr.axelallain.raspapijava.model.Rent;

import java.util.List;
import java.util.Optional;

public interface RentService {

    List<Rent> findAllByUsernameAndStatus(String username, String status);

    Rent save(RentDto rentDto);

    Optional<Rent> findById(int id);
}
