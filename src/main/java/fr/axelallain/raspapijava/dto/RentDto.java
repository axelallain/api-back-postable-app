package fr.axelallain.raspapijava.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.axelallain.raspapijava.model.GoogleUser;
import fr.axelallain.raspapijava.model.Letterbox;

import java.time.LocalDateTime;

public class RentDto {

    @JsonProperty("username")
    private String username;

    @JsonProperty("letterbox_id")
    private int letterboxId;

    @JsonProperty("status")
    private String status;

    @JsonProperty("days")
    private int days;

    public RentDto() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getLetterboxId() {
        return letterboxId;
    }

    public void setLetterboxId(int letterboxId) {
        this.letterboxId = letterboxId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }
}
