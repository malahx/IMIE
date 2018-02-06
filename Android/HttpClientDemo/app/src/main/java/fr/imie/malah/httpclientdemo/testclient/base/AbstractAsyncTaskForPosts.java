package fr.imie.malah.httpclientdemo.testclient.base;

import android.os.AsyncTask;

import java.util.List;

import fr.imie.malah.httpclientdemo.testclient.entity.Post;
import fr.imie.malah.httpclientdemo.testclient.fragments.DefaultPostListFragment;

/**
 * Created by malah on 11/12/17.
 */

public abstract class AbstractAsyncTaskForPosts extends AsyncTask<String, Void, List<Post>> {

    private DefaultPostListFragment fragment;

    public AbstractAsyncTaskForPosts(DefaultPostListFragment fragment) {
        this.fragment = fragment;
    }

    @Override
    protected void onPostExecute(List<Post> result) {
        fragment.fireInitData(result);
    }
}
