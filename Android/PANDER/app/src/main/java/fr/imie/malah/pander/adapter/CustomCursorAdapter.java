package fr.imie.malah.pander.adapter;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import fr.imie.malah.pander.R;
import fr.imie.malah.pander.database.ContactDAO;

/**
 * Created by malah on 27/10/17.
 */

public class CustomCursorAdapter extends CursorAdapter {

    public CustomCursorAdapter(Context context, Cursor c) {
        super(context, c, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.custom_list_item, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        ImageView imageView = view.findViewById(R.id.imgItemImage);
        TextView lblName = view.findViewById(R.id.lblItemName);
        TextView lblDescription = view.findViewById(R.id.lblItemDescription);

        imageView.setImageURI(Uri.parse(cursor.getString(cursor.getColumnIndex(ContactDAO.PHOTO_PATH))));
        lblName.setText(String.format("%s %s",
                cursor.getString(cursor.getColumnIndex(ContactDAO.FIRST_NAME)),
                cursor.getString(cursor.getColumnIndex(ContactDAO.LAST_NAME))));
        lblDescription.setText(cursor.getString(cursor.getColumnIndex(ContactDAO.DESCRIPTION)));
    }
}
