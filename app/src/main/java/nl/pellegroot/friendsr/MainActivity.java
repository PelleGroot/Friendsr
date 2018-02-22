package nl.pellegroot.friendsr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // create the list
    ArrayList<Friend> friends = new ArrayList<>();

    // name the friends
    Friend arya = new Friend("Arya","Arya Stark", R.drawable.arya);
    Friend cersei = new Friend("Cersei","Cersei Lannister", R.drawable.cersei);
    Friend daenarys = new Friend("Danearys","Danearys",R.drawable.daenerys );
    Friend jaime = new Friend("Jaime","Jamie Lannister", R.drawable.jaime);
    Friend jon = new Friend("Jon","Jon Snow", R.drawable.jon);
    Friend jorah = new Friend("Jorah","Jorah bio", R.drawable.jorah);
    Friend margaery = new Friend("Margaery","Margaery bio", R.drawable.margaery);
    Friend melisandre = new Friend("Melisandre","Red woman", R.drawable.melisandre);
    Friend sansa = new Friend("Sansa","Sansa Stark", R.drawable.sansa);
    Friend tyrion = new Friend("Tyrion","Tyrion Lannister", R.drawable.tyrion);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Add the friends to the list
        friends.add(0, arya);
        friends.add(1, cersei);
        friends.add(2, daenarys);
        friends.add(3, jaime);
        friends.add(4, jon);
        friends.add(5, jorah);
        friends.add(6, margaery);
        friends.add(7, melisandre);
        friends.add(8, sansa);
        friends.add(9, tyrion);

        // instantiate the adapter
        FriendsAdapter adapter = new FriendsAdapter( this, R.layout.grid_item, friends);
        // access the gridview by using the ID
        GridView view = (GridView) findViewById(R.id.GV);
        // set the adapter on the grid view
        view.setAdapter(adapter);

        GridView GV = (GridView) findViewById(R.id.GV);
        GV.setOnItemClickListener(new GridItemClickListener());

    }

    private class GridItemClickListener implements AdapterView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Friend clickedFriend = (Friend) adapterView.getItemAtPosition(i);

            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
            intent.putExtra("ClickedFriend", clickedFriend);
            startActivity(intent);

//            Log.d("onItemClick: "  , "clicked: " + clickedFriend.getName());
        }
    }
}
