package com.amador.mypersonalwords.views;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ListView;

import com.amador.mypersonalwords.R;
import com.amador.mypersonalwords.controllers.ListDictionaryAdapter;
import com.amador.mypersonalwords.controllers.SelectionActivityControlle;
import com.amador.mypersonalwords.models.DictionaryModel;

import java.util.ArrayList;

public class SelectionActivity extends AppCompatActivity {

    Toolbar barMenu;
    FloatingActionButton floatBtn;
    SelectionActivityControlle controller;
    ListView list;
    ListDictionaryAdapter adapter;
    ArrayList<DictionaryModel> dictionaries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);
        init();


    }

    private void init() {

        barMenu = (Toolbar)findViewById(R.id.toolBarSelection);
        setSupportActionBar(barMenu);
        floatBtn = (FloatingActionButton)findViewById(R.id.floatBtnLaunchCreateDic);
        controller = new SelectionActivityControlle(this);
        list = (ListView)findViewById(R.id.listDictionary);
        dictionaries = controller.serchDictyonaries();
        adapter = new ListDictionaryAdapter(SelectionActivity.this, dictionaries);
        list.setAdapter(adapter);

        floatBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(SelectionActivity.this, CreateDicActivity.class);
                i.putExtra("action", 1);
                startActivity(i);

            }
        });


    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mi = getMenuInflater();
        mi.inflate(R.menu.main_activity_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    protected void onResume() {
        super.onResume();
        dictionaries = controller.serchDictyonaries();
        adapter = new ListDictionaryAdapter(SelectionActivity.this, dictionaries);
        list.setAdapter(adapter);

    }
}
