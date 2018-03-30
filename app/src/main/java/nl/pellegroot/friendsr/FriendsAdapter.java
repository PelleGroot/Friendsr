package nl.pellegroot.friendsr;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class FriendsAdapter extends ArrayAdapter<Friend> {
    private int layoutResourceId;
    private ArrayList friends;

    public FriendsAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Friend> objects) {
        super(context, resource, objects);
        layoutResourceId = resource;
        friends = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.grid_item, parent, false);
        }
        // set the image and the text view to a variable
        ImageView imageview = (ImageView) convertView.findViewById(R.id.imageArya);
        TextView textview = (TextView) convertView.findViewById(R.id.TextArya);

        // providing the index of the friend we'd like to display
        Friend friend = (Friend) friends.get(position);

        // To load drawable image for putting into ImageView by using the drawable id from friend
        imageview.setImageDrawable(getContext().getResources().getDrawable(friend.getDrawableId()));
        textview.setText(friend.getName());

        return convertView;
    }
}