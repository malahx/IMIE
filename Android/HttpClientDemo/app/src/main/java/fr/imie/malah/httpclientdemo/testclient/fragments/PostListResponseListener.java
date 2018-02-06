package fr.imie.malah.httpclientdemo.testclient.fragments;

import java.util.List;

import fr.imie.malah.httpclientdemo.testclient.entity.Post;

/**
 * Created by malah on 11/12/17.
 */

public interface PostListResponseListener {
    void fireInitData(List<Post> posts);
}
