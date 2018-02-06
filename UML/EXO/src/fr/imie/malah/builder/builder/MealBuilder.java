package fr.imie.malah.builder.builder;

import fr.imie.malah.builder.model.Item;
import fr.imie.malah.builder.model.Meal;

import java.util.ArrayList;
import java.util.List;

public class MealBuilder implements Builder<Meal> {

    private List<Item> itemList = new ArrayList<>();

    @Override
    public Builder addItem(Item item) {
        itemList.add(item);
        return this;
    }

    @Override
    public Meal build() {
        Meal meal = new Meal();
        meal.setItemList(itemList);
        return meal;
    }
}
