package fr.imie.malah.noteapp.database.contracts;

import android.content.Context;

import fr.imie.malah.noteapp.database.base.AbstractDAO;
import fr.imie.malah.noteapp.model.Note;

/**
 * Created by malah on 20/11/17.
 */

public abstract class NoteContract extends AbstractDAO<Note> {

    public static final String TABLE = "note";
    public static final String ID = "_id";
    public static final String COL_ID_TYPE = "INTEGER PRIMARY KEY AUTOINCREMENT";
    public static final String TITLE = "title";
    public static final String DESCRIPTION = "description";

    public static final String[] COLS = new String[]{ID, TITLE, DESCRIPTION};

    protected NoteContract(Context context) {
        super(context);
    }

    @Override
    public String getId() {
        return ID;
    }

    @Override
    protected String getTable() {
        return TABLE;
    }

    @Override
    protected String[] getColumns() {
        return COLS;
    }

    @Override
    public String getScriptCreation() {
        return String.format(
                "CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, %s VARCHAR(128), %s VARCHAR(128))",
                TABLE,
                ID,
                TITLE,
                DESCRIPTION);
    }

    @Override
    public String getScriptDeletion() {
        return String.format(
                "DROP TABLE %s",
                TABLE);
    }

}
