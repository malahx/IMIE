package fr.imie.malah.tests.unitaire;

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

}
