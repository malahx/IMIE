package fr.imie.malah.tests.unitaire.domain;

import fr.imie.malah.tests.unitaire.domain.impl.CalcImpl;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalcImplTest {

    private CalcImpl calc;

    @Before
    public void setUp() {
        calc = new CalcImpl();
    }

    @Test
    public void shouldMultiplyOne() {
        int result = calc.multiply(1, 1);
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void shouldMultiplyTwo() {
        int result = calc.multiply(1, 2);
        assertThat(result).isEqualTo(2);
    }

    @Test
    public void shouldMultiplyFifteen() {
        int result = calc.multiply(3, 5);
        assertThat(result).isEqualTo(15);
    }

    @Test
    public void shouldMultiplyZero() {
        int result = calc.multiply(0, 1);
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void shouldMultiplyNegative() {
        int result = calc.multiply(3, -1);
        assertThat(result).isEqualTo(-3);
    }

    @Test
    public void shouldMultiplyTwoNegative() {
        int result = calc.multiply(-3, -1);
        assertThat(result).isEqualTo(3);
    }

}