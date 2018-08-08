package fr.imie.malah.tests.unitaire.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class TestUtils {

    public static String toJson(Object object) throws Exception {
        return new ObjectMapper().writeValueAsString(object);
    }

    public static String toJsonArray(Object[] objects) throws Exception {
        return new ObjectMapper().writeValueAsString(objects);
    }
}
