package fr.imie.malah.noteapp.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import fr.imie.malah.noteapp.Constants;
import fr.imie.malah.noteapp.DetailActivity;
import fr.imie.malah.noteapp.R;
import fr.imie.malah.noteapp.adapter.NoteCursorAdapter;
import fr.imie.malah.noteapp.database.NoteDAO;
import fr.imie.malah.noteapp.database.NoteDataDAO;
import fr.imie.malah.noteapp.model.Note;

public class NoteListFragment extends AbstractListFragment<Note, NoteCursorAdapter> {

    public NoteListFragment() {
    }

    @Override
    public void refreshList() {
        listAdapter.changeCursor(dao.cursorAll());
    }

    @Override
    protected ListView findListView(View v) {
        return v.findViewById(R.id.lstNoteListFragment);
    }

    @Override
    protected NoteCursorAdapter getNewInstanceAdapter() {
        return new NoteCursorAdapter(getActivity(), dao.cursorAll());
    }

    @Override
    protected Note getModel(int position) {
        listAdapter.getCursor().moveToPosition(position);
        return dao.parseFromCursor(listAdapter.getCursor());
    }

    @Override
    protected void onItemClick(int position) {
        Intent intent = new Intent(getActivity(), DetailActivity.class);
        intent.putExtra(Constants.NOTE, getModel(position));
        getActivity().startActivity(intent);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dao = new NoteDAO(getActivity(), new NoteDataDAO(getActivity()));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_note_list, container, false);
    }
}
