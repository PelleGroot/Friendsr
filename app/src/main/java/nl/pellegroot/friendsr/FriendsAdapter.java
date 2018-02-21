package nl.pellegroot.friendsr;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

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
        // TODO: Ask if this is right
        convertView.findViewById(R.id.IG);

        // TODO: Don't really understand how IO should continue with this part
        // getting data from Arraylist friends
        // providing the index of the friend we'd like to display
//        friends.get();

        // TODO: Need some assistance with this part
        // To load drawable image for putting into ImageView
//        getContext().getResources().getDrawable();

        return convertView;
    }
}