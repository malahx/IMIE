package fr.imie.malah.noteapp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import fr.imie.malah.noteapp.database.contracts.NoteContract;
import fr.imie.malah.noteapp.model.Note;

/**
 * Created by malah on 20/11/17.
 */

public class NoteDAO extends NoteContract {

    private NoteDataDAO noteDataDAO;

    public NoteDAO(Context context, NoteDataDAO noteDataDAO) {
        super(context);
        this.noteDataDAO = noteDataDAO;
    }

    @Override
    protected ContentValues parseFromModel(Note note) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ID, note.getId());
        contentValues.put(TITLE, note.getTitle());
        contentValues.put(DESCRIPTION, note.getDescription());
        return contentValues;
    }

    @Override
    public Note parseFromCursor(Cursor cursor) {
        int iId = cursor.getColumnIndex(ID);
        int iTitle = cursor.getColumnIndex(TITLE);
        int iDescription = cursor.getColumnIndex(DESCRIPTION);
        Note note = new Note();
        note.setId(cursor.getLong(iId));
        note.setTitle(cursor.getString(iTitle));
        note.setDescription(cursor.getString(iDescription));
        note.setNoteDataList(noteDataDAO.findByNote(note));
        return note;
    }

    @Override
    public Note save(Note note) {
        if (note == null) {
            return null;
        }
        Note result = super.save(note);
        note.getNoteDataList().forEach(nd -> noteDataDAO.save(nd));
        return result;
    }

    @Override
    public void delete(Note note) {
        if (note == null || note.getId() == null) {
            return;
        }
        note.getNoteDataList().forEach(nd -> {
            if (nd.getId() == null) {
                return;
            }
            noteDataDAO.delete(nd);
        });
        super.delete(note);
    }

    @Override
    public void delete(long id) {
        getDb().delete(NoteDataDAO.TABLE, String.format("%s = ?", NoteDataDAO.ID_NOTE), new String[]{Long.toString(id)});
        super.delete(id);
    }

}
