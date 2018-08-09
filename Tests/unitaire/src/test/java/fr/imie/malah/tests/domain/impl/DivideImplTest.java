package fr.imie.malah.tests.domain.impl;

import fr.imie.malah.tests.domain.Calc;
import fr.imie.malah.tests.domain.Divide;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DivideImplTest {

    private Divide divide;

    @Mock
    private Calc mockCalc;

    @Before
    public void setUp() {
        divide = new DivideImpl(mockCalc);
    }

    @Test
    public void shouldDivideTwoByOne() {

        int number = 2;
        int by = 1;

        when(mockCalc.multiply(anyInt(), anyInt())).thenReturn(0, by, by * 2, by * 3);

        int result = divide.calc(number, by);

        verify(mockCalc).multiply(by, 0);
        verify(mockCalc).multiply(by, 1);
        verify(mockCalc).multiply(by, 2);
        assertThat(result).isEqualTo(2);
    }

    @Test
    public void shouldDivideZeroByOne() {

        int number = 0;
        int by = 1;

        when(mockCalc.multiply(anyInt(), anyInt())).thenReturn(0, by, by * 2, by * 3);

        int result = divide.calc(number, by);

        verify(mockCalc).multiply(by, 0);
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void shouldDivideOneByTwo() {

        int number = 1;
        int by = 2;

        when(mockCalc.multiply(anyInt(), anyInt())).thenReturn(0, by, by * 2, by * 3);

        int result = divide.calc(number, by);

        verify(mockCalc).multiply(by, 0);
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void shouldDivideThreeByThree() {

        int number = 3;
        int by = 3;

        when(mockCalc.multiply(anyInt(), anyInt())).thenReturn(0, by, by * 2, by * 3);
        int result = divide.calc(number, by);

        verify(mockCalc).multiply(by, 0);
        verify(mockCalc).multiply(by, 1);
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void shouldDivideNegativeByPositive() {

        int number = -3;
        int by = 3;

        when(mockCalc.multiply(anyInt(), anyInt())).thenReturn(0, by, by * 2, by * 3);

        int result = divide.calc(number, by);

        verify(mockCalc).multiply(by, 0);
        verify(mockCalc).multiply(by, -1);
        assertThat(result).isEqualTo(-1);
    }

    @Test
    public void shouldDivideNegativeByNegative() {

        int number = -6;
        int by = -3;

        when(mockCalc.multiply(anyInt(), anyInt())).thenReturn(0, by, by * 2, by * 3);

        int result = divide.calc(number, by);

        verify(mockCalc).multiply(by, 0);
        verify(mockCalc).multiply(by, 1);
        verify(mockCalc).multiply(by, 2);
        assertThat(result).isEqualTo(2);
    }

    @Test
    public void shouldDividePositiveByNegative() {

        int number = 6;
        int by = -3;

        when(mockCalc.multiply(anyInt(), anyInt())).thenReturn(0, by, by * 2, by * 3);

        int result = divide.calc(number, by);

        verify(mockCalc).multiply(by, 0);
        verify(mockCalc).multiply(by, -1);
        verify(mockCalc).multiply(by, -2);
        assertThat(result).isEqualTo(-2);
    }

    @Test
    public void shouldDividePositiveByPositive() {

        int number = 24;
        int by = 6;

        when(mockCalc.multiply(anyInt(), anyInt())).thenReturn(0, by, by * 2, by * 3, by * 4);

        int result = divide.calc(number, by);

        verify(mockCalc).multiply(by, 0);
        verify(mockCalc).multiply(by, 1);
        verify(mockCalc).multiply(by, 2);
        verify(mockCalc).multiply(by, 3);
        verify(mockCalc).multiply(by, 4);
        assertThat(result).isEqualTo(4);
    }

    @Test(expected = RuntimeException.class)
    public void shouldDividePositiveByZero() {

        int number = 24;
        int by = 0;

        divide.calc(number, by);
    }

}
