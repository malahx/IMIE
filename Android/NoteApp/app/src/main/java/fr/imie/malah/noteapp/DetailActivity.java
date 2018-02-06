package fr.imie.malah.noteapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;

import fr.imie.malah.noteapp.database.NoteDAO;
import fr.imie.malah.noteapp.database.NoteDataDAO;
import fr.imie.malah.noteapp.fragment.DataListFragment;
import fr.imie.malah.noteapp.model.Note;
import fr.imie.malah.noteapp.model.NoteData;

public class DetailActivity extends AppCompatActivity {

    private DataListFragment dataListFragment;
    private NoteDAO noteDAO;

    private Note note;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        noteDAO = new NoteDAO(this, new NoteDataDAO(this));

        dataListFragment = (DataListFragment) getFragmentManager().findFragmentById(R.id.frgDataList);

        note = (Note) getIntent().getExtras().get(Constants.NOTE);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> gotoNewData());

    }

    private void gotoNewData() {
        Intent intent = new Intent(DetailActivity.this, NewDataActivity.class);
        DetailActivity.this.startActivityForResult(intent, Constants.NEW_DATA);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (resultCode == Constants.NEW_DATA) {
            addNewData(intent);
        }
        if (resultCode == Constants.EDIT_DATA) {
            updateData(intent);
        }
    }

    private void updateData(Intent intent) {
        NoteData data = (NoteData) intent.getExtras().get(Constants.DATA);
        note.getNoteDataList().forEach(d -> {
            if (d.getId().equals(data.getId())) {
                d.setData(data.getData());
            }
        });
        noteDAO.save(note);
        dataListFragment.refreshList();
    }

    private void addNewData(Intent intent) {
        NoteData noteData = new NoteData();
        noteData.setData(intent.getExtras().getString(Constants.DATA_TEXT));
        noteData.setNote(note);
        note.getNoteDataList().add(noteData);
        noteDAO.save(note);
        dataListFragment.refreshList();
    }
}
