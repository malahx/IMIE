package fr.imie.malah.pander.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import fr.imie.malah.pander.R;
import fr.imie.malah.pander.model.Contact;

/**
 * Created by malah on 24/10/17.
 */

public class CustomArrayAdapter extends ArrayAdapter<Contact> {

    private List<Contact> contacts;

    static class ViewHolder {

        ImageView imageView;
        TextView lblName;
        TextView lblDescription;
    }

    public CustomArrayAdapter(Context context, List<Contact> contacts) {
        super(context, -1, contacts);

        this.contacts = contacts;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;
        ViewHolder holder = null;
        if (rowView == null) {
            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(R.layout.custom_list_item, parent, false);

            holder = new ViewHolder();
            holder.imageView = rowView.findViewById(R.id.imgItemImage);
            holder.lblName = rowView.findViewById(R.id.lblItemName);
            holder.lblDescription = rowView.findViewById(R.id.lblItemDescription);
            rowView.setTag(holder);
        } else {
            holder = (ViewHolder) rowView.getTag();
        }

        Contact contact = this.contacts.get(position);

//        holder.imageView.setImageURI(Uri.parse(contact.getPhotoPath()));
        holder.lblName.setText(contact.displayName());
        holder.lblDescription.setText(contact.getDescription());
        return rowView;
    }
}
