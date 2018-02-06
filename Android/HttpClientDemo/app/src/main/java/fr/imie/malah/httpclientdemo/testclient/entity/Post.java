package fr.imie.malah.httpclientdemo.testclient.entity;

/**
 * Created by malah on 11/12/17.
 */

public class Post extends AbstractModel {

    private int userId;
    private String title;
    private String body;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
