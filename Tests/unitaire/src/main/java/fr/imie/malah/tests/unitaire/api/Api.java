package fr.imie.malah.tests.unitaire.api;

import fr.imie.malah.tests.unitaire.api.model.DivideResult;
import fr.imie.malah.tests.unitaire.domain.Divide;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class Api {

    public static final String NUMBER = "number";
    public static final String BY = "by";
    public static final String DIVIDE = "/calculate/divide/{" + NUMBER + "}/{" + BY + "}";

    private Divide divide;

    @GetMapping(DIVIDE)
    public DivideResult divide(@PathVariable(NUMBER) int number, @PathVariable(BY) int by) {

        DivideResult divideResult = DivideResult.builder()
                .value(divide.calc(number, by))
                .build();

        return divideResult;
    }
}
