package nl.pellegroot.friendsr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Friend> friends = new ArrayList<>();

    Friend arya = new Friend("Arya","Arya Stark", 0);
    Friend cersei = new Friend("Cersei","Cersei Lannister", 1);
    Friend daenarys = new Friend("Danearys","Danearys",2 );
    Friend jaime = new Friend("Jaime","Jamie Lannister", 3);
    Friend jon = new Friend("Jon","Jon Snow", 4);
    Friend jorah = new Friend("Jorah","Jorah bio", 5);
    Friend margaery = new Friend("Margaery","Margaery bio", 6);
    Friend melisandre = new Friend("Melisandre","Red woman", 7);
    Friend sansa = new Friend("Sansa","Sansa Stark", 8);
    Friend tyrion = new Friend("Tyrion","Tyrion Lannister", 9);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        friends.add(0, arya);
        friends.add(1,cersei)
        friends.add(2,daenarys);
        friends.add(3, jaime);
        friends.add(4, jon);
        friends.add(5, jorah);
        friends.add(6, margaery);
        friends.add(7, melisandre);
        friends.add(8, sansa);
        friends.add(9, tyrion);
    }


}
