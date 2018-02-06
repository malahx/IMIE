package fr.imie.malah.pander.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by malah on 27/10/17.
 */

public class PanderSQLiteOpenHelper extends SQLiteOpenHelper {

    public static final int CURRENT_DB_VERSION = 3;
    public static final String DB_NAME = "pander.db";

    private String scriptCreation;
    private String scriptDeletion;

    public PanderSQLiteOpenHelper(Context context, String scriptCreation, String scriptDeletion) {
        super(context, DB_NAME, null, CURRENT_DB_VERSION);
        this.scriptCreation = scriptCreation;
        this.scriptDeletion = scriptDeletion;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(scriptCreation);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion < newVersion) {
            db.execSQL(scriptDeletion);
            db.execSQL(scriptCreation);
        }
    }
}
