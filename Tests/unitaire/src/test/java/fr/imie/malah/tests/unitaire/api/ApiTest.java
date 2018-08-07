package fr.imie.malah.tests.unitaire.api;

import fr.imie.malah.tests.unitaire.api.model.DivideResult;
import fr.imie.malah.tests.unitaire.domain.Divide;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ApiTest {

    private static final int VALUE = 5;

    private Api api;

    @Mock
    private Divide mockDivide;

    @Before
    public void setUp() {
        api = new Api(mockDivide);
    }

    @Test
    public void shouldDivide() {

        when(mockDivide.calc(anyInt(), anyInt())).thenReturn(VALUE);

        DivideResult divideResult = api.divide(1, 2);

        assertThat(divideResult).isNotNull();
        assertThat(divideResult.getValue()).isEqualTo(VALUE);
    }
}
