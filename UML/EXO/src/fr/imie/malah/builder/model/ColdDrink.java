package fr.imie.malah.builder.model;

public class ColdDrink extends Item {
    public ColdDrink(String name, double price) {
        super(name, price, new Bottle());
    }
}
