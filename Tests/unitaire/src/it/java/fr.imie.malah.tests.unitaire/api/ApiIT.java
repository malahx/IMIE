package fr.imie.malah.tests.unitaire.api;

import fr.imie.malah.tests.unitaire.api.model.Result;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static fr.imie.malah.tests.unitaire.utils.TestUtils.toJson;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ApiIT {

    private static final int NUMBER = 6;
    private static final int VALUE = 3;
    private static final int IMC = NUMBER / (int) Math.pow(VALUE, 2);

    @Autowired
    private MockMvc mvc;

    @Test
    public void shouldDivide() throws Exception {

        Result expectedResult = Result.builder()
                .value(2)
                .build();

        String url = Api.DIVIDE.replace("{" + Api.NUMBER + "}", String.valueOf(NUMBER)).replace("{" + Api.BY + "}", String.valueOf(VALUE));

        mvc.perform(get(url))
                .andExpect(status().isOk())
                .andExpect(content().json(toJson(expectedResult)));
    }

    @Test
    public void shouldMultiply() throws Exception {

        Result expectedResult = Result.builder()
                .value(18)
                .build();

        String url = Api.MULTIPLY.replace("{" + Api.NUMBER + "}", String.valueOf(NUMBER)).replace("{" + Api.FACTOR + "}", String.valueOf(VALUE));

        mvc.perform(get(url))
                .andExpect(status().isOk())
                .andExpect(content().json(toJson(expectedResult)));

    }

    @Test
    public void shouldCalculateImc() throws Exception {

        Result expectedResult = Result.builder()
                .value(IMC)
                .build();

        String url = Api.IMC.replace("{" + Api.WEIGHT + "}", String.valueOf(NUMBER)).replace("{" + Api.HEIGHT + "}", String.valueOf(VALUE));

        mvc.perform(get(url))
                .andExpect(status().isOk())
                .andExpect(content().json(toJson(expectedResult)));

    }
}
