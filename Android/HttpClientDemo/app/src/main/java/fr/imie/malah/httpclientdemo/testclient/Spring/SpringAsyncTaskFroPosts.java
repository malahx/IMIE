package fr.imie.malah.httpclientdemo.testclient.Spring;

import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import fr.imie.malah.httpclientdemo.utils.Constants;
import fr.imie.malah.httpclientdemo.testclient.base.AbstractAsyncTaskForPosts;
import fr.imie.malah.httpclientdemo.testclient.entity.Post;
import fr.imie.malah.httpclientdemo.testclient.fragments.DefaultPostListFragment;

/**
 * Created by malah on 11/12/17.
 */

public class SpringAsyncTaskFroPosts extends AbstractAsyncTaskForPosts {

    public SpringAsyncTaskFroPosts(DefaultPostListFragment fragment) {
        super(fragment);
    }

    @Override
    protected List<Post> doInBackground(String... strings) {

        RestTemplate restTemplate = new RestTemplate();

        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
        Post[] posts = restTemplate.getForObject(Constants.POSTS, Post[].class);

        return Arrays.asList(posts);
    }
}
