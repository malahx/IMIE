package fr.imie.malah.noteapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import fr.imie.malah.noteapp.model.Note;
import fr.imie.malah.noteapp.utils.CustomTextWatcher;

public class NewNoteActivity extends AppCompatActivity {

    private EditText txtTitle;
    private Button btnAdd;
    private Button btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_note);

        txtTitle = this.findViewById(R.id.txtNewNoteTitle);
        txtTitle.addTextChangedListener(new CustomTextWatcher() {
            @Override
            public void textChanged() {
                if (txtTitle.getText().toString().equals("")) {
                    btnAdd.setEnabled(false);
                } else {
                    btnAdd.setEnabled(true);
                }
            }
        });
        initBtn();
    }

    private void initBtn() {
        btnAdd = this.findViewById(R.id.btnNewNoteAdd);
        btnAdd.setEnabled(false);
        btnAdd.setOnClickListener(v -> {
            Note note = new Note();
            note.setTitle(txtTitle.getText().toString());
            Intent intent = new Intent(NewNoteActivity.this, MainActivity.class);
            intent.putExtra(Constants.NOTE, note);
            setResult(Constants.NEW_NOTE , intent);
            NewNoteActivity.this.finish();
        });

        btnCancel = this.findViewById(R.id.btnNewNoteCancel);

        btnCancel.setOnClickListener(v -> NewNoteActivity.this.finish());
    }
}
