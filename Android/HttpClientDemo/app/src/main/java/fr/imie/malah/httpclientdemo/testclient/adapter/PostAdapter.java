package fr.imie.malah.httpclientdemo.testclient.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import fr.imie.malah.httpclientdemo.R;
import fr.imie.malah.httpclientdemo.testclient.entity.Post;

/**
 * Created by malah on 11/12/17.
 */
public class PostAdapter extends ArrayAdapter<Post> {

    private List<Post> posts = new ArrayList<>();

    public static class ViewHolder {
        TextView lblTitle;
    }

    public PostAdapter(Context context, List<Post> posts) {
        super(context, -1, posts);
        this.posts = posts;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Post post = this.posts.get(position);
        View rowView = convertView;
        ViewHolder holder;
        if (rowView == null) {
            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(R.layout.post_item, parent, false);
            holder = new ViewHolder();
            holder.lblTitle = rowView.findViewById(R.id.lblTitlePostItem);
            rowView.setTag(holder);
        } else {
            holder = (ViewHolder) rowView.getTag();
        }
        holder.lblTitle.setText(post.getTitle());
        return rowView;
    }
}
