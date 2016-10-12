package com.amador.mypersonalwords.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.amador.mypersonalwords.R;

public class LoginActivity extends AppCompatActivity {

    RelativeLayout contain;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();

    }

    void init(){

        btnRegister = (Button)findViewById(R.id.btnCreateAcount);
        startAnimation();

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(i);

            }
        });

    }


    void startAnimation(){

        //Animation that moves the logo from the top to the center
        Animation animation = AnimationUtils.loadAnimation(LoginActivity.this, R.anim.login_animation);

        contain = (RelativeLayout) findViewById(R.id.relativeLogin);
        if (contain != null) {
            contain.setAnimation(animation);
        }


    }
}
