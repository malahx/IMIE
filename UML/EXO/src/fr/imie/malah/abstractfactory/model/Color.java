package fr.imie.malah.abstractfactory.model;

public abstract class Color extends Item {

    public Color(String name) {
        super(name);
    }

    private void fill() {
        System.out.println(getName());
    }

    @Override
    public void action() {
        fill();
    }
}
