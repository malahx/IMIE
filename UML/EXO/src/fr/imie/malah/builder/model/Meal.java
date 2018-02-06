package fr.imie.malah.builder.model;

import java.util.ArrayList;
import java.util.List;

public class Meal {

    private List<Item> itemList = new ArrayList<>();

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public double getTotalPrice() {
        double value = 0;
        for (Item item :
                itemList) {
            value += item.getPrice();
        }
        return value;
    }

    public String getDetailPrice() {
        final StringBuilder sb = new StringBuilder();
        itemList.forEach(it -> sb.append(it.getName()).append("(").append(it.getPackaging().getName()).append("): ").append(it.getPrice()).append("\n"));
        return sb.toString();
    }
}
