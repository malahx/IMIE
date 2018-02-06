package fr.imie.malah.designpattern;

import fr.imie.malah.designpattern.controller.Controller;

public class Application {

    public static void main(String... args) {
        Controller.getInstance().run();
    }
}
