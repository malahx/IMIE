package fr.imie.malah.noteapp.database.base;

import android.database.Cursor;

import java.util.List;

import fr.imie.malah.noteapp.model.AbstractModel;

/**
 * Created by malah on 20/11/17.
 */

public interface DAO<T extends AbstractModel> {

    T save(T t);
    void delete(T t);
    void delete(long id);
    T findById(long id);
    List<T> findAll();
    Cursor cursorAll();
}
