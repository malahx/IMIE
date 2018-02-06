package fr.imie.malah.builder.builder;

import fr.imie.malah.builder.model.Item;

public interface Builder<T> {
    Builder addItem(Item item);

    T build();
}
