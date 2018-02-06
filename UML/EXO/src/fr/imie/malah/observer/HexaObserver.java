package fr.imie.malah.observer;

public class HexaObserver extends Observer<Data> {
    @Override
    public void update(Data data) {
        System.out.println(Integer.toHexString(data.getEntier()));
    }
}
