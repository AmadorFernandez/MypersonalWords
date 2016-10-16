package com.amador.mypersonalwords.views;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageButton;

import com.amador.mypersonalwords.R;
import com.amador.mypersonalwords.controllers.CreateDicController;

public class CreateDicActivity extends AppCompatActivity {


    TextInputLayout tiNaeDict;
    EditText editTextNameDic;
    ImageButton imbCancel, imbCreate;
    CreateDicController dicController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_dic);
        init();

    }

    private void init() {

        tiNaeDict = (TextInputLayout)findViewById(R.id.tinNameDic);
        editTextNameDic = (EditText)findViewById(R.id.edtDicName);
        imbCreate = (ImageButton)findViewById(R.id.imbCreateDic);
        imbCancel = (ImageButton)findViewById(R.id.imbCancel);
        dicController = new CreateDicController(this);
        final int action = getIntent().getExtras().getInt("action");

        if(action == 2){

            editTextNameDic.setText(getIntent().getExtras().getString("oldName"));
            tiNaeDict.setHint(getResources().getString(R.string.new_title));


        }else{

            tiNaeDict.setHint(getResources().getString(R.string.add_title));
        }

        imbCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        imbCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                switch (action){

                    case 1:
                        create();

                        break;
                    case 2:
                        rename();
                        break;

                }



            }
        });


    }

    private void rename() {

        String newName = editTextNameDic.getText().toString();
        String oldName = getIntent().getExtras().getString("oldName");

        if(!dicController.validateNameDict(newName)){

            editTextNameDic.setError(getResources().getString(R.string.text_empty));

        }else if(dicController.isExitsDic(getFilesDir().getAbsolutePath() + CreateDicController.SEPARATOR_DIR + newName)){

            editTextNameDic.setError(getResources().getString(R.string.dictionary_exists));

        }else{

            if(dicController.renameDic(newName, oldName)){

                finish();
            }

        }


    }

    private void create() {


        String nameDic = editTextNameDic.getText().toString();

        if(!dicController.validateNameDict(nameDic)){

            editTextNameDic.setError(getResources().getString(R.string.text_empty));

        }else if(dicController.isExitsDic(getFilesDir().getAbsolutePath() + CreateDicController.SEPARATOR_DIR + nameDic)){

            editTextNameDic.setError(getResources().getString(R.string.dictionary_exists));

        }else{

            if(dicController.createDic(nameDic)){

                finish();
            }

        }
    }


}
