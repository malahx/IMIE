package fr.imie.malah.noteapp.database.base;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by malah on 20/11/17.
 */

public class NoteAppSQLiteOpenHelper extends SQLiteOpenHelper {

    public static final int CURRENT_DB_VERSION = 4;
    public static final String DB_NAME = "noteapp.db";

    private static NoteAppSQLiteOpenHelper instance;
    private Context context;

    private List<DAOManagement> daoManagements;

    public static NoteAppSQLiteOpenHelper getInstance(Context context) {
        if (instance == null || instance.context != context) {
            instance = new NoteAppSQLiteOpenHelper(context);
            instance.context = context;
        }
        return instance;
    }

    private NoteAppSQLiteOpenHelper(Context context) {
        super(context, DB_NAME, null, CURRENT_DB_VERSION);
        daoManagements = new ArrayList<>();
    }

    public List<DAOManagement> getDaoManagements() {
        return daoManagements;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        daoManagements.forEach(m -> db.execSQL(m.getScriptCreation()));
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion < newVersion) {
            daoManagements.forEach(m -> {
                db.execSQL(m.getScriptDeletion());
                db.execSQL(m.getScriptCreation());
            });
        }
    }
}
