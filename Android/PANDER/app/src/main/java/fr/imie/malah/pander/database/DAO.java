package fr.imie.malah.pander.database;

import android.database.Cursor;

import java.util.List;

/**
 * Created by malah on 27/10/17.
 */

public interface DAO<T> {

    T create(T t);
    void update(T t);
    void delete(T t);
    void delete(long id);
    T read(long id);
    List<T> readAll();
    Cursor cursorAll();
}
