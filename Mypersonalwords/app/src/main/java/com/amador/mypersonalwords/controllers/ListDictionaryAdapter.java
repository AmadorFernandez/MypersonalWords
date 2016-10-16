package com.amador.mypersonalwords.controllers;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.amador.mypersonalwords.R;
import com.amador.mypersonalwords.models.DictionaryModel;
import com.amador.mypersonalwords.models.Memory;
import com.amador.mypersonalwords.views.CreateDicActivity;

import java.util.ArrayList;

/**
 * Created by amador on 16/10/16.
 */

public class ListDictionaryAdapter extends ArrayAdapter {

    Context context;
    ArrayList<DictionaryModel> data;

    public ListDictionaryAdapter(Context context, ArrayList<DictionaryModel> data) {
        super(context, R.layout.iten_list_dictionary, data);

        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        ImageButton imvEdit, imvDelete, imvSee;
        final DictionaryModel dict = data.get(position);
        LayoutInflater inflater = LayoutInflater.from(context);
        View vi = inflater.inflate(R.layout.iten_list_dictionary, null);
        TextView texNameDic = (TextView)vi.findViewById(R.id.txvNameDictList);
        TextView textAutor = (TextView)vi.findViewById(R.id.txvAutorDictList);
        TextView textNumberWords = (TextView)vi.findViewById(R.id.txvNumeberWordsDictList);
        imvEdit = (ImageButton)vi.findViewById(R.id.editDictionary);
        imvDelete = (ImageButton)vi.findViewById(R.id.imbDeleteDic);
        imvSee = (ImageButton)vi.findViewById(R.id.imbSeeDictionary);
        String textAutorP = textAutor.getText().toString();
        final String textNameDicP = texNameDic.getText().toString();
        String textNumberWordsP = textNumberWords.getText().toString();
        texNameDic.setText(textNameDicP + " " + dict.getTitle());
        textAutor.setText(textAutorP + " "  + dict.getAuthor().getUserName());
        textNumberWords.setText(textNumberWordsP + " " + dict.getDictionary().size());

        imvDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                aviseDelete(context.getResources().getString(R.string.text_alert),
                        context.getResources().getString(R.string.text_ms_delete_dic), position, dict).show();
            }
        });

        imvEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(context, CreateDicActivity.class);
                i.putExtra("oldName", dict.getTitle());
                i.putExtra("action", 2);
                context.startActivity(i);

            }
        });

        return vi;

    }

    private Dialog aviseDelete(String titulo, String msg, final int posData, final DictionaryModel dict){

        final AlertDialog.Builder popup = new AlertDialog.Builder(context);
        popup.setTitle(titulo);
        popup.setMessage(msg);


        popup.setPositiveButton(context.getResources().getString(R.string.text_acept), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Memory.deleteFile(context.getFilesDir().getAbsolutePath()+"/"+dict.getTitle()+DictionaryModel.EXTENCION_DIC);
                data.remove(posData);
                notifyDataSetChanged(); //Notifica los cambios en el contenido del adapter al ListView
                dialog.cancel();
            }
        });

        popup.setNegativeButton(context.getResources().getString(R.string.text_cancel), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialog.cancel();

            }
        });

        return popup.create();

    }
}
