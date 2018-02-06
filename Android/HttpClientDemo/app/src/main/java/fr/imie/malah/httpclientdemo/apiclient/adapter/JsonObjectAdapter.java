package fr.imie.malah.httpclientdemo.apiclient.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import fr.imie.malah.httpclientdemo.R;

/**
 * Created by malah on 12/12/17.
 */

public class JsonObjectAdapter extends ArrayAdapter<String> {

    private static final int ITEM = R.layout.json_keyvalue_item;
    private static final int LBL_KEY = R.id.lblKey;
    private static final int LBL_VALUE = R.id.lblValue;

    private List<String> keys;
    private JSONObject jsonObject;

    public static class ViewHolder {
        TextView lblKey;
        TextView lblValue;
    }

    public JsonObjectAdapter(Context context, List<String> keys, JSONObject jsonObject) {
        super(context, -1, keys);
        this.keys = keys;
        this.jsonObject = jsonObject;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String key = this.keys.get(position);
        View rowView = convertView;
        ViewHolder holder;
        if (rowView == null) {
            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(ITEM, parent, false);
            holder = new ViewHolder();
            holder.lblKey = rowView.findViewById(LBL_KEY);
            holder.lblValue = rowView.findViewById(LBL_VALUE);
            rowView.setTag(holder);
        } else {
            holder = (ViewHolder) rowView.getTag();
        }
        holder.lblKey.setText(key);
        try {
            holder.lblValue.setText(jsonObject.get(key).toString());
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        return rowView;
    }
}
