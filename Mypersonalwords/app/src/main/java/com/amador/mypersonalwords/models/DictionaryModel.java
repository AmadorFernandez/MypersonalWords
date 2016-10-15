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
    private CategoryModel category;
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

    public CategoryModel getCategory() {
        return category;
    }

    public void setCategory(CategoryModel category) {
        this.category = category;
    }

    public ArrayList<WordModel> getDictionary() {
        return dictionary;
    }

    public void setDictionary(ArrayList<WordModel> dictionary) {
        this.dictionary = dictionary;
    }

    //Const

    private static final int MAX_TITLE_LENGTH = 50;

    //Construct
    public DictionaryModel(String title, UserModel author, CategoryModel category) {
        this.title = title;
        this.author = author;
        this.category = category;
        this.dictionary = new ArrayList<WordModel>();
    }

    public DictionaryModel(int id, String title, UserModel author, CategoryModel category) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.category = category;
        this.dictionary = new ArrayList<WordModel>();
    }

    //Class methods

    public static boolean validateLengthTitle(String title){

        return title.length() <= MAX_TITLE_LENGTH;

    }
}
