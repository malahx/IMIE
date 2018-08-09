package fr.imie.malah.tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.imie.malah.tests.client.MultiplyClient;
import fr.imie.malah.tests.domain.Calc;
import fr.imie.malah.tests.domain.Multiply;
import fr.imie.malah.tests.domain.impl.CalcImpl;
import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public Multiply multiply() {
        return new MultiplyClient(new OkHttpClient(), new ObjectMapper());
    }

    @Bean
    public Calc calc() {
        return new CalcImpl();
    }

}
