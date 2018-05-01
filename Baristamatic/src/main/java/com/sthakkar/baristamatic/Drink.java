/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sthakkar.baristamatic;

import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author Sarah
 */
public class Drink implements Comparable<Drink>{
    private Map<String, Integer> recipe = new HashMap<String, Integer>();
    private String drinkName;
    private double totalCost = 0;
    private boolean canMake = false;

    public Drink(String drinkName, String[] recipe){
        this.drinkName = drinkName;
        setRecipe(recipe);
    }

    @Override
    public int compareTo(Drink drink){
        return drinkName.compareTo(drink.getDrinkName());
    }

    public void setRecipe(String[] recipe){
        for(String s : recipe){
            if(this.recipe.containsKey(s)){
                this.recipe.put(s, this.recipe.get(s)+1); 
            }else{
                this.recipe.put(s, 1);
            }
        }
    }

    public void setDrinkName(String drinkName){
        this.drinkName = drinkName;
    }

    public void setCost(double totalCost){
        this.totalCost = totalCost;
    }

    public void setCanMake(boolean canMake){
        this.canMake = canMake;
    }

    public Map<String, Integer> getRecipe(){
        return recipe;
    }

    public double getCost(){
        return totalCost;
    }

    public String getDrinkName(){
        return drinkName;
    }

    public boolean getCanMake(){
        return canMake;
    }

}
    

