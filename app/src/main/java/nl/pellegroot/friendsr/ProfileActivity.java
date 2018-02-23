package nl.pellegroot.friendsr;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Rating;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Intent intent = getIntent();
        // set the ClickedFriend
        Friend retrievedFriend = (Friend) intent.getSerializableExtra("ClickedFriend");

        // set the views
        ImageView imageView = (ImageView) findViewById(R.id.img);
        TextView txtBio = (TextView) findViewById(R.id.txtBio);
        TextView txtName = (TextView) findViewById(R.id.txtName);
        RatingBar ratingbar = (RatingBar) findViewById(R.id.ratingbar);

        // set image, bio and name
        imageView.setImageDrawable(getResources().getDrawable(retrievedFriend.getDrawableId()));
        txtBio.setText(retrievedFriend.getBio());
        txtName.setText(retrievedFriend.getName());
//        Log.d("Creating the rating", "Get rating: " + retrievedFriend.getRating());
//        Log.d("Creating the rating", "Get name: " + retrievedFriend.getName());

        // set rating
        ratingbar.setOnRatingBarChangeListener(new OnRatingBarChangeListener());

        // TODO: figure out what to store
        SharedPreferences prefs = getSharedPreferences("settings", MODE_PRIVATE);
        Float storedFloat = prefs.getFloat(retrievedFriend.getName(), 0);
//        retrievedFriend.setRating(storedFloat);
        Log.d("onRetrieve: ",retrievedFriend.getName() + " " + storedFloat);

        if(storedFloat != 0) {
            // we have something stored under "example_key"
//            Log.d("within the if", "storedFloat: " + storedFloat);
            retrievedFriend.setRating(storedFloat);
        }
        else {
            // there is nothing stored under "example_key"
            ratingbar.setRating(0);
        }

        ratingbar.setRating(retrievedFriend.getRating());
    }

    private class OnRatingBarChangeListener implements RatingBar.OnRatingBarChangeListener{
        @Override
        public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
            // set the ClickedFriend
            Intent intent = getIntent();
            Friend retrievedFriend = (Friend) intent.getSerializableExtra("ClickedFriend");

            Log.d("onSave: ",retrievedFriend.getName() + " " + v );

            SharedPreferences.Editor editor = getSharedPreferences("settings", MODE_PRIVATE).edit();
            editor.putFloat(retrievedFriend.getName(), v);
            editor.apply();
        }
    }
}
