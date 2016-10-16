package com.amador.mypersonalwords.models;

import java.util.ArrayList;

/**
 * Created by amador on 12/10/16.
 */

public class DictionaryModel {

    //Camps
    private int id;
    private String title;
    private UserModel author;
    private ArrayList<WordModel> dictionary;

    //Getter and setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public UserModel getAuthor() {
        return author;
    }

    public void setAuthor(UserModel author) {
        this.author = author;
    }

    public ArrayList<WordModel> getDictionary() {
        return dictionary;
    }

    public void setDictionary(ArrayList<WordModel> dictionary) {
        this.dictionary = dictionary;
    }

    //Const

    private static final int MAX_TITLE_LENGTH = 50;
    public static final String EXTENCION_DIC = ".xml";

    //Construct
    public DictionaryModel(String title, UserModel author) {
        this.title = title;
        this.author = author;
        this.dictionary = new ArrayList<WordModel>();
    }

    public DictionaryModel(int id, String title, UserModel author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.dictionary = new ArrayList<WordModel>();
    }

    public DictionaryModel(UserModel author){

        this.title = "";
        this.dictionary = new ArrayList<WordModel>();
        this.author = author;

    }

    public DictionaryModel(String title){

        this.title = title;
        this.author = new UserModel("Desconocido");
        this.dictionary = new ArrayList<WordModel>();
    }

    //Class methods

    public static boolean validateLengthTitle(String title){

        return title.length() <= MAX_TITLE_LENGTH;

    }
}
