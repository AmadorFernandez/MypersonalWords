package com.amador.mypersonalwords.models;



/**
 * Created by amador on 12/10/16.
 */

public class WordModel {



    //Camps
    private String word;
    private String definition;
    private int id;

    //Getter and setter
    public String getWord() {
        return word;
    }

    public void setWord(String word)  {

        if(!WordModel.validateLengthWords(word)){

            this.word = null;
        }
        this.word = word;
    }

    public String getDefinition() {
        return definition;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDefinition(String definition) {

        if(!WordModel.validateLengthDefinition(definition)){

           this.definition = null;

        }else {

            this.definition = definition;
        }

    }

    //Const
    private static final int LIMIT_LENGTH = 20;
    private static final int LIMIT_DEFINITION_LENGTH = 100;

    //Constructs
    public WordModel(String word, String definition){

        setWord(word);
        setDefinition(definition);


    }

    public WordModel(String word, String definition, int id) {
        this.word = word;
        this.definition = definition;
        this.id = id;
    }


    //Class methods
    public static boolean validateLengthWords(String word){

        return word.length() <= LIMIT_LENGTH;

    }

    public static boolean validateLengthDefinition(String definition){

        return definition.length() <= LIMIT_DEFINITION_LENGTH;
    }
}


