package fr.imie.malah.noteapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import fr.imie.malah.noteapp.model.NoteData;
import fr.imie.malah.noteapp.utils.CustomTextWatcher;

public class NewDataActivity extends AppCompatActivity {

    private NoteData data;
    private TextView lblData;
    private Button btnAdd;
    private Button btnCancel;
    private TextView lblTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_data);

        lblData = this.findViewById(R.id.txtNewData);
        lblTitle = this.findViewById(R.id.title);

        initBtn();

        if (getIntent().getExtras() != null && getIntent().getExtras().containsKey(Constants.DATA)) {
            data = (NoteData) getIntent().getExtras().get(Constants.DATA);
            lblData.setText(data.getData());
            btnAdd.setText("EDIT");
            lblTitle.setText("Edit the current data");
        }

        lblData.addTextChangedListener(new CustomTextWatcher() {
            @Override
            public void textChanged() {
                if (lblData.getText().toString().equals("")) {
                    btnAdd.setEnabled(false);
                } else {
                    btnAdd.setEnabled(true);
                }
            }
        });
    }

    private void initBtn() {
        btnAdd = this.findViewById(R.id.btnNewDataAdd);
        btnAdd.setEnabled(false);
        btnAdd.setOnClickListener(v -> {
            Intent intent = new Intent(NewDataActivity.this, DetailActivity.class);
            if (data != null) {
                data.setData(lblData.getText().toString());
                intent.putExtra(Constants.DATA, data);
                setResult(Constants.EDIT_DATA, intent);
            } else {
                intent.putExtra(Constants.DATA_TEXT, lblData.getText().toString());
                setResult(Constants.NEW_DATA, intent);
            }
            NewDataActivity.this.finish();
        });

        btnCancel = this.findViewById(R.id.btnNewDataCancel);

        btnCancel.setOnClickListener(v -> NewDataActivity.this.finish());
    }
}
