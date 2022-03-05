package Milestones;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashSet;
/**
 *
 * @author Spencer Hobbs
 * 
 * File Updated 3/5/22 at 3:32pm
 */
public class Recipe {
    
    private String recipeName;
    private int servings = 0;               
    private ArrayList<Ingredient> recipeIngredients = new ArrayList<Ingredient>();
    private double totalRecipeCalories = 0.0; 
        
///////////////////////////////////////////////////////////////////////////////
    
    // Mutators and accessors are below this line - SH
    
    /* Getter (accessor) for recipeName - SH*/
    public String getRecipeName() {
        return recipeName;
    }

    /* Setter (mutator) for recipeName */
    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    /* Getter for servings */
    public int getServings() {
        return servings;
    }

    /* Setter for servings */
    public void setServings(int servings) {
        this.servings = servings;
    }

    /* Getter for recipeIngredients */
    public ArrayList<Ingredient> getRecipeIngredients() {
        return recipeIngredients;
    }

    /* Setter for recipeIngredients */
    public void setRecipeIngredients(ArrayList<Ingredient> recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
    }

    /* Getter for totalRecipeCalories */
    public double getTotalRecipeCalories() {
        return totalRecipeCalories;
    }

    /* Setter for totalRecipeCalories */
    public void setTotalRecipeCalories(double totalRecipeCalories) {
        this.totalRecipeCalories = totalRecipeCalories;
    }
    // Mutators and accessors are above this line - SH
///////////////////////////////////////////////////////////////////////////////
    
    /* Constructor for recipe WITHOUT arguements */
    public Recipe() {
        this.recipeName = "";
        this.servings = 0;
        this.recipeIngredients = new ArrayList();
        this.totalRecipeCalories = 0.0;
    }
    
    /* Constructor for recipe WITH arguements */
    public Recipe(String recipeName, int servings, 
    	ArrayList<Ingredient> recipeIngredients, double totalRecipeCalories) 
    {
        this.recipeName = recipeName;
        this.servings = servings;
        this.recipeIngredients = recipeIngredients;
        this.totalRecipeCalories = totalRecipeCalories;
    }         

///////////////////////////////////////////////////////////////////////////////    
    
// Print recipe details
    public void printRecipe() {
        double singleServingCalories;
        
        singleServingCalories = totalRecipeCalories / servings;
        /* converting double to int may loose accuracy. Made 
        singleServingCalories a double datatype to prevent this error - SH*/
         
        // Print recipe name and servings
        System.out.println("Recipe: " + getRecipeName() ); 
        System.out.println("Serves: " +  getServings() ); 

        // Print ingredient list
        int i = 0; //initializing i close to it's point of use
        
        for (i = 0; i < recipeIngredients.size(); i++) {
       
        
          if(i == 0) { //if statement ensures the "ingredients: " part is printed once
              System.out.println("Ingredients: " + recipeIngredients.get(i).getNameOfIngredient()); //added .getNameOfIngredient() to return the name. Withouth this part the code returns the memory location instead. 
             }
          else if (i > 0) {
             System.out.println("             " + recipeIngredients.get(i).getNameOfIngredient()); //added .getNameOfIngredient() to return the name. Withouth this part the code returns the memory location instead.
             }
        
          } 

                
        // Print single serving calories
        System.out.println("Each serving has " + singleServingCalories + " Calories.");
        System.out.println("----------------------------------------------------------");
        /* added line 115 for better visual separation between recipes*/
        
    }
    
///////////////////////////////////////////////////////////////////////////////
    
    public Recipe createNewRecipe() {
        double totalRecipeCalories = 0.0; // added by SH
        ArrayList <Ingredient> recipeIngredients = new ArrayList();
        boolean addMoreIngredients = true;
        Ingredient ingr; 
        
        Scanner scnr = new Scanner(System.in);
        
        System.out.println("Please enter the recipe name: ");
        String recipeName = scnr.nextLine();
        
        System.out.println("Please enter the number of servings: ");
        //correct data type & Scanner assignment method for servings variable
        int servings = scnr.nextInt();
        

        do {
            System.out.println("Please enter the ingredient name "
                    + "or type 'end' if you are finished entering ingredients: ");
            String ingredientName = scnr.next();
            if (ingredientName.toLowerCase().equals("end")) {
                addMoreIngredients = false;
            } else {

                ingr = new Ingredient();    //instantiates a new Ingredient object - DONE
                ingr.setNameOfIngredient(ingredientName);    // calls the setter method of Ingredient to assign the ingredient name - DONE
                recipeIngredients.add(ingr);   //adds the above Ingredient object to the ArrayList - DONE
        
                System.out.println("Please enter the ingredient amount: ");
                float ingredientAmount = scnr.nextFloat();
            
                System.out.println("Please enter the ingredient Calories: ");
                int ingredientCalories = scnr.nextInt();
                
                totalRecipeCalories = ingredientCalories * ingredientAmount;
            
            }
           
       } while (addMoreIngredients == true);
        
        /* Shows recipe information */  /*Adjusted servings and totalRecipeCalories*/
        Recipe recipe1 = new Recipe(recipeName, servings, recipeIngredients, totalRecipeCalories);
        recipe1.printRecipe();
    return recipe1;} 
    
///////////////////////////////////////////////////////////////////////////////

    public void calcRecipeCost() {// new custom method added for final project
        
        double ingredientCost = 0.0;
        double ingredientQty = 0.0; // could be integer datatype but listing as double makes multiplying two arraylists of the same type easier than if they were different types
        ArrayList<Double> ingCost = new ArrayList<Double>(); // holds all ingredient costs
        ArrayList<Double> ingQty = new ArrayList<Double>(); // holds all ingredient quantities
        double result = 0.0;
        Scanner scnr = new Scanner(System.in);
        
        
        for (int i = 0; i < recipeIngredients.size(); i = i + 1) { // Cycle through ingredients and get their per unit cost; i++ is the normally accepted iterator. Using i = i + 1 here for variety and to keep in mind this alternative exists
            System.out.println("What is the cost of a unit of " + recipeIngredients.get(i).getNameOfIngredient() + "?");
            ingredientCost = scnr.nextDouble();
            ingCost.add(ingredientCost);
        }
        
        for (int i = 0; i < recipeIngredients.size(); i++){ // Cycle through ingredients and assign a unit quantity for each
            System.out.println("How many units of " + recipeIngredients.get(i).getNameOfIngredient() + " do you need to purchase?");
            ingredientQty = scnr.nextDouble();
            ingQty.add(ingredientQty);
        }
        
        for(int i = 0; i<ingCost.size() && i<ingQty.size(); i++) { //multiply cost by quantity for each ingredient and add them together
        result += ingCost.get(i)*ingQty.get(i);
        }

        System.out.println("Total cost of this recipe is $" + result + "."); // display cost of recipe in USD
        
    }      
    
}

