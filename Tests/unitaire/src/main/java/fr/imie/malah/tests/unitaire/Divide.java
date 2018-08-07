package fr.imie.malah.tests.unitaire;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Divide {

    private Calc calc;

    public int calc(int number, int by) {
        int i = 0;
        boolean sign = Integer.signum(number) == Integer.signum(by);
        while (true) {
           int multiply = calc.multiply(by, i);
            if (Math.abs(multiply) == Math.abs(number)) {
                return i;
            }
            if (Math.abs(multiply) > Math.abs(number)) {
                return sign ? i - 1 : i + 1;
            }
            i += sign ? 1 : -1;
        }
    }
}
