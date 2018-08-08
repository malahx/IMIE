package fr.imie.malah.tests.unitaire.domain.impl;

import fr.imie.malah.tests.unitaire.domain.Calc;

public class CalcImpl implements Calc {

    public int multiply(int number, int factor) {
        int result = 0;
        for (int j = 1; j <= Math.abs(factor); j++) {
            result += factor > 0 ? number : -number;
        }
        return result;
    }

    @Override
    public int imc(int weight, float height) {
        return weight / (int) Math.pow(height, 2);
    }

}
