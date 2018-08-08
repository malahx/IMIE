package fr.imie.malah.tests.unitaire.domain.impl;

import fr.imie.malah.tests.unitaire.domain.Calc;
import org.springframework.stereotype.Component;

@Component
public class CalcImpl implements Calc {

    public int multiply(int number, int factor) {
        int result = 0;
        for (int j = 1; j <= Math.abs(factor); j++) {
            result += factor > 0 ? number : -number;
        }
        return result;
    }

}
