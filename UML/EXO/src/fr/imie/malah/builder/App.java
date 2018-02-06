package fr.imie.malah.builder;

import fr.imie.malah.builder.builder.Builder;
import fr.imie.malah.builder.builder.MealBuilder;
import fr.imie.malah.builder.model.Meal;
import fr.imie.malah.builder.model.Normal;
import fr.imie.malah.builder.model.Pepsi;
import fr.imie.malah.builder.model.Vegan;

public class App {

    public static void main(String... args) {
        Builder<Meal> builder = new MealBuilder();
        builder.addItem(new Vegan());
        builder.addItem(new Pepsi());
        builder.addItem(new Normal());
        Meal meal = builder.build();
        System.out.print(meal.getDetailPrice());
        System.out.println(String.format("Total: %s", meal.getTotalPrice()));
    }
}
