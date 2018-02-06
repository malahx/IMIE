package fr.imie.malah.abstractfactory.factory;

import fr.imie.malah.abstractfactory.model.Item;

public abstract class AbstractFactory<T> {

    public static AbstractFactory getFactory(FactoryEnum factoryEnum) {

        switch (factoryEnum) {
            case COLOR: return new FactoryColor();
            case SHAPE: return new FactoryShape();
            default: throw new RuntimeException("Wrong factory type");
        }
    }

    public abstract Item get(T select);

}
