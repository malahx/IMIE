package fr.imie.malah.noteapp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import fr.imie.malah.noteapp.database.contracts.NoteDataContract;
import fr.imie.malah.noteapp.model.Note;
import fr.imie.malah.noteapp.model.NoteData;

/**
 * Created by malah on 20/11/17.
 */

public class NoteDataDAO extends NoteDataContract {

    public NoteDataDAO(Context context) {
        super(context);
    }

    @Override
    public NoteData parseFromCursor(Cursor cursor) {
        int iId = cursor.getColumnIndex(ID);
        int iData = cursor.getColumnIndex(DATA);
        NoteData noteData = new NoteData();
        noteData.setId(cursor.getLong(iId));
        noteData.setData(cursor.getString(iData));
        return noteData;
    }

    @Override
    protected ContentValues parseFromModel(NoteData noteData) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ID, noteData.getId());
        contentValues.put(DATA, noteData.getData());
        contentValues.put(ID_NOTE, noteData.getNote().getId());
        return contentValues;
    }

    public List<NoteData> findByNote(Note note) {
        List<NoteData> noteDataList = new ArrayList<>();
        Cursor cursor = getDb().query(getTable(), getColumns(), String.format("%s = ?", ID_NOTE), new String[]{Long.toString(note.getId())}, null, null, null);
        while ((cursor.isBeforeFirst() ? cursor.moveToFirst() : cursor.moveToNext())) {
            NoteData noteData = parseFromCursor(cursor);
            noteData.setNote(note);
            noteDataList.add(noteData);
        }
        cursor.close();
        return noteDataList;
    }
}
