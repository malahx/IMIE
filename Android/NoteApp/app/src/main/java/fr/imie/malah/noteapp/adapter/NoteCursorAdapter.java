package fr.imie.malah.noteapp.adapter;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import fr.imie.malah.noteapp.R;
import fr.imie.malah.noteapp.database.contracts.NoteContract;

/**
 * Created by malah on 20/11/17.
 */

public class NoteCursorAdapter extends CursorAdapter {

    private int titleIndex = -1;

    public NoteCursorAdapter(Context context, Cursor c) {
        super(context, c, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.note_item, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        refreshIndex(cursor);
        // A revoir

//        NoteFragment noteFragment = (NoteFragment) ((Activity) context).getFragmentManager().findFragmentById(R.id.frgNoteItemNote);
//        noteFragment.setTitle(cursor.getString(titleIndex));
        TextView lblNoteItemTitle = view.findViewById(R.id.lblNoteItemTitle);
        lblNoteItemTitle.setText(cursor.getString(cursor.getColumnIndex(NoteContract.TITLE)));
    }

    private void refreshIndex(Cursor cursor) {
        if (titleIndex == -1) {
            titleIndex = cursor.getColumnIndex(NoteContract.TITLE);
        }
    }
}
