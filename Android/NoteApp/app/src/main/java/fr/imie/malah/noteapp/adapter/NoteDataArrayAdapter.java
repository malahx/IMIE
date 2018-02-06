package fr.imie.malah.noteapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import fr.imie.malah.noteapp.R;
import fr.imie.malah.noteapp.model.NoteData;

/**
 * Created by malah on 24/10/17.
 */

public class NoteDataArrayAdapter extends ArrayAdapter<NoteData> {
    private List<NoteData> noteDataList;

    public static class ViewHolder {
        TextView lblNoteData;
    }

    public NoteDataArrayAdapter(Context context, List<NoteData> noteDataList) {
        super(context, -1, noteDataList);
        this.noteDataList = noteDataList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        NoteData noteData = this.noteDataList.get(position);
        View rowView = convertView;
        ViewHolder holder;
        if (rowView == null) {
            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(R.layout.notedata_item, parent, false);

            holder = new ViewHolder();
            holder.lblNoteData = rowView.findViewById(R.id.lblNoteData);
            rowView.setTag(holder);
        } else {
            holder = (ViewHolder) rowView.getTag();
        }
        holder.lblNoteData.setText(noteData.getData());
        return rowView;
    }
}
