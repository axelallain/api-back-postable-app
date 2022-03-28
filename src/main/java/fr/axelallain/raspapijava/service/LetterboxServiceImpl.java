package fr.axelallain.raspapijava.service;

import fr.axelallain.raspapijava.dao.LetterboxDaoInterface;
import fr.axelallain.raspapijava.model.Letterbox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class LetterboxServiceImpl implements LetterboxService {

    @Autowired
    LetterboxDaoInterface letterboxDaoInterface;

    @Override
    public Optional<Letterbox> findById(int id) {
        return letterboxDaoInterface.findById(id);
    }
}
