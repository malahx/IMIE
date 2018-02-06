package fr.imie.malah.noteapp.fragment;

import android.app.AlertDialog;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ListView;

import fr.imie.malah.noteapp.database.base.AbstractDAO;
import fr.imie.malah.noteapp.model.AbstractModel;

/**
 * Created by malah on 24/11/17.
 */

public abstract class AbstractListFragment<T extends AbstractModel, U extends BaseAdapter> extends Fragment {

    protected ListView list;
    protected U listAdapter;
    protected AbstractDAO<T> dao;

    public abstract void refreshList();

    protected abstract ListView findListView(View v);

    protected abstract U getNewInstanceAdapter();

    protected abstract T getModel(int position);

    protected void onItemLongClick(View view, int position) {
        deletePopup(getModel(position));
    }

    protected void initLst(View v) {

        list = findListView(v);
        listAdapter = getNewInstanceAdapter();
        list.setAdapter(listAdapter);
        list.setOnItemClickListener((adapterView, view, position, id) -> onItemClick(position));
        list.setOnItemLongClickListener((parent, view, position, id) -> {
            onItemLongClick(view, position);
            return false;
        });
    }


    protected abstract void onItemClick(int position);

    private void deletePopup(T model) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle("Confirm");
        builder.setMessage("Do you want to delete this data?");

        builder.setPositiveButton("YES", (dialog, which) -> {
            delete(model);
            dialog.dismiss();
        });

        builder.setNegativeButton("NO", (dialog, which) -> dialog.cancel());

        builder.create().show();
    }

    protected void delete(T model) {
        dao.delete(model);
        refreshList();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        initLst(view);
    }
}
