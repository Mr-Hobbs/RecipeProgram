package Milestones;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Spencer Hobbs
 * 
 */

/**
 * this class acts as the menu for the recipe and performs the operations according to user selection
 */
public class RecipeBox {
    
    private ArrayList<Recipe> listOfRecipes; // Declaring array list of Recipe's
    
    
    /**
     * To get the List of Recipes (Accessor)
     */
    public ArrayList<Recipe> getListOfRecipes() {  
       return listOfRecipes; // added by SH
    } 
    
    /**
     * To set the List of Recipes (Mutator)
     * @param listOfRecipes 
     */
    public void setListOfRecipes(ArrayList<Recipe> listOfRecipes) {
        this.listOfRecipes = listOfRecipes; // added by SH
    }

    /**
     * Default Constructor
     */
    public RecipeBox(){
        listOfRecipes = new ArrayList(); /* initialized listOfRecipes - SH */
    }

    /**
     * Custom method used to create new recipe with and add to list
     */
    public void addNewRecipe() {  
        Recipe recipe = new Recipe();                
        listOfRecipes.add(recipe.createNewRecipe());
    }
 
 /////////////////////////////////////////////////////////////////////////
    
    /**
     * Custom Method which accepts the Recipe Name and displays the details for the Recipe
     */
    /**
     * To set the List of Recipes (Mutator)
     * @param listOfRecipes 
     */
     
    public void printAllRecipeDetails(String selectedRecipeName) {
        int arrayListNumber = -1; //To get the location where the selected recipe is present in the array list
        Recipe recipe; //variable of type Recipe

        for(int i = 0; i < listOfRecipes.size(); i++) { //Looping through the listOfRecipes arraylist to find the location of the selected recipe

           if(listOfRecipes.get(i).getRecipeName().equals(selectedRecipeName)) { // Added getRecipeName() into the comparison. This iterates through recipe list then compares to selectedRecipeName -- SH
               arrayListNumber = i;
           }
        }
                  
        if(arrayListNumber == -1){ //if the selected recipe is not present in the array list
            System.out.println("This is not an existing recipe."); // added, SH
        }
        else{ //if the selected recipe is present in the array list
            recipe = listOfRecipes.get(arrayListNumber); //get the recipe that matches the passed-in name
	
            recipe.printRecipe(); // added; prints recipe's recipe SH
            System.out.println(""); // new line added to enhance readability
        }
    }

    
/////////////////////////////////////////////////////////////////////////
    /**
     * Custom Method to display cost of a chosen recipe. API NOTE: Method printAllRecipeDetails (above) used as template.
     */
    /**
     * To set the List of Recipes (Mutator)
     * @param listOfRecipes 
     */
    public void calculateRecipeCost(String selectedRecipeName) {
        int arrayListNumber = -1; //To get the location where the selected recipe is present in the array list
        Recipe recipe; //variable of type Recipe
        
        for(int i = 0; i < listOfRecipes.size(); i++) { //Looping through the listOfRecipes arraylist to find the location of the selected recipe
           if(listOfRecipes.get(i).getRecipeName().equals(selectedRecipeName)) { // /*You forgot to add getRecipeName() into the comparison*/ Iterates through recipe list then converts to string then compares string to string of selectedRecipeName -- SH
               arrayListNumber = i;
           }
        }
        
        if(arrayListNumber == -1){ //if the selected recipe is not present in the array list
            System.out.println("This is not an existing recipe."); // added, SH
        }
        else{ //if the selected recipe is present in the array list
            recipe = listOfRecipes.get(arrayListNumber); //get the recipe that matches the passed-in name
	
            recipe.calcRecipeCost(); //  Calculates recipe's cost
            System.out.println(""); // new line added to enhance readability
        }
        
    }
    
/////////////////////////////////////////////////////////////////////////
    /**
     * Custom Method to display all the recipes present in the recipe box
     */
    public void printAllRecipeNames(){
        System.out.println("\nList of Recipes:");
        
         for(int i = 0; i < listOfRecipes.size(); i++) {
             System.out.println(listOfRecipes.get(i).getRecipeName());
         }
         System.out.println(""); // new line added to enhance readability
    }    
    
 /////////////////////////////////////////////////////////////////////////
    
    /*Start of Main method*/
    public static void main(String[] args) {
        
        RecipeBox myRecipeBox = new RecipeBox(); // Creating object
        Scanner menuScnr = new Scanner(System.in); // Creating Scanner object
        boolean endOper = false;
        Scanner recipeScnr; //moved this from switch case 2 as it could be used in case 2 or 4 now. Is initialized later
        String selectedRecipeName; //moved this from switch case 2 as it could be used in case 2 or 4 now. Is initialized later
        
        /**
         * Print a menu for the user to select one of the three options:
         *
         */

        System.out.println("Menu\n" + "1. Add Recipe\n" + "2. Print All Recipe Details\n" + "3. Print All Recipe Names\n" + "4. Print Cost of Recipe\n" + "5. End Operation\n" + "\nPlease select a menu item:");
        while (!endOper && menuScnr.hasNextInt()) {
            int input = menuScnr.nextInt();//Getting the input from the user
            
            //API NOTE: submitting a non-number into the switch ends the program
            
            /* Perform operations according to the menu item selected */
            switch (input) {
                case 1:
                    
                    /** call method to create new recipe and add to list **/
                    myRecipeBox.addNewRecipe(); // method to create new recipe - SH
                    break;
                case 2:
                    recipeScnr = new Scanner(System.in);
                    System.out.println("Which recipe?\n");
                    selectedRecipeName = recipeScnr.nextLine();
                    
                    myRecipeBox.printAllRecipeDetails(selectedRecipeName); // added - SH
                    
                    break;
                case 3:
                    myRecipeBox.printAllRecipeNames();
                    break;
                case 4: // API NOTE: 4 no longer ends the program. It goes to calculate recipe cost. calcRecipeCost is found in the Recipe class
                    recipeScnr = new Scanner(System.in);
                    System.out.print("Which recipe?\n");
                    selectedRecipeName = recipeScnr.nextLine();
                    
                    myRecipeBox.calculateRecipeCost(selectedRecipeName);
                    //Recipe.calcRecipeCost();
                    
                    break;
                case 5: // API NOTE: changed from case 4 to accomodate calculating recipe cost
                    endOper = true;
                    break;
                    
                default:
                    System.out.println("\nPlease make an appropriate selection - 1, 2, 3, 4, or 5"); // added 5 as an option
                    break;
            }

	    // prompt again
            if (!endOper) {	
            	System.out.println("Menu\n" + "1. Add Recipe\n" + "2. Print All Recipe Details\n" + "3. Print All Recipe Names\n" + "4. Print Cost of Recipe\n" + "5. End Operation\n" + "\nPlease select a menu item:");
	    }
        }
    } //API NOTE: these recipes and ingredient details are not saved in memory. Nothing is saved in memory. Something to read up on.
}