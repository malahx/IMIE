package fr.imie.malah.httpclientdemo.testclient.HttpClient;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import fr.imie.malah.httpclientdemo.utils.Constants;
import fr.imie.malah.httpclientdemo.testclient.fragments.DefaultPostListFragment;

public class HttpClientPostListFragment extends DefaultPostListFragment {

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        new HttpClientAsyncTaskForPosts(this).execute(Constants.POSTS);
    }
}
