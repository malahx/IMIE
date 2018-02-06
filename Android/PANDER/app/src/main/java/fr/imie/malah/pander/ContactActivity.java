package fr.imie.malah.pander;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import fr.imie.malah.pander.model.Contact;
import fr.imie.malah.pander.utils.Constant;

public class ContactActivity extends Activity {

    private Button btnDel;
    private Button btnReturn;
    private TextView lblFirstName;
    private TextView lblLastName;
    private TextView lblContactDescription;
    private Contact contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        contact = (Contact) getIntent().getExtras().get(Constant.CONTACT);
        initLbl();
        initBtn();
    }

    private void initLbl() {
        lblFirstName = this.findViewById(R.id.lblContactFirstName);
        lblFirstName.setText(contact.getFirstname());
        lblLastName = this.findViewById(R.id.lblContactLastName);
        lblLastName.setText(contact.getLastname());
        lblContactDescription = this.findViewById(R.id.lblContactDescription);
        lblContactDescription.setText(contact.getDescription());
    }

    private void initBtn() {
        btnDel = this.findViewById(R.id.btnContactDelete);
        btnDel.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ContactActivity.this, ContactListActivity.class);
                intent.putExtra(Constant.CONTACT_DEL, contact);
                setResult(Constant.CONTACT_ACTIVITY , intent);
                ContactActivity.this.finish();
            }
        });

        btnReturn = this.findViewById(R.id.btnContactReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ContactActivity.this.finish();
            }
        });
    }
}
