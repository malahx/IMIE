package fr.imie.malah.tests.unitaire.domain.impl;

import fr.imie.malah.tests.unitaire.domain.Divide;
import fr.imie.malah.tests.unitaire.domain.Multiply;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class DivideImpl implements Divide {

    private Multiply multiply;

    public int calc(int number, int by) {
        if (by == 0) {
            throw new RuntimeException("Divide by 0");
        }
        int i = 0;
        int interval = Integer.signum(number) == Integer.signum(by) ? 1 : -1;
        number = Math.abs(number);
        while (true) {
            int multiply = Math.abs(this.multiply.multiply(by, i));
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
