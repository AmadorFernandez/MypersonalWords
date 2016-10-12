package com.amador.mypersonalwords.views;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.amador.mypersonalwords.R;

public class SplashScreen extends AppCompatActivity {

    private static final int SPLASH_DURATION_MS = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        //Animation that moves the logo from the top to the center
        Animation animation = AnimationUtils.loadAnimation(SplashScreen.this, R.anim.splash_logo_move);

        ImageView imgLogo = (ImageView) findViewById(R.id.imvLogo);
        if (imgLogo != null) {
            imgLogo.setAnimation(animation);
        }

        /**
         * The object waits X milliseconds before starting the other Activity
         * @see Handler
         */
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashScreen.this, LoginActivity.class));
                finish();
            }
        }, SPLASH_DURATION_MS);
    }
}
