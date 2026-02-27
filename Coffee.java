/**
 * Coffee.java - Represents one coffee, cotaining all data from CaffeinatedBeverage
 * and adds brew type
 * 
* @author Nathan Tshishimbi <W7404862@student.miracosta.edu>
 * @version 02/26/2026
 */
public class Coffee extends CaffeinatedBeverage {

    //** CONSTANTS **//
    public static final String DEFAULT_BREW_TYPE = "Pour-over";


    //** INSTANCE VARIABLES **//
    private String brewType;


    //** CONSTRUCTORS **//
    /**
     * Full Constructor with error handling (program shuts down on invalid data)
     * 
     * @param name beverage name
     * @param ounces number of fluid ounces present in beverage container (not total capacity of container)
     * @param price cost of beverage, either pruchase or material cost
     * @param brewType type of brew method used to make coffee
     */
    public Coffee(String name, int ounces, double price, String brewType) {
        super(name, ounces, price); //Sets the old data
        if (!this.setBrewType(brewType)) { //Sets the new data
            System.out.println("ERROR: Bad data given to full Tea constructor.");
            System.exit(0);
        }
    }


    /**
     * Default Constructor with class constant variable
     */
    public Coffee() {
        
        super(); //Sets the old data
        this.setBrewType(DEFAULT_BREW_TYPE); //Sets the new data
    }


    /**
     * Copy constructor creats a deep copy of all instance variables with error handling (program shuts down on invalid data)
     */
    public Coffee(Coffee original) {
        if (original != null) {
            this.setAll(original.getName(), original.getOunces(), original.getPrice(), original.brewType);
        } else {
            System.out.println("ERROR: null data given to copy Coffee constructor. ");
            System.exit(0);
        }
    }


    //** SETTERS / MUTATORS **//
    /**
     * Sets brew type for coffee (with error checking)
     * 
     * @param brewType type of brew method used to make coffee
     * 
     * @return boolean true if valid (not null & String length > 0), false otherwise
     */
    public boolean setBrewType(String brewType) {
        if (brewType != null && brewType.length() > 0) {
            this.brewType = brewType;
            return true;
        } else {
            return false;
        }
    }


    /**
     * Sets all instance variables
     * 
     * @param name beverage name
     * @param ounces number of fluid ounces present in beverage container (not total capacity of container)
     * @param price cost of beverage, either pruchase or material cost
     * @param brewType type of brew method used to make coffee
     *  
     * @return boolean true if all four parameters are valid inputs 
     */
    public boolean setAll(String name, int ounces, double price, String brewType) {
        return super.setAll(name, ounces, price) && this.setBrewType(brewType);
    }


    //** GETTERS / ACCESSORS **//
    /**
     * Gets brew method used to make coffee
     * 
     * @return type of method used to make coffee
     */
    public String getBrewType() {
        return this.brewType;
    }


    //** OTHERS REQUIRED METHODS **//
    @Override 
    public boolean equals(Object other) {
        if (other == null || this.getClass() != other.getClass()) { //using getClass() because no class is likely to derive from Coffee
            return false;
        }
        Coffee otherCoffee = (Coffee) other;
        return super.equals(otherCoffee) && this.brewType == otherCoffee.brewType;
    }

    @Override
    public String toString() {
        String caffeineString = super.toString();
        int colonLocation = caffeineString.indexOf(":");
        caffeineString = caffeineString.substring(colonLocation + 2); // cut off front label from CaffeinatedBeverage

        return String.format("Coffee: %s,  brewed by %s method", caffeineString, this.brewType);
    }
}