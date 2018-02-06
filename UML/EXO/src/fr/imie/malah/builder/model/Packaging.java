package fr.imie.malah.builder.model;

public abstract class Packaging {
    private String name;

    public Packaging(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
