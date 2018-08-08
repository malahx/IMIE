package fr.imie.malah.tests.unitaire;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.imie.malah.tests.unitaire.client.CalcClient;
import fr.imie.malah.tests.unitaire.domain.Calc;
import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public Calc calc() {
        return new CalcClient(new OkHttpClient(), new ObjectMapper());
    }

}
