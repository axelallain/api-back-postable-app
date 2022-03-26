package fr.axelallain.raspapijava.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Collection;

@Entity
@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class,property="@id", scope=GoogleUser.class)
public class GoogleUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "googleUser")
    private Collection<Rent> rent;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Rent> getRent() {
        return rent;
    }

    public void setRent(Collection<Rent> rent) {
        this.rent = rent;
    }

    @Override
    public String toString() {
        return "GoogleUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rent=" + rent +
                '}';
    }
}
