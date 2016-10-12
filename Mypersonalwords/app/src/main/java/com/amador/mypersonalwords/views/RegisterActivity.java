package com.amador.mypersonalwords.views;

import android.content.Intent;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;

import com.amador.mypersonalwords.R;

public class RegisterActivity extends AppCompatActivity {

    RelativeLayout content;
    FloatingActionButton floatBtn;
    private static final int FINAL_ANIMATION = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();


    }


    void init(){

        content = (RelativeLayout)findViewById(R.id.contentPanelRegister);
        floatBtn = (FloatingActionButton)findViewById(R.id.floatBtnRegister);
        floatBtn.setVisibility(View.INVISIBLE);
        startAnimation();

    }

   void startAnimation(){

       Animation textAnimation = AnimationUtils.loadAnimation(RegisterActivity.this, R.anim.entrance_register_animation);
       Handler handler = new Handler();
       content.setAnimation(textAnimation);

       handler.postDelayed(new Runnable() {
           @Override
           public void run() {
               Animation floatbtnAnimation = AnimationUtils.loadAnimation(RegisterActivity.this, R.anim.floating_buton_entrance);
               floatBtn.setVisibility(View.VISIBLE);
               floatBtn.setAnimation(floatbtnAnimation);

           }
       }, FINAL_ANIMATION);




   }
}
