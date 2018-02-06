package fr.imie.malah.httpclientdemo.testclient.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

public abstract class AbstractListFragment<T extends BaseAdapter> extends Fragment {

    protected ListView list;
    protected T listAdapter;

    protected abstract ListView findListView(View v);

    protected abstract T getNewInstanceAdapter();

    protected abstract int getViewId();

    protected void initLst(View v) {
        list = findListView(v);
    }

    protected abstract void populateLst();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(getViewId(), container, false);
        initLst(view);
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
