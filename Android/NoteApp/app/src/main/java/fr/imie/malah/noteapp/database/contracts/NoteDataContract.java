package fr.imie.malah.noteapp.database.contracts;

import android.content.Context;

import fr.imie.malah.noteapp.database.base.AbstractDAO;
import fr.imie.malah.noteapp.model.NoteData;

/**
 * Created by malah on 20/11/17.
 */

public abstract class NoteDataContract extends AbstractDAO<NoteData> {

    public static final String TABLE = "note_data";
    public static final String ID = "_id";
    public static final String DATA = "data";
    public static final String ID_NOTE = "note_id";

    public static final String[] COLS = new String[] {ID, DATA, ID_NOTE};

    protected NoteDataContract(Context context) {
        super(context);
    }

    @Override
    protected String getId() {
        return ID;
    }

    @Override
    protected String[] getColumns() {
        return COLS;
    }

    @Override
    protected String getTable() {
        return TABLE;
    }

    @Override
    public String getScriptCreation() {
        return String.format(
                "CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, %s VARCHAR(128), %s INTEGER)",
                TABLE,
                ID,
                DATA,
                ID_NOTE);
    }

    @Override
    public String getScriptDeletion() {
        return String.format(
                "DROP TABLE %s",
                TABLE);
    }
}
