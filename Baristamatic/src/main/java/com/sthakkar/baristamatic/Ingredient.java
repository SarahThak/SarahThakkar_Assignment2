/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sthakkar.baristamatic;

/**
 *
 * @author Sarah
 */
  
      public class Ingredient implements Comparable<Ingredient>{
        private String ingredientName = "";
        private double cost = 0.00;
        private int stock = 0;

        public Ingredient(String ingredientName, double cost){
            this.ingredientName = ingredientName;
            this.cost = cost;
            this.stock = 10;
        }

        @Override
        public int compareTo(Ingredient ingredient) {
            return ingredientName.compareTo(ingredient.getIngredientName());
        }

        public void setIngredientName(String ingredientName){
            this.ingredientName = ingredientName;
        }

        public void setCost(double cost){
            this.cost = cost;
        }

        public void setStock(int stock){
            this.stock = stock;
        }

        public String getIngredientName(){
            return ingredientName;
        }

        public double getCost(){
            return cost;
        }

        public int getStock(){
            return stock;
        }
}
