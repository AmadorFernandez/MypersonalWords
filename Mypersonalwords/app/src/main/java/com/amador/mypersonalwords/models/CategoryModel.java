package com.amador.mypersonalwords.models;

/**
 * Created by amador on 12/10/16.
 */

public class CategoryModel {


    //Camps
    private String categotyName;
    private String categotyDefinition;
    private int id;

    //Getter and setter

    public String getCategotyName() {
        return categotyName;
    }

    public void setCategotyName(String categotyName) {

        if(!CategoryModel.validateLengthCategoryName(categotyName)){

            this.categotyName = null;

        }else{

            this.categotyName = categotyName;
        }

    }

    public String getCategotyDefinition() {
        return categotyDefinition;
    }

    public void setCategotyDefinition(String categotyDefinition) {

        if(CategoryModel.validateLengthDefinition(categotyDefinition)){

            this.categotyDefinition = null;

        }else {

            this.categotyDefinition = categotyDefinition;
        }

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //Const
    private static final int LENGTH_DEFINITION = 100;
    private static final int LENGTH_CATEGORY_NAME = 20;

    //Construct
    public CategoryModel(String categotyName, String categotyDefinition, int id) {

        this.categotyName = categotyName;
        this.categotyDefinition = categotyDefinition;
        this.id = id;
    }

    public CategoryModel(String categotyName, String categotyDefinition) {
        this.categotyName = categotyName;
        this.categotyDefinition = categotyDefinition;
    }

    //Class methods
    public static boolean validateLengthDefinition(String categotyDefinition){

        return  categotyDefinition.length() <= LENGTH_DEFINITION;
    }

    public static boolean validateLengthCategoryName(String categoryName){

        return categoryName.length() <= LENGTH_CATEGORY_NAME;
    }


}
