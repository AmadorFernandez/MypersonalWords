package com.amador.mypersonalwords.controllers;

import com.amador.mypersonalwords.models.Memory;
import com.amador.mypersonalwords.views.CreateDicActivity;

/**
 * Created by amador on 16/10/16.
 */

public class CreateDicController {

    public static final String EXTENSION_DIC = ".xml";
    public static final String SEPARATOR_DIR = "/";
    CreateDicActivity activity;

    //Construct
    public CreateDicController(CreateDicActivity activity){

        this.activity = activity;
    }

    public boolean createDic(String nameDic){

        return Memory.createFile(activity.getFilesDir().getAbsolutePath() + SEPARATOR_DIR + nameDic + EXTENSION_DIC);
    }

    public boolean renameDic(String newName, String oldName){

        return Memory.renameFile(activity.getFilesDir().getAbsolutePath() + SEPARATOR_DIR + oldName + EXTENSION_DIC,
                activity.getFilesDir().getAbsolutePath() + SEPARATOR_DIR + newName + EXTENSION_DIC
                );
    }

    public boolean validateNameDict(String nameDic){

        return !nameDic.isEmpty();
    }

    public boolean isExitsDic(String nameDic){

        return Memory.isFileExits(nameDic + EXTENSION_DIC);
    }



}
