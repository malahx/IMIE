package fr.imie.malah.httpclientdemo.testclient.HttpClient;

import java.util.List;

import fr.imie.malah.httpclientdemo.testclient.base.AbstractAsyncTaskForPosts;
import fr.imie.malah.httpclientdemo.testclient.entity.Post;
import fr.imie.malah.httpclientdemo.testclient.fragments.DefaultPostListFragment;
import fr.imie.malah.httpclientdemo.utils.JsonUtils;

/**
 * Created by malah on 11/12/17.
 */
public class HttpClientAsyncTaskForPosts extends AbstractAsyncTaskForPosts {

    public HttpClientAsyncTaskForPosts(DefaultPostListFragment fragment) {
        super(fragment);
    }

    @Override
    protected List<Post> doInBackground(String... urls) {
        String s = HttpClientUtils.get(urls[0]);
        return JsonUtils.fromJson(s);
    }
}
