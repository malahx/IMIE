package fr.imie.malah.httpclientdemo.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import fr.imie.malah.httpclientdemo.testclient.entity.Post;

/**
 * Created by malah on 11/12/17.
 */

public class JsonUtils {
    public static List<Post> fromJson(String json) {
        try {
            return new ObjectMapper().readValue(json, new TypeReference<List<Post>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
