package fr.imie.malah.noteapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;

import fr.imie.malah.noteapp.database.NoteDAO;
import fr.imie.malah.noteapp.database.NoteDataDAO;
import fr.imie.malah.noteapp.fragment.NoteListFragment;
import fr.imie.malah.noteapp.model.Note;

public class MainActivity extends AppCompatActivity {

    private NoteListFragment noteListFragment;
    private FloatingActionButton fab;
    private NoteDAO noteDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        noteDAO = new NoteDAO(this, new NoteDataDAO(this));

        noteListFragment = (NoteListFragment) getFragmentManager().findFragmentById(R.id.frgListNotes);

        initBtn();
    }

    private void initBtn() {
        fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> gotoNewNote());
    }

    private void gotoNewNote() {
        Intent intent = new Intent(MainActivity.this, NewNoteActivity.class);
        MainActivity.this.startActivityForResult(intent, Constants.NEW_NOTE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (resultCode == Constants.NEW_NOTE) {
            Note note = (Note) intent.getExtras().get(Constants.NOTE);
            noteDAO.save(note);
            noteListFragment.refreshList();
        }
    }
}
