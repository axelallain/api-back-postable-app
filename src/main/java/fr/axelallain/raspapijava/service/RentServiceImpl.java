package fr.axelallain.raspapijava.service;

import fr.axelallain.raspapijava.dao.RentDaoInterface;
import fr.axelallain.raspapijava.dto.RentDto;
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
    public List<Rent> findAllByUsernameAndStatus(String username, String status) {
        return rentDaoInterface.findAllByUsernameAndStatus(username, status);
    }

    @Override
    public Rent save(RentDto rentDto) {
        List<Rent> ongoingRents = findAllByUsernameAndStatus(rentDto.getUsername(), "ongoing");
        if (!ongoingRents.isEmpty()) {
            throw new UserMultipleOngoingRentsException("This user already got an ongoing rent.");
        } else {
            Rent rent = new Rent();
            rent.setUsername(rentDto.getUsername());
            rent.setStatus(rentDto.getStatus());
            return rentDaoInterface.save(rent);
        }
    }

    @Override
    public Optional<Rent> findById(int id) {
        return rentDaoInterface.findById(id);
    }
}
