package fr.imie.malah.tests.unitaire.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class TestUtils {

    public static String toJson(Object object) throws Exception {
        ObjectMapper map = createMapper();
        return map.writeValueAsString(object);
    }

    public static String toJsonArray(Object[] objects) throws Exception {
        ObjectMapper map = createMapper();
        return map.writeValueAsString(objects);
    }

    private static ObjectMapper createMapper() {
        return new ObjectMapper();
    }
}
