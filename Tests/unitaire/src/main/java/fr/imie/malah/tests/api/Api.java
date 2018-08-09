package fr.imie.malah.tests.api;

import fr.imie.malah.tests.api.model.Result;
import fr.imie.malah.tests.domain.Calc;
import fr.imie.malah.tests.domain.Divide;
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
    public static final String WEIGHT = "weight";
    public static final String HEIGHT = "height";
    public static final String DIVIDE = "/calculate/divide/{" + NUMBER + "}/{" + BY + "}";
    public static final String MULTIPLY = "/calculate/multiply/{" + NUMBER + "}/{" + FACTOR + "}";
    public static final String IMC = "/calculate/imc/{" + WEIGHT + "}/{" + HEIGHT + "}";

    private Divide divide;

    private Calc calc;

    @GetMapping(DIVIDE)
    public Result divide(@PathVariable(NUMBER) int number, @PathVariable(BY) int by) {

        return Result.builder()
                .value(divide.calc(number, by))
                .build();
    }

    @GetMapping(MULTIPLY)
    public Result multiply(@PathVariable(NUMBER) int number, @PathVariable(FACTOR) int factor) {

        return Result.builder()
                .value(calc.multiply(number, factor))
                .build();
    }

    @GetMapping(IMC)
    public Result imc(@PathVariable(WEIGHT) int weight, @PathVariable(HEIGHT) int height) {
        return Result.builder()
                .value(calc.imc(weight, height))
                .build();
    }
}
