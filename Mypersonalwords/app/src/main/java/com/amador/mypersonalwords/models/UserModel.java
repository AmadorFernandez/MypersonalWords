package com.amador.mypersonalwords.models;

/**
 * Created by amador on 12/10/16.
 */

public class UserModel {

    //Camps
    private int id;
    private String userName;
    private String userPass;

    //Getter and setter
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {

        if(!UserModel.validateLength(userName)){

            this.userName = null;

        }else{

            this.userName = userName;
        }

    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {

        if(!UserModel.validateLength(userPass)){

            this.userPass = null;

        }else{

            this.userPass = userPass;

        }

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    //Conts
    private static final int LIMIT_LENGTH  = 513;



    //Construct
    public UserModel(String userName, String userPass){

        setUserName(userName);
        setUserPass(userPass);
    }

    public UserModel(int id, String userName, String userPass) {
        this.id = id;
        this.userName = userName;
        this.userPass = userPass;
    }

    //Class methods
    public static boolean validateLength(String text){

        return text.length() <= LIMIT_LENGTH;
    }




}


