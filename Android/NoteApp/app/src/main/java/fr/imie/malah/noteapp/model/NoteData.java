package fr.imie.malah.noteapp.model;

/**
 * Created by malah on 20/11/17.
 */

public class NoteData extends AbstractModel {
    private Note note;
    private String data;

    public Note getNote() {
        return note;
    }

    public void setNote(Note note) {
        this.note = note;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
