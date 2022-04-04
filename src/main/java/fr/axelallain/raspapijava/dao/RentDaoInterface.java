package fr.axelallain.raspapijava.dao;

import fr.axelallain.raspapijava.model.Rent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentDaoInterface extends JpaRepository<Rent, Integer> {

    List<Rent> findAllByUsernameAndStatusOrderByEndingDateDesc(String username, String status);
}
