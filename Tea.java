/**
 * Tea.java - Represents one tea, cotaining all data from CaffeinatedBeverage
 * and adds brew temp in celsuis (not current)
 * 
 * @author Nathan Tshishimbi <W7404862@student.miracosta.edu>
 * @version 02/26/2026
 */
public class Tea extends CaffeinatedBeverage {

    //** CONSTANTS **//
    public static final int DEFAULT_BREW_TEMP = 90;


    //** INSTANCE VARIABLES **//
    private int brewTemp;


    //** CONSTRUCTORS **//
    /**
     * Full Constructor with error handling (program shuts down on invalid data)
     * 
     * @param name beverage name
     * @param ounces number of fluid ounces present in beverage container (not total capacity of container)
     * @param price cost of beverage, either pruchase or material cost
     * @param brewTemp temperature tea is brewed at (celsius)
     */
    public Tea(String name, int ounces, double price, int brewTemp) {
        super(name, ounces, price); //Sets the old data
        if (!this.setBrewTemp(brewTemp)) { //Sets the new data
            System.out.println("ERROR: Bad data given to full Tea constructor.");
            System.exit(0);
        }
    }


    /**
     * Default Constructor with class constant variable
     */
    public Tea() {
        
        super(); //Sets the old data
        this.setBrewTemp(DEFAULT_BREW_TEMP); //Sets the new data
    }


    /**
     * Copy constructor creats a deep copy of all instance variables with error handling (program shuts down on invalid data)
     */
    public Tea(Tea original) {
        if (original != null) {
            this.setAll(original.getName(), original.getOunces(), original.getPrice(), original.brewTemp);
        } else {
            System.out.println("ERROR: null data given to copy constructor. ");
            System.exit(0);
        }
    }


    //** SETTERS / MUTATORS **//
    /**
     * Sets brew temperature for object (with error checking)
     * 
     * @param brewTemp brewing temperature in celsius
     * 
     * @return boolean true if valid (> 0), false otherwise
     */
    public boolean setBrewTemp(int brewTemp) {
        if (brewTemp > 0) {
            this.brewTemp = brewTemp;
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
     * @param brewTemp brewing temperature in celsius
     * 
     * @return boolean true if all four parameters are valid inputs 
     */
    public boolean setAll(String name, int ounces, double price, int brewTemp) {
        return super.setAll(name, ounces, price) && this.setBrewTemp(ounces);
    }


    //** GETTERS / ACCESSORS **//
    /**
     * Gets brew temperature in celsius
     * 
     * @return temp tea was brewed at (in °C)
     */
    public int getBrewTemp() {
        return this.brewTemp;
    }


    //** OTHERS REQUIRED METHODS **//
    @Override //cleaned up (for convention; more flexible)
    public boolean equals(Object other) {
        if (other == null || other instanceof Tea) {
            return false;
        }
        Tea otherTea = (Tea) other;
        return super.equals(otherTea) && this.brewTemp == otherTea.brewTemp;
    }

    @Override
    public String toString() {
        String caffeineString = super.toString();
        int colonLocation = caffeineString.indexOf(":");
        caffeineString = caffeineString.substring(colonLocation + 2); // cut off front label from CaffeinatedBeverage

        return String.format("Tea: %s,  brewed @ %d°C", caffeineString, this.brewTemp);
    }

}