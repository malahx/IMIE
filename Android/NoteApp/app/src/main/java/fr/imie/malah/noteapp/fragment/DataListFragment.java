package fr.imie.malah.noteapp.fragment;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import fr.imie.malah.noteapp.Constants;
import fr.imie.malah.noteapp.NewDataActivity;
import fr.imie.malah.noteapp.R;
import fr.imie.malah.noteapp.adapter.NoteDataArrayAdapter;
import fr.imie.malah.noteapp.model.Note;
import fr.imie.malah.noteapp.model.NoteData;

/**
 * A simple {@link Fragment} subclass.
 */
public class DataListFragment extends AbstractListFragment<NoteData, NoteDataArrayAdapter> {

    private Note note;

    public DataListFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        note = (Note) getActivity().getIntent().getSerializableExtra(Constants.NOTE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_data_list, container, false);
        initLst(view);
        return view;
    }

    @Override
    public void refreshList() {
        listAdapter.notifyDataSetChanged();
    }

    @Override
    protected ListView findListView(View v) {
        return v.findViewById(R.id.lstDataFragment);
    }

    @Override
    protected NoteDataArrayAdapter getNewInstanceAdapter() {
        return new NoteDataArrayAdapter(getActivity(), note.getNoteDataList());
    }

    @Override
    protected NoteData getModel(int position) {
        return note.getNoteDataList().get(position);
    }

    @Override
    protected void onItemClick(int position) {
        Intent intent = new Intent(getActivity(), NewDataActivity.class);
        intent.putExtra(Constants.DATA, note.getNoteDataList().get(position));
        getActivity().startActivityForResult(intent, Constants.EDIT_DATA);
    }

}
