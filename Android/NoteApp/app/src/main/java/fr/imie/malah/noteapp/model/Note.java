package fr.imie.malah.noteapp.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by malah on 20/11/17.
 */

public class Note extends AbstractModel {
    private String title;
    private String description;
    private List<NoteData> noteDataList = new ArrayList<>();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<NoteData> getNoteDataList() {
        return noteDataList;
    }

    public void setNoteDataList(List<NoteData> noteDataList) {
        this.noteDataList = noteDataList;
    }
}
