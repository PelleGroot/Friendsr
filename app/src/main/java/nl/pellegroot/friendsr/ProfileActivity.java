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
        Friend retrievedFriend = (Friend) intent.getSerializableExtra("ClickedFriend");

        ImageView imageView = (ImageView) findViewById(R.id.img);
        TextView txtBio = (TextView) findViewById(R.id.txtBio);
        TextView txtName = (TextView) findViewById(R.id.txtName);

        imageView.setImageDrawable(getResources().getDrawable(retrievedFriend.getDrawableId()));
        txtBio.setText(retrievedFriend.getBio());
        txtName.setText(retrievedFriend.getName());

        RatingBar ratingbar = (RatingBar) findViewById(R.id.ratingbar);
        ratingbar.setOnRatingBarChangeListener(new OnRatingBarChangeListener());

    }

    private class OnRatingBarChangeListener implements RatingBar.OnRatingBarChangeListener{
        @Override
        public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
            SharedPreferences.Editor editor = getSharedPreferences("settings", MODE_PRIVATE).edit();
            editor.putFloat("RatingFriend", v);
            editor.apply();
        }
    }
}
