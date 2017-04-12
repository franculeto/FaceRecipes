package com.example.franc.facerecipes.api;

import com.example.franc.facerecipes.Entities.Recipe;

import java.util.List;

/**
 * Created by franc on 11/4/2017.
 */

class RecipeServiceResponse {

    private int count ;
    private List<Recipe> recipes;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }

    public Recipe getFirstRecipe() {
        if (!recipes.isEmpty()) {
            return recipes.get(0);
        }
        return null;
    }
}
