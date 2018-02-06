package fr.imie.malah.httpclientdemo.utils;

import android.content.Context;

import org.json.JSONObject;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * Created by malah on 12/12/17.
 */

public class FileUtils {
    public static void save(Context context, String filename, JSONObject json) {
        ArrayList<String> keys = new ArrayList<>();
        json.keys().forEachRemaining(keys::add);
        try {
            FileOutputStream outputStream = context.openFileOutput(filename, Context.MODE_PRIVATE);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(keys);
            objectOutputStream.close();
            outputStream.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
