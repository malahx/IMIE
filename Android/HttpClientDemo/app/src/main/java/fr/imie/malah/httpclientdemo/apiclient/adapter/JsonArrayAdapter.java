package fr.imie.malah.httpclientdemo.apiclient.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import fr.imie.malah.httpclientdemo.R;

/**
 * Created by malah on 12/12/17.
 */

public class JsonArrayAdapter extends ArrayAdapter<JSONObject> {

    private static final int ITEM = R.layout.json_array_item;
    private static final int LILA_KEY_VALUE = R.id.lilaKeyValue;

    private List<JSONObject> jsonArray;

    public static class ViewHolder {
        LinearLayout lilaKeyValue;
    }

    public JsonArrayAdapter(Context context, List<JSONObject> jsonArray) {
        super(context, -1, jsonArray);
        this.jsonArray = jsonArray;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        JSONObject jsonObject = this.jsonArray.get(position);
        View rowView = convertView;
        ViewHolder holder;
        if (rowView == null) {
            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(ITEM, parent, false);
            holder = new ViewHolder();
            holder.lilaKeyValue = rowView.findViewById(LILA_KEY_VALUE);
            rowView.setTag(holder);
        } else {
            holder = (ViewHolder) rowView.getTag();
        }
        jsonObject.keys().forEachRemaining(k -> {
            populateView(jsonObject, holder, k);
        });
        return rowView;
    }

    private void populateView(JSONObject jsonObject, ViewHolder holder, String key) {
        RelativeLayout row = new RelativeLayout(getContext());
        TextView lblKey = new TextView(getContext());
        lblKey.setText(key);
        row.addView(lblKey);
        TextView lblValue = new TextView(getContext());
        try {
            lblValue.setText(jsonObject.get(key).toString());
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams
                (RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        lp.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        row.addView(lblValue, lp);
        holder.lilaKeyValue.addView(row);
    }
}
