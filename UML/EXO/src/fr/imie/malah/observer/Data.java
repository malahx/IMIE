package fr.imie.malah.observer;

public class Data extends Subject {
    private int entier;

    public int getEntier() {
        return entier;
    }

    public void setEntier(int entier) {
        this.entier = entier;
        this.update();
    }
}
