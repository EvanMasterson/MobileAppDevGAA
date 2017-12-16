package emasterson.mobileappdevgaa;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;

/*
    This activity displays a splash screen on startup for 4.5 seconds
    Incorporates sound when loading is finished
 */
public class SplashScreenActivity extends Activity {
    MediaPlayer media = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        int seconds = 4;

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashScreenActivity.this, LoginActivity.class));
                media = MediaPlayer.create(getApplicationContext(), R.raw.loading_sound);
                media.start();
                finish();
            }
        }, seconds * 1125);
    }
}
