package fr.imie.malah.builder.model;

public class Burger extends Item {
    public Burger(String name, double price) {
        super(name, price, new Box());
    }
}
