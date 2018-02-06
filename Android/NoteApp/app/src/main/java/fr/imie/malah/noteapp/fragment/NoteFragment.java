package fr.imie.malah.noteapp.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import fr.imie.malah.noteapp.Constants;
import fr.imie.malah.noteapp.R;
import fr.imie.malah.noteapp.model.Note;


public class NoteFragment extends Fragment {

    private String title;

    private TextView lblNoteTitle;

    public NoteFragment() {
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getActivity().getIntent().hasExtra(Constants.NOTE)) {
            Note note = (Note) getActivity().getIntent().getSerializableExtra(Constants.NOTE);
            title = note.getTitle();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_note, container, false);
        lblNoteTitle = view.findViewById(R.id.lblNoteFragmentTitle);
        lblNoteTitle.setText(title);
        return view;
    }
}
