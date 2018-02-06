package fr.imie.malah.observer;

public abstract class Observer<T> {
    public abstract void update(T subject);
}
