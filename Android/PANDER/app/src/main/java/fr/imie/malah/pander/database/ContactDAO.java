package fr.imie.malah.pander.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import fr.imie.malah.pander.model.Contact;

/**
 * Created by malah on 27/10/17.
 */

public class ContactDAO extends AbstractDAO<Contact> {

    public static final String TABLE = "pander_contact";
    public static final String ID = "_id";
    public static final String FIRST_NAME = "firstname";
    public static final String LAST_NAME = "lastname";
    public static final String PHOTO_PATH = "photo_path";
    public static final String DESCRIPTION = "description";

    public ContactDAO(Context context) {
        super(context);
    }

    @Override
    public String getId() {
        return ID;
    }

    @Override
    protected ContentValues parseFromModel(Contact contact) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(FIRST_NAME, contact.getFirstname());
        contentValues.put(LAST_NAME, contact.getLastname());
        contentValues.put(PHOTO_PATH, contact.getPhotoPath());
        contentValues.put(DESCRIPTION, contact.getDescription());
        return contentValues;
    }

    @Override
    public Contact parseFromCursor(Cursor cursor) {
        int iId = cursor.getColumnIndex(ID);
        int iFirstName = cursor.getColumnIndex(FIRST_NAME);
        int iLastName = cursor.getColumnIndex(LAST_NAME);
        int iPhotoPath = cursor.getColumnIndex(PHOTO_PATH);
        int iDescription = cursor.getColumnIndex(DESCRIPTION);
        Contact contact = new Contact();
        contact.setId(cursor.getLong(iId));
        contact.setFirstname(cursor.getString(iFirstName));
        contact.setLastname(cursor.getString(iLastName));
        contact.setPhotoPath(cursor.getString(iPhotoPath));
        contact.setDescription(cursor.getString(iDescription));
        return contact;
    }

    @Override
    protected String getTable() {
        return TABLE;
    }

    @Override
    protected String[] getColumns() {
        return new String[]{ID, FIRST_NAME, LAST_NAME, PHOTO_PATH, DESCRIPTION};
    }

    @Override
    public String getScriptCreation() {
        return String.format(
                "CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, %s VARCHAR(128), %s VARCHAR(128), %s VARCHAR(128), %s TEXT)",
                ContactDAO.TABLE,
                ContactDAO.ID,
                ContactDAO.FIRST_NAME,
                ContactDAO.LAST_NAME,
                ContactDAO.PHOTO_PATH,
                ContactDAO.DESCRIPTION);
    }

    @Override
    public String getScriptDeletion() {
        return String.format(
                "DROP TABLE %s",
                ContactDAO.TABLE);
    }
}
