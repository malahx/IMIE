package fr.imie.malah.abstractfactory.factory;

import fr.imie.malah.abstractfactory.model.Blue;
import fr.imie.malah.abstractfactory.model.Green;
import fr.imie.malah.abstractfactory.model.Item;
import fr.imie.malah.abstractfactory.model.Red;

public class FactoryColor extends AbstractFactory<SelectColor> {

    @Override
    public Item get(SelectColor select) {
        switch (select) {
            case RED: return new Red();
            case GREEN: return new Green();
            case BLUE: return new Blue();
            default: throw new RuntimeException("Wrong color");
        }
    }

}
