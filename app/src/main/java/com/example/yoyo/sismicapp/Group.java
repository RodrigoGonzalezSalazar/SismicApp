package com.example.yoyo.sismicapp;
import java.util.ArrayList;
import java.util.List;

//~~~~~~~~~~~~~~~~~~~~~~ Clase que se ocupa para asociar los títulos de las ExpandableListView con sus
// respectivos child para ser mostrados en las vistas ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
public class Group {
    public String string;
    public final List<String> children = new ArrayList<String>();
    public Group(String string) {
        this.string = string;
    }

}