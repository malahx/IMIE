package fr.imie.malah.pander.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import fr.imie.malah.pander.model.AbstractModel;

/**
 * Created by malah on 27/10/17.
 */

public abstract class AbstractDAO<T extends AbstractModel> implements DAO<T> {

    private SQLiteDatabase db;

    public AbstractDAO(Context context) {
        PanderSQLiteOpenHelper helper = new PanderSQLiteOpenHelper(context, getScriptCreation(), getScriptDeletion());
        db = helper.getWritableDatabase();
    }

    protected abstract String getId();

    protected abstract String[] getColumns();

    protected abstract String getTable();

    public abstract T parseFromCursor(Cursor cursor);

    protected abstract ContentValues parseFromModel(T object);

    public abstract String getScriptCreation();

    public abstract String getScriptDeletion();

    public SQLiteDatabase getDb() {
        return db;
    }

    protected String getIdSelection() {
        StringBuilder sb = new StringBuilder();
        sb.append(getId()).append(" = ?");
        return sb.toString();
    }

    @Override
    public T create(T t) {
        t.setId(getDb().insert(getTable(), null, parseFromModel(t)));
        return t;
    }

    @Override
    public void update(T t) {
        getDb().update(getTable(), parseFromModel(t), getIdSelection(), new String[]{Long.toString(t.getId())});
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
    public T read(long id) {
        Cursor cursor = getDb().query(getTable(), getColumns(), getIdSelection(), new String[]{Long.toString(id)}, null, null, null);
        cursor.moveToFirst();
        T object = parseFromCursor(cursor);
        cursor.close();
        return object;
    }

    @Override
    public List<T> readAll() {
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
