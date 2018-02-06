package fr.imie.malah.abstractfactory.model;

public abstract class Item {

    private String name;

    public Item(String name) {
        this.name = name;
    }

    public abstract void action();

    public String getName() {
        return name;
    }
}
