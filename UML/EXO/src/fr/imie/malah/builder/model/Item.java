package fr.imie.malah.builder.model;

public abstract class Item {

    private String name;
    private double price;
    private Packaging packaging;

    public Item(String name, double price, Packaging packaging) {
        this.name = name;
        this.price = price;
        this.packaging = packaging;
    }

    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public Packaging getPackaging() {
        return packaging;
    }
}
