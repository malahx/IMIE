package fr.imie.malah.httpclientdemo.testclient.fragments;

import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import fr.imie.malah.httpclientdemo.R;
import fr.imie.malah.httpclientdemo.testclient.adapter.PostAdapter;
import fr.imie.malah.httpclientdemo.testclient.entity.Post;

/**
 * Created by malah on 11/12/17.
 */

public abstract class DefaultPostListFragment extends AbstractListFragment<PostAdapter> implements PostListResponseListener {

    public static final int VIEW_ID = R.layout.fragment_post_list;
    public static final int LST_POSTS = R.id.lstPosts;

    protected List<Post> posts = new ArrayList<>();

    @Override
    protected ListView findListView(View v) {
        return v.findViewById(LST_POSTS);
    }

    @Override
    protected PostAdapter getNewInstanceAdapter() {
        return new PostAdapter(getActivity(), posts);
    }

    @Override
    protected int getViewId() {
        return VIEW_ID;
    }

    @Override
    protected void populateLst() {
        listAdapter = getNewInstanceAdapter();
        list.setAdapter(listAdapter);
        listAdapter.notifyDataSetChanged();
    }

    @Override
    public void fireInitData(List<Post> posts) {
        Toast.makeText(getActivity().getBaseContext(), "Received!", Toast.LENGTH_LONG).show();
        this.posts = posts;
        populateLst();
    }
}
