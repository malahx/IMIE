package fr.imie.malah.pander;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import fr.imie.malah.pander.utils.Constant;

public class HomeActivity extends Activity implements View.OnClickListener {

    private Button btnContacts;
    private TextView lblFirstName;
    private TextView lblLastName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initLbl();
        initBtn();
    }

    private void initBtn() {
        btnContacts = findViewById(R.id.btnHomeContacts);
        btnContacts.setOnClickListener(this);
    }

    private void initLbl() {
        lblFirstName = findViewById(R.id.lblHomeFirstName);
        lblLastName = findViewById(R.id.lblHomeLastName);
        lblFirstName.setText(getIntent().getExtras().getString(Constant.LOGIN));
        lblLastName.setText(getIntent().getExtras().getString(Constant.PASSWORD));
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, ContactListActivity.class);
        startActivity(intent);
    }
}
