package fr.axelallain.raspapijava.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Rent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String username;

    @ManyToOne
    @JoinColumn(name = "letterbox_id", nullable = false)
    private Letterbox letterbox;

    @ManyToOne
    @JoinColumn(name = "googleUser_id")
    private GoogleUser googleUser;

    @Column(name = "starting_date", nullable = false)
    private LocalDateTime startingDate;

    @Column(name = "ending_date", nullable = false)
    private LocalDateTime endingDate;

    @Column(nullable = false)
    private String status;

    public Rent() {

    }

    public Rent(int id, String username, String status) {
        this.id = id;
        this.username = username;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Letterbox getLetterbox() {
        return letterbox;
    }

    public void setLetterbox(Letterbox letterbox) {
        this.letterbox = letterbox;
    }

    public GoogleUser getGoogleUser() {
        return googleUser;
    }

    public void setGoogleUser(GoogleUser googleUser) {
        this.googleUser = googleUser;
    }

    public LocalDateTime getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(LocalDateTime startingDate) {
        this.startingDate = startingDate;
    }

    public LocalDateTime getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(LocalDateTime endingDate) {
        this.endingDate = endingDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Rent{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", letterbox=" + letterbox +
                ", googleUser=" + googleUser +
                ", startingDate=" + startingDate +
                ", endingDate=" + endingDate +
                ", status='" + status + '\'' +
                '}';
    }
}
