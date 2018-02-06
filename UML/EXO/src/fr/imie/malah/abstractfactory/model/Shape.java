package fr.imie.malah.abstractfactory.model;

public abstract class Shape extends Item {

    public Shape(String name) {
        super(name);
    }

    private void draw() {
        System.out.println(getName());
    }

    @Override
    public void action() {
        draw();
    }
}
