package nl.pellegroot.friendsr;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

        // set rating
        ratingbar.setOnRatingBarChangeListener(new OnRatingBarChangeListener());

        // get the rating from the shared pref
        SharedPreferences prefs = getSharedPreferences("settings", MODE_PRIVATE);
        Float storedFloat = prefs.getFloat(retrievedFriend.getName(), 0);

        if(storedFloat != 0) {
            // if stored, set it to the according friend
            retrievedFriend.setRating(storedFloat);
        }
        else {
            // if nothing is stored, set zero
            ratingbar.setRating(0);
        }
        // set the ratingbar
        ratingbar.setRating(retrievedFriend.getRating());
    }

    private class OnRatingBarChangeListener implements RatingBar.OnRatingBarChangeListener{
        @Override
        public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
            // set the ClickedFriend
            Intent intent = getIntent();
            Friend retrievedFriend = (Friend) intent.getSerializableExtra("ClickedFriend");

            // save the rating to the friend in the shared prefs
            SharedPreferences.Editor editor = getSharedPreferences("settings", MODE_PRIVATE).edit();
            editor.putFloat(retrievedFriend.getName(), v);
            editor.apply();
        }
    }
}
