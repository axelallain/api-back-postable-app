package fr.axelallain.raspapijava.service;

import fr.axelallain.raspapijava.dao.RentDaoInterface;
import fr.axelallain.raspapijava.dto.RentDto;
import fr.axelallain.raspapijava.exception.LetterboxNotFoundException;
import fr.axelallain.raspapijava.exception.RentDurationException;
import fr.axelallain.raspapijava.exception.RentNotFoundException;
import fr.axelallain.raspapijava.exception.UserMultipleOngoingRentsException;
import fr.axelallain.raspapijava.model.Letterbox;
import fr.axelallain.raspapijava.model.Rent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RentServiceImpl implements RentService {

    @Autowired
    RentDaoInterface rentDaoInterface;

    @Autowired
    LetterboxService letterboxService;

    @Override
    public Rent create(RentDto rentDto) {
        List<Rent> ongoingRents = findAllByUsernameAndStatus(rentDto.getUsername(), "ongoing");
        if (ongoingRents.isEmpty()) {
            Rent rent = new Rent();
            rent.setUsername(rentDto.getUsername());

            Optional<Letterbox> optionalLetterbox = letterboxService.findById(rentDto.getLetterboxId());
            if (optionalLetterbox.isPresent()) {
                Letterbox letterbox = optionalLetterbox.get();
                letterbox.setAvailable(false);
                rent.setLetterbox(letterbox);
            } else {
                throw new LetterboxNotFoundException("No letterbox found for the given id. Rent creation failed.");
            }

            rent.setStartingDate(LocalDateTime.now());

            if (rentDto.getDays() >= 3 && rentDto.getDays() <= 7) {
                Calendar c = Calendar.getInstance();
                c.setTime(Date.from(rent.getStartingDate().atZone(ZoneId.systemDefault()).toInstant()));
                c.add(Calendar.DAY_OF_WEEK, rentDto.getDays());
                Date endingDateCreated = c.getTime();
                rent.setEndingDate(endingDateCreated.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
            } else {
                throw new RentDurationException("Rent duration can only be from 3 days to 7 days.");
            }

            rent.setStatus(rentDto.getStatus());
            return rentDaoInterface.save(rent);
        } else {
            throw new UserMultipleOngoingRentsException("This user already got an ongoing rent.");
        }
    }

    @Override
    public List<Rent> findAllByUsernameAndStatus(String username, String status) {
        // NO EXCEPTION WHEN AN EMPTY LIST IS RETURNED BECAUSE IT CAN BE USEFUL TO GET AN EMPTY LIST.
        return rentDaoInterface.findAllByUsernameAndStatusOrderByStartingDateDesc(username, status);
    }

    @Override
    public Optional<Rent> findById(int id) {
        Optional<Rent> rent = rentDaoInterface.findById(id);
        if (rent.isEmpty()) {
            throw new RentNotFoundException("No rent found for the given id.");
        } else {
            return rent;
        }
    }

    @Override
    public List<Rent> findAllByStatus(String status) {
        // NO EXCEPTION WHEN AN EMPTY LIST IS RETURNED BECAUSE IT CAN BE USEFUL TO GET AN EMPTY LIST.
        return rentDaoInterface.findAllByStatus(status);
    }

    /*
    @Override
    public Rent update(RentDto rentDto) {
        return null;
    }
    */

    @Override
    public void deleteById(int id) {
        Optional<Rent> rent = findById(id);
        if (rent.isEmpty()) {
            throw new RentNotFoundException("No rent found for the given id.");
        } else {
            rentDaoInterface.deleteById(id);
        }
    }

    @Override
    public Rent endRent(int id) {
        Optional<Rent> optionalRent = findById(id);
        if(optionalRent.isEmpty()) {
            throw new RentNotFoundException("No rent found for the given id.");
        } else {
            Rent rent = optionalRent.get();
            rent.setStatus("expired");
            rent.setEndingDate(LocalDateTime.now());

            Optional<Letterbox> optionalLetterbox = letterboxService.findById(rent.getLetterbox().getId());
            if (optionalLetterbox.isEmpty()) {
                throw new LetterboxNotFoundException("No letterbox found for the given rent.");
            } else {
                Letterbox letterbox = optionalLetterbox.get();
                letterbox.setAvailable(true);
            }

            rentDaoInterface.save(rent);
            return rent;
        }
    }
}
