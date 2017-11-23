package emasterson.mobileappdevgaa;

import android.os.Bundle;
import android.widget.TextView;

public class TwitterFeedActivity extends BaseActivity{
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twitter_feed);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        textView = findViewById(R.id.textView);
        textView.setText("You chose:\n" + getIntent().getStringExtra("county") + "\nTWITTER FEED GOES HERE !!!");
    }
}
