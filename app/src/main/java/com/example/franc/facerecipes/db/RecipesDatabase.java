package com.example.franc.facerecipes.db;

import com.raizlabs.android.dbflow.annotation.Database;

/**
 * Created by franc on 11/4/2017.
 */
@Database(name = RecipesDatabase.NAME, version = RecipesDatabase.VERSION)
public class RecipesDatabase {

    public static final int VERSION = 1;
    public static final String NAME = "Recipes";
}
