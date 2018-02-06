package fr.imie.malah.designpattern.dao;

import java.util.List;

public interface Crud<T> {
    void create(T object);
    void update(T object);
    void delete(T object);
    T read(int id);
    List<T> readAll();
}
