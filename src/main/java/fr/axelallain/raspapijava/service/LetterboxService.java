package fr.axelallain.raspapijava.service;

import fr.axelallain.raspapijava.model.Letterbox;

import java.util.List;
import java.util.Optional;

public interface LetterboxService {

    Optional<Letterbox> findById(int id);

    List<Letterbox> findAllByAvailable(Boolean available);
}
