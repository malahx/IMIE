package fr.imie.malah.noteapp.database.base;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import fr.imie.malah.noteapp.model.AbstractModel;

/**
 * Created by malah on 20/11/17.
 */

public abstract class AbstractDAO<T extends AbstractModel> implements DAO<T>, DAOManagement {

    private SQLiteDatabase db;
    private final NoteAppSQLiteOpenHelper helper;

    protected AbstractDAO(Context context) {
        helper = NoteAppSQLiteOpenHelper.getInstance(context);
        helper.getDaoManagements().add(this);
    }

    protected abstract String getId();

    protected abstract String[] getColumns();

    protected abstract String getTable();

    public abstract T parseFromCursor(Cursor cursor);

    protected abstract ContentValues parseFromModel(T object);

    protected SQLiteDatabase getDb() {
        if (db == null) {
            db = helper.getWritableDatabase();
        }
        return db;
    }

    private String getIdSelection() {
        StringBuilder sb = new StringBuilder();
        sb.append(getId()).append(" = ?");
        return sb.toString();
    }

    @Override
    public T save(T t) {
        if (t.getId() == null) {
            t.setId(getDb().insert(getTable(), null, parseFromModel(t)));
        } else {
            getDb().update(getTable(), parseFromModel(t), getIdSelection(), new String[]{Long.toString(t.getId())});
        }
        return t;
    }

    @Override
    public void delete(T t) {
        delete(t.getId());
    }

    @Override
    public void delete(long id) {
        getDb().delete(getTable(), getIdSelection(), new String[]{Long.toString(id)});
    }

    @Override
    public T findById(long id) {
        Cursor cursor = getDb().query(getTable(), getColumns(), getIdSelection(), new String[]{Long.toString(id)}, null, null, null);
        cursor.moveToFirst();
        T object = parseFromCursor(cursor);
        cursor.close();
        return object;
    }

    @Override
    public List<T> findAll() {
        List<T> objects = new ArrayList<>();
        Cursor cursor = getDb().query(getTable(), getColumns(), "1", null, null, null, null);
        while ((cursor.isBeforeFirst() ? cursor.moveToFirst() : cursor.moveToNext())) {
            objects.add(parseFromCursor(cursor));
        }
        cursor.close();
        return objects;
    }

    @Override
    public Cursor cursorAll() {
        return getDb().query(getTable(), getColumns(), "1", null, null, null, null);
    }
}
