package fr.axelallain.raspapijava.service;

import fr.axelallain.raspapijava.dao.RentDaoInterface;
import fr.axelallain.raspapijava.dto.RentDto;
import fr.axelallain.raspapijava.exception.RentNotFoundException;
import fr.axelallain.raspapijava.exception.UserMultipleOngoingRentsException;
import fr.axelallain.raspapijava.model.Rent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RentServiceImpl implements RentService {

    @Autowired
    RentDaoInterface rentDaoInterface;

    @Override
    public Rent create(RentDto rentDto) {
        List<Rent> ongoingRents = findAllByUsernameAndStatus(rentDto.getUsername(), "ongoing");
        if (ongoingRents.isEmpty()) {
            Rent rent = new Rent();
            rent.setUsername(rentDto.getUsername());
            rent.setStatus(rentDto.getStatus());
            return rentDaoInterface.save(rent);
        } else {
            throw new UserMultipleOngoingRentsException("This user already got an ongoing rent.");
        }
    }

    @Override
    public List<Rent> findAllByUsernameAndStatus(String username, String status) {
        List<Rent> rents = rentDaoInterface.findAllByUsernameAndStatus(username, status);
        if (rents.isEmpty()) {
            throw new RentNotFoundException("User " + username + " does not have a rent with the status " + status);
        } else {
            return rents;
        }
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
}
