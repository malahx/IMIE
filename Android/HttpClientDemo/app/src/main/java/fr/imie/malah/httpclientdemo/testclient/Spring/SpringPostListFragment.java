package fr.imie.malah.httpclientdemo.testclient.Spring;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import fr.imie.malah.httpclientdemo.utils.Constants;
import fr.imie.malah.httpclientdemo.testclient.fragments.DefaultPostListFragment;

/**
 * Created by malah on 11/12/17.
 */

public class SpringPostListFragment extends DefaultPostListFragment {

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        new SpringAsyncTaskFroPosts(this).execute(Constants.POSTS);
    }

}
