package fr.imie.malah.observer;

public class BinObserver extends Observer<Data> {
    @Override
    public void update(Data data) {
        System.out.println(Integer.toBinaryString(data.getEntier()));
    }
}
