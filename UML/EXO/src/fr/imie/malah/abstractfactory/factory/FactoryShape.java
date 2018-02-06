package fr.imie.malah.abstractfactory.factory;

import fr.imie.malah.abstractfactory.model.*;

public class FactoryShape extends AbstractFactory<SelectShape> {

    @Override
    public Item get(SelectShape select) {
        switch (select) {
            case SQUARE: return new Square();
            case RECTANGLE: return new Rectangle();
            case CIRCLE: return new Circle();
            default: throw new RuntimeException("Wrong shape");
        }
    }

}
