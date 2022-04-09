package fr.axelallain.raspapijava.dao;

import fr.axelallain.raspapijava.model.Letterbox;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LetterboxDaoInterface extends JpaRepository<Letterbox, Integer> {

    List<Letterbox> findAllByAvailable(Boolean available);
}
