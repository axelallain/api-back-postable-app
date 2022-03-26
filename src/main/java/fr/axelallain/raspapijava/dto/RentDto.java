package fr.axelallain.raspapijava.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.axelallain.raspapijava.model.GoogleUser;
import fr.axelallain.raspapijava.model.Letterbox;

public class RentDto {

    @JsonProperty("username")
    private String username;

    @JsonProperty("letterbox")
    private Letterbox letterbox;

    @JsonProperty("googleUser")
    private GoogleUser googleUser;

    @JsonProperty("status")
    private String status;

    public RentDto() {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
