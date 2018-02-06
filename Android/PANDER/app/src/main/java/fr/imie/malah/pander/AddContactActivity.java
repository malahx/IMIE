package fr.imie.malah.pander;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import fr.imie.malah.pander.model.Contact;
import fr.imie.malah.pander.utils.Constant;

public class AddContactActivity extends Activity {

    private Button btnAdd;
    private Button btnReturn;
    private EditText txtFirstName;
    private EditText txtLastName;
    private EditText txtDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        txtFirstName = this.findViewById(R.id.txtAddContactFirstName);
        txtLastName = this.findViewById(R.id.txtAddContactLastName);
        txtDescription = this.findViewById(R.id.txtAddContactDescription);

        initBtn();
    }

    private void initBtn() {
        btnAdd = this.findViewById(R.id.btnAddContact);
        btnAdd.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (txtFirstName.getText().equals("") || txtLastName.getText().equals("")) {
                    Toast.makeText(AddContactActivity.this,"You need to enter a FirstName and a LastName", Toast.LENGTH_SHORT);
                    return;
                }

                Intent intent = new Intent(AddContactActivity.this, ContactListActivity.class);
                Contact contact = new Contact(txtFirstName.getText().toString(), txtLastName.getText().toString(), txtDescription.getText().toString());
                intent.putExtra(Constant.CONTACT_ADD, contact);
                setResult(Constant.ADD_CONTACT_ACTIVITY, intent);
                AddContactActivity.this.finish();
            }
        });
        btnReturn = this.findViewById(R.id.btnAddContactReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                AddContactActivity.this.finish();
            }
        });
    }
}
