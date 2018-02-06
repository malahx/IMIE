package fr.imie.malah.noteapp.model;

import java.io.Serializable;

/**
 * Created by malah on 20/11/17.
 */

public abstract class AbstractModel implements Serializable {

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
