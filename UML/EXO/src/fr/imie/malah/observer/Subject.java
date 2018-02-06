package fr.imie.malah.observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {
    private List<Observer> observers = new ArrayList<>();
    public void addListener(Observer observer) {
        observers.add(observer);
    }
    public void update() {
        observers.forEach(o -> o.update(this));
    }
}
