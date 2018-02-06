package fr.imie.malah.pander;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

import fr.imie.malah.pander.adapter.SimpleArrayAdapter;
import fr.imie.malah.pander.utils.Constant;

public class CallActivity extends Activity implements View.OnClickListener {

    private ListView listView;
    private Button btnCall;
    private TextView lblNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);
        lblNumber = (TextView) this.findViewById(R.id.lblNumber);
        lblNumber.setText(getIntent().getExtras().getString(Constant.PHONE));
        btnCall = (Button) this.findViewById(R.id.btnCall);
        btnCall.setOnClickListener(this);
        listView = (ListView) this.findViewById(R.id.lst);

        final List<String> values = Arrays.asList("truc", "machin", "bidule");
        listView.setAdapter(new SimpleArrayAdapter(this, android.R.layout.simple_list_item_1, values));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String value = values.get(position);
                Toast.makeText(CallActivity.this, value, Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onClick(View v) {
//        Intent intent = new Intent(Intent.ACTION_CALL);
//        intent.setData(Uri.parse("tel:" + lblNumber.getText().toString()));
//        startActivity(intent);

        Intent intent = new Intent(this, ContactListActivity.class);
        startActivity(intent);
    }
}
