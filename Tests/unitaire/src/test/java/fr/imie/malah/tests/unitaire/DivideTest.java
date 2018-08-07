package fr.imie.malah.tests.unitaire;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DivideTest {

    private Divide divide;

    @Mock
    private Calc mockCalc;

    @Before
    public void setUp() {
        divide = new Divide(mockCalc);
    }

    @Test
    public void shouldDivideTenByOne() {

        int number = 10;

        when(mockCalc.multiply(anyInt(), anyInt())).thenReturn(number);

        int result = divide.calc(number, 1);

        verify(mockCalc).multiply(number, 1);
        assertThat(result).isEqualTo(10);
    }

    @Test
    public void shouldDivideZeroByOne() {

        int number = 0;

        when(mockCalc.multiply(anyInt(), anyInt())).thenReturn(number);

        int result = divide.calc(number, 1);

        verify(mockCalc).multiply(number, 1);
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void shouldDivideZeroByTwo() {

        int number = 0;

        when(mockCalc.multiply(anyInt(), anyInt())).thenReturn(number);

        int result = divide.calc(number, 2);

        verify(mockCalc).multiply(number, 1);
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void shouldDivideThreeByThree() {

        int number = 3;

        when(mockCalc.multiply(anyInt(), anyInt())).thenReturn(number);

        int result = divide.calc(number, 3);

        verify(mockCalc).multiply(number, 1);
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void shouldDivideNegativeByPositive() {

        int number = -3;

        when(mockCalc.multiply(anyInt(), anyInt())).thenReturn(number);

        int result = divide.calc(number, 3);

        verify(mockCalc).multiply(number, 1);
        assertThat(result).isEqualTo(-1);
    }

    @Test
    public void shouldDivideNegativeByNegative() {

        int number = -3;

        when(mockCalc.multiply(anyInt(), anyInt())).thenReturn(number);

        int result = divide.calc(number, -3);

        verify(mockCalc).multiply(number, 1);
        assertThat(result).isEqualTo(1);
    }


    @Test
    public void shouldOtherDivideTwoByOne() {

        int number = 2;
        int by = 1;

        when(mockCalc.multiply(anyInt(), anyInt())).thenReturn(0, by, by * 2, by * 3);

        int result = divide.otherCalc(number, by);

        verify(mockCalc, times(3)).multiply(eq(by), anyInt());
        assertThat(result).isEqualTo(2);
    }

    @Test
    public void shouldOtherDivideZeroByOne() {

        int number = 0;
        int by = 1;

        when(mockCalc.multiply(anyInt(), anyInt())).thenReturn(0, by, by * 2, by * 3);

        int result = divide.otherCalc(number, by);

        verify(mockCalc, times(1)).multiply(by, 0);
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void shouldOtherDivideOneByTwo() {

        int number = 1;
        int by = 2;

        when(mockCalc.multiply(anyInt(), anyInt())).thenReturn(0, by, by * 2, by * 3);

        int result = divide.otherCalc(number, by);

        verify(mockCalc, times(1)).multiply(by, 0);
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void shouldOtherDivideThreeByThree() {

        int number = 3;
        int by = 3;

        when(mockCalc.multiply(anyInt(), anyInt())).thenReturn(0, by, by * 2, by * 3);
        int result = divide.otherCalc(number, by);

        verify(mockCalc, times(2)).multiply(eq(by), anyInt());
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void shouldOtherDivideNegativeByPositive() {

        int number = -3;
        int by = 3;

        when(mockCalc.multiply(anyInt(), anyInt())).thenReturn(0, by, by * 2, by * 3);

        int result = divide.otherCalc(number, by);

        verify(mockCalc, times(2)).multiply(eq(by), anyInt());
        assertThat(result).isEqualTo(-1);
    }

    @Test
    public void shouldOtherDivideNegativeByNegative() {

        int number = -6;
        int by = -3;

        when(mockCalc.multiply(anyInt(), anyInt())).thenReturn(0, by, by * 2, by * 3);

        int result = divide.otherCalc(number, by);

        verify(mockCalc, times(3)).multiply(eq(by), anyInt());
        assertThat(result).isEqualTo(2);
    }

    @Test
    public void shouldOtherDividePositiveByNegative() {

        int number = 6;
        int by = -3;

        when(mockCalc.multiply(anyInt(), anyInt())).thenReturn(0, by, by * 2, by * 3);

        int result = divide.otherCalc(number, by);

        verify(mockCalc, times(3)).multiply(eq(by), anyInt());
        assertThat(result).isEqualTo(-2);
    }

}
