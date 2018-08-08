package fr.imie.malah.tests.unitaire.domain.impl;

import fr.imie.malah.tests.unitaire.domain.Calc;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class DivideImpl {

    private Calc calc;

    public int calc(int number, int by) {
        if (by == 0) {
            throw new RuntimeException("Divide by 0");
        }
        int i = 0;
        int interval = Integer.signum(number) == Integer.signum(by) ? 1 : -1;
        number = Math.abs(number);
        while (true) {
            int multiply = Math.abs(calc.multiply(by, i));
            if (multiply == number) {
                return i;
            }
            if (multiply > number) {
                return i - interval;
            }
            i += interval;
        }
    }
}