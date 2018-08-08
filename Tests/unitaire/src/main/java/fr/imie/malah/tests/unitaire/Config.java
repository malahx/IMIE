package fr.imie.malah.tests.unitaire;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.imie.malah.tests.unitaire.client.MultiplyClient;
import fr.imie.malah.tests.unitaire.domain.Calc;
import fr.imie.malah.tests.unitaire.domain.Multiply;
import fr.imie.malah.tests.unitaire.domain.impl.CalcImpl;
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
