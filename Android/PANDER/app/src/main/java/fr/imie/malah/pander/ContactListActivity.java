package fr.imie.malah.pander;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import fr.imie.malah.pander.adapter.CustomCursorAdapter;
import fr.imie.malah.pander.database.ContactDAO;
import fr.imie.malah.pander.model.Contact;
import fr.imie.malah.pander.utils.Constant;

public class ContactListActivity extends Activity {

    private Button btnNewContact;
    private Button btnReturn;
    private ListView listView;
    private CustomCursorAdapter listAdapter;
    private ContactDAO contactDAO;
//    private List<Contact> contacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);

        contactDAO = new ContactDAO(this);
//        contacts = contactDAO.readAll();

        initBtn();
        initContactList();
    }

    private void initBtn() {
        btnReturn = findViewById(R.id.btnContactListReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContactListActivity.this.finish();
            }
        });

        btnNewContact = findViewById(R.id.btnContactListNew);
        btnNewContact.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ContactListActivity.this, AddContactActivity.class);
                ContactListActivity.this.startActivityForResult(intent, Constant.ADD_CONTACT_ACTIVITY);
            }
        });
    }

    private void initContactList() {
        listView = this.findViewById(R.id.lstContactList);
        listAdapter = new CustomCursorAdapter(this, contactDAO.cursorAll());
        listView.setAdapter(listAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent = new Intent(ContactListActivity.this, ContactActivity.class);
                listAdapter.getCursor().moveToPosition(position);
                intent.putExtra(Constant.CONTACT, contactDAO.parseFromCursor(listAdapter.getCursor()));
                ContactListActivity.this.startActivityForResult(intent, Constant.CONTACT_ACTIVITY);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (resultCode == Constant.CONTACT_ACTIVITY) {
            deleteContact(intent);
        }
        if (resultCode == Constant.ADD_CONTACT_ACTIVITY) {
            addContact(intent);
        }
    }

    private void addContact(Intent intent) {
        if (intent.hasExtra(Constant.CONTACT_ADD)) {
            Contact contact = (Contact) intent.getExtras().get(Constant.CONTACT_ADD);
            contact.setPhotoPath("http://via.placeholder.com/50x50");
            contactDAO.create(contact);
            listAdapter.changeCursor(contactDAO.cursorAll());
        }
    }

    private void deleteContact(Intent intent) {
        if (intent.hasExtra(Constant.CONTACT_DEL)) {
            Contact contact = (Contact) intent.getExtras().get(Constant.CONTACT_DEL);
            contactDAO.delete(contact);
            listAdapter.changeCursor(contactDAO.cursorAll());
        }
    }
}
