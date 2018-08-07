package fr.imie.malah.tests.unitaire;

public class Calc {

    public int multiply(int number, int factor) {
        int result = 0;
        for (int j = 1; j <= Math.abs(factor); j++) {
            result += factor > 0 ? number : -number;
        }
        return result;
    }

}