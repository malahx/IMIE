package fr.imie.malah.tests.unitaire;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Divide {

    private Calc calc;

    public int calc(int number, int by) {
        int i = 0;
        boolean sign = Integer.signum(number) == Integer.signum(by);
        int numberAbs = Math.abs(number);
        while (true) {
            int multiply = Math.abs(calc.multiply(by, i));
            if (multiply == numberAbs) {
                return i;
            }
            if (multiply > numberAbs) {
                return sign ? i - 1 : i + 1;
            }
            i += sign ? 1 : -1;
        }
    }
}
