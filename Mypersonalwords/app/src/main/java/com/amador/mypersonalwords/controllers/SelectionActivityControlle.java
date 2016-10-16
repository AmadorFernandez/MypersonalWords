package com.amador.mypersonalwords.controllers;

import com.amador.mypersonalwords.models.DictionaryModel;
import com.amador.mypersonalwords.models.Memory;
import com.amador.mypersonalwords.views.SelectionActivity;

import java.util.ArrayList;

/**
 * Created by amador on 16/10/16.
 */

public class SelectionActivityControlle {

    SelectionActivity activity;

    public SelectionActivityControlle(SelectionActivity activity){

        this.activity = activity;
    }

    public ArrayList<DictionaryModel> serchDictyonaries(){

        ArrayList<String> info = Memory.searchFiles(activity.getFilesDir().getAbsolutePath(), ".xml");
        ArrayList<DictionaryModel> listDict = new ArrayList<DictionaryModel>();
        String title = "";

        for(int i = 0; i < info.size(); i++){

            title = info.get(i);
            title = title.substring(0, title.indexOf("."));
            listDict.add(new DictionaryModel(title));
        }

        return listDict;

    }
}
