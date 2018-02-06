package fr.imie.malah.pander.model;

import java.io.Serializable;

/**
 * Created by malah on 24/10/17.
 */

public class Contact extends AbstractModel implements Serializable {

    private long id;
    private String photoPath;
    private String firstname;
    private String lastname;
    private String description;

    public Contact() {
    }

    public Contact(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Contact(String firstname, String lastname, String description) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String displayName() {
        return String.format("%s %s", getFirstname(), getLastname());
    }
}
