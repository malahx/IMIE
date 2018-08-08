package fr.imie.malah.tests.unitaire.api;

import fr.imie.malah.tests.unitaire.api.model.Result;
import fr.imie.malah.tests.unitaire.domain.Calc;
import fr.imie.malah.tests.unitaire.domain.impl.DivideImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyFloat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ApiTest {

    private static final int VALUE = 5;

    private Api api;

    @Mock
    private DivideImpl mockDivide;

    @Mock
    private Calc mockCalc;

    @Before
    public void setUp() {
        api = new Api(mockDivide, mockCalc);
    }

    @Test
    public void shouldDivide() {

        when(mockDivide.calc(anyInt(), anyInt())).thenReturn(VALUE);

        Result result = api.divide(1, 2);

        verify(mockDivide).calc(1, 2);

        assertThat(result).isNotNull();
        assertThat(result.getValue()).isEqualTo(VALUE);
    }

    @Test
    public void shouldMultiply() {

        when(mockCalc.multiply(anyInt(), anyInt())).thenReturn(VALUE);

        Result result = api.multiply(1, 2);

        verify(mockCalc).multiply(1, 2);

        assertThat(result).isNotNull();
        assertThat(result.getValue()).isEqualTo(VALUE);
    }

    @Test
    public void shouldCalculateImc() {

        when(mockCalc.imc(anyInt(), anyFloat())).thenReturn(VALUE);

        Result result = api.imc(1, 2);

        verify(mockCalc).imc(1, 2);

        assertThat(result).isNotNull();
        assertThat(result.getValue()).isEqualTo(VALUE);
    }
}
