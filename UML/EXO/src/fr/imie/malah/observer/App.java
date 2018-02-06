package fr.imie.malah.observer;

public class App {
    public static void main(String... args) {
        Data data = new Data();
        data.addListener(new BinObserver());
        data.addListener(new HexaObserver());
        data.addListener(new OctalObserver());
        data.setEntier(10);
        data.setEntier(5);
        data.setEntier(20);
    }
}
