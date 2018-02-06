package fr.imie.malah.abstractfactory;

import fr.imie.malah.abstractfactory.factory.AbstractFactory;
import fr.imie.malah.abstractfactory.factory.FactoryEnum;
import fr.imie.malah.abstractfactory.factory.SelectColor;
import fr.imie.malah.abstractfactory.factory.SelectShape;
import fr.imie.malah.abstractfactory.model.Item;

public class App {

    public static void main(String... args) {

        AbstractFactory abstractFactoryShape = AbstractFactory.getFactory(FactoryEnum.SHAPE);
        AbstractFactory abstractFactoryColor = AbstractFactory.getFactory(FactoryEnum.COLOR);

        Item item = abstractFactoryColor.get(SelectColor.RED);
        item.action();
        item = abstractFactoryColor.get(SelectColor.GREEN);
        item.action();
        item = abstractFactoryColor.get(SelectColor.BLUE);
        item.action();

        item = abstractFactoryShape.get(SelectShape.CIRCLE);
        item.action();
        item = abstractFactoryShape.get(SelectShape.RECTANGLE);
        item.action();
        item = abstractFactoryShape.get(SelectShape.SQUARE);
        item.action();

    }
}
