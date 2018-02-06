package fr.imie.malah.pander.adapter;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created by malah on 24/10/17.
 */

public class SimpleArrayAdapter extends ArrayAdapter<String> {

    private List<String> list;

    public SimpleArrayAdapter(Context context, int resource, List<String> list) {
        super(context, resource, list);
        this.list = list;
    }
}
