package fr.imie.malah.tests.unitaire;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Divide {

    private Calc calc;

    public int calc(int number, int by) {
        return calc.multiply(number, 1) / by;
    }
}
