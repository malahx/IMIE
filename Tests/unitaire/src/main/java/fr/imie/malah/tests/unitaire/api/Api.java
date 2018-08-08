package fr.imie.malah.tests.unitaire.api;

import fr.imie.malah.tests.unitaire.api.model.DivideResult;
import fr.imie.malah.tests.unitaire.api.model.MultiplyResult;
import fr.imie.malah.tests.unitaire.domain.impl.CalcImpl;
import fr.imie.malah.tests.unitaire.domain.impl.DivideImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class Api {

    public static final String NUMBER = "number";
    public static final String BY = "by";
    public static final String FACTOR = "factor";
    public static final String DIVIDE = "/calculate/divide/{" + NUMBER + "}/{" + BY + "}";
    public static final String MULTIPLY = "/calculate/multiply/{" + NUMBER + "}/{" + FACTOR + "}";

    private DivideImpl divide;

    private CalcImpl calc;

    @GetMapping(DIVIDE)
    public DivideResult divide(@PathVariable(NUMBER) int number, @PathVariable(BY) int by) {

        return DivideResult.builder()
                .value(divide.calc(number, by))
                .build();
    }

    @GetMapping(MULTIPLY)
    public MultiplyResult multiply(@PathVariable(NUMBER) int number, @PathVariable(FACTOR) int factor) {

        return MultiplyResult.builder()
                .value(calc.multiply(number, factor))
                .build();
    }
}
