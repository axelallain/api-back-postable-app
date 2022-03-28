package fr.axelallain.raspapijava.service;

import fr.axelallain.raspapijava.model.Letterbox;

import java.util.Optional;

public interface LetterboxService {

    Optional<Letterbox> findById(int id);
}
