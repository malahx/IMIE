package fr.imie.malah.tests.unitaire.api;

import fr.imie.malah.tests.unitaire.api.model.DivideResult;
import fr.imie.malah.tests.unitaire.domain.Divide;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static fr.imie.malah.tests.unitaire.api.Api.DIVIDE;
import static fr.imie.malah.tests.unitaire.utils.TestUtils.toJson;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
@RunWith(SpringRunner.class)
public class ApiMockMvcTest {

    private static final int NUMBER = 6;
    private static final int VALUE = 3;
    private static final int RESULT = 2;
    private MockMvc mvc;

    @MockBean
    private Divide mockDivide;

    @Autowired
    private WebApplicationContext context;

    @Before
    public void before() {
        mvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void shouldDivide() throws Exception {

        when(mockDivide.calc(anyInt(), anyInt())).thenReturn(RESULT);

        DivideResult expectedDivideResult = DivideResult.builder().value(RESULT).build();

        String url = DIVIDE.replace("{" + Api.NUMBER + "}", String.valueOf(NUMBER)).replace("{" + VALUE + "}", String.valueOf(VALUE));

        mvc.perform(get(url))
                .andExpect(status().isOk())
                .andExpect(content().json(toJson(expectedDivideResult)));

        verify(mockDivide).calc(NUMBER, VALUE);
    }
}
