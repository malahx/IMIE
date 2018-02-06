package fr.imie.malah.observer;

public class OctalObserver extends Observer<Data> {
    @Override
    public void update(Data data) {
        System.out.println(Integer.toString(data.getEntier(),8));
    }
}
