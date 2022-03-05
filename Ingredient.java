package Milestones;

import java.util.Scanner;
/**
 *
 * @author Spencer Hobbs
 */

/* Creating an Ingredient class */
public class Ingredient {
       
    /* Declaring private variables in Ingredient class */
    private String nameOfIngredient;
    private float numberCups; // also acceptable if double
    private int numberCaloriesPerCup;
    private double totalCalories;
    
    
    /*Defining a constructor*/
    public Ingredient(){
        /*Initializing variables*/
        nameOfIngredient = "";
        numberCups = 0;
        numberCaloriesPerCup = 0;
        totalCalories = 0.0;
    }

    /*Method to set name of ingredient*/
    public void setNameOfIngredient(String nameIngr){
        
         nameOfIngredient = nameIngr;
    }

    /*Method to get name of ingredient*/
    public String getNameOfIngredient(){
        
        return nameOfIngredient;
    }

    /*Method to set number of cups*/
    public void setNumberCups(float numCups){
        
        numberCups = numCups;
    }

    /*Method to get number of cups*/  
    public float getNumberCups(){
        
        return numberCups;
    }

    /*Method to set number of calories*/
    public void setNumberCaloriesPerCup(int numCal){
        
        numberCaloriesPerCup = numCal;
    }

    /*Method to get number of calories*/
    public int getNumberCaloriesPerCup(){
        
        return numberCaloriesPerCup;
    }

    /*Method to get total number of calories*/    
    public double getTotalCalories(){
        /* Calculate total calories */
        totalCalories = numberCups * numberCaloriesPerCup;
        return totalCalories;
    }

    /* Main method */    
    public Ingredient addIngredient() {
        
        
    // Declare variables for passing into 'ing' ingredient later
       String tempNameOfIngredient = "";
       float tempNumberOfCups = 0;
       int tempNumCaloriesPerCup = 0;
       
    
    // Creating this Ingredient object allows us to use the class methods above
       Ingredient ing = new Ingredient();
       // Initialize scanner, SH
       Scanner scnr = new Scanner(System.in);
    
    
    // Prompts user to enter ingredient name. Assigns it to tempNameofIngredient
       System.out.println("Enter the ingredient name: ");
       tempNameOfIngredient = scnr.next();
       
       
    // Validates name of ingredient as letters and not numbers or special characters
    if(tempNameOfIngredient.matches("[a-zA-Z]*")) {
        System.out.println("Indredient name is VALID.");
       }
    else {
        System.out.println("Ingredient name is INVALID. Please enter a name using letters only.");
        tempNameOfIngredient = scnr.next();
        if(tempNameOfIngredient.matches("[a-zA-Z]*")) {
            System.out.println("Indredient name is VALID.");
            }
        else{
           System.out.println("Ingredient name is INVALID. You are out of attempts.");
           System.exit(0); // We end the program if too many errors are made
          }
    
         }

    
    // The ingredient name entered above is assigned to our 'ing' ingredient here.  
    // nameOfIngredient = tempNameOfIngredient; CANNOT be used here as nameOfIngredient
    // is a non-static variable and cannot be referenced in a static context.
    // Plus we want to assign the name to our ingredient 'ing' anyway.
       ing.setNameOfIngredient(tempNameOfIngredient);

    
    // Propmting user for number of cups. Assigning the value to tempNumberOfCups
       System.out.println("Enter the NUMBER of cups for the ingredient: ");
       tempNumberOfCups = scnr.nextFloat();
    // Entering a letter or special character above fails the program
    // Future idea - have it enter as a string, convert that string to Float if number, if text
    // then prompt user to try again.
       
    
    // Validating cups is a non-negative number. Provides two chances to user to get it correct.
    if(tempNumberOfCups >= 0) {
        System.out.println("Number of cups is VALID."); // capitalized for better visability
       }
    else {
        System.out.println("Number of cups is INVALID. Please enter a positive number.");
        tempNumberOfCups = scnr.nextFloat();
        if(tempNumberOfCups >= 0) {
            System.out.println("Number of cups is VALID.");
            }
        else{
           System.out.println("Number of cups is INVALID. You are out of attempts.");
           System.exit(0); // We end the program if too many errors are made 
            }
    
         }
    
    // Apply number of cups to our ingredient 'ing' 
       ing.setNumberCups(tempNumberOfCups);
     
    // Obtain number of calories per cup. Apply it to tempNumCaloriesPerCup
       System.out.println("Enter the NUMBER of calories per cup: ");
       tempNumCaloriesPerCup = scnr.nextInt();
       
       
    // Validating calories per cup is a non-negative number. Provides two chances to user to get it correct.
    if(tempNumCaloriesPerCup >= 0) {
        System.out.println("Calories per cup is VALID.");
       }
    else {
        System.out.println("Calories per cup is INVALID. Please enter a positive integer.");
        tempNumCaloriesPerCup = scnr.nextInt();
        if(tempNumCaloriesPerCup >= 0) {
            System.out.println("Calories per cup is VALID.");
            }
        else{
           System.out.println("Calories per cup is INVALID. You are out of attempts.");
           System.exit(0); // We end the program if too many errors are made 
            }
    
         }
    
    
    // Apply calories per cup to our ingredient 'ing' 
       ing.setNumberCaloriesPerCup(tempNumCaloriesPerCup);


    // Summarizes everything entered by the user.  
       System.out.println(ing.getNameOfIngredient() + " uses " + ing.getNumberCups() + 
               " cups and has " + ing.getTotalCalories() + " calories.");
   
   return ing;
   } 
}