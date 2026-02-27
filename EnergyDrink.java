/**
 * EnergyDrink.java - Represents one energy drink, containing all data from CaffeinatedBeverage
 * and adds brand name
 * 
 * @author Nathan Tshishimbi <W7404862@student.miracosta.edu>
 * @version 02/26/2026
 */
public class EnergyDrink extends CaffeinatedBeverage {

    //** CONSTANTS **//
    public static final String DEFAULT_BRAND = "Generic Boost";


    //** INSTANCE VARIABLES **//
    private String brand;


    //** CONSTRUCTORS **//
    /**
     * Full Constructor with error handling (program shuts down on invalid data)
     * 
     * @param name beverage name
     * @param ounces number of fluid ounces
     * @param price cost of beverage
     * @param brand name of the brand producing the energy drink
     */
    public EnergyDrink(String name, int ounces, double price, String brand) {
        super(name, ounces, price); // Sets inherited data
        if (!this.setBrand(brand)) { // Sets new data
            System.out.println("ERROR: Bad data given to full EnergyDrink constructor.");
            System.exit(0);
        }
    }


    /**
     * Default constructor sets all to default values
     */
    public EnergyDrink() {
        super();
        this.setBrand(DEFAULT_BRAND);
    }


    /**
     * Copy constructor creates a deep copy of all instance variables
     */
    public EnergyDrink(EnergyDrink original) {
        if (original != null) {
            this.setAll(original.getName(), original.getOunces(), original.getPrice(), original.brand);
        } else {
            System.out.println("ERROR: null data given to copy EnergyDrink constructor.");
            System.exit(0);
        }
    }


    //** SETTERS / MUTATORS **//
    /**
     * Sets brand name for energy drink
     * 
     * @param brand name of energy drink brand
     * 
     * @return true if valid, false otherwise
     */
    public boolean setBrand(String brand) {
        if (brand != null && brand.length() > 0) {
            this.brand = brand;
            return true;
        } else {
            return false;
        }
    }


    /**
     * Sets all instance variables
     * 
     * @param name beverage name
     * @param ounces number of fluid ounces
     * @param price cost
     * @param brand brand name
     * 
     * @return true if all data valid, false otherwise
     */
    public boolean setAll(String name, int ounces, double price, String brand) {
        return super.setAll(name, ounces, price) && this.setBrand(brand);
    }


    //** GETTERS / ACCESSORS **//
    /**
     * Gets brand of energy drink
     * 
     * @return brand name
     */
    public String getBrand() {
        return this.brand;
    }


    //** OTHERS REQUIRED METHODS **//
    @Override
    public boolean equals(Object other) {
        if (other == null || this.getClass() != other.getClass()) {
            return false;
        }
        EnergyDrink otherDrink = (EnergyDrink) other;
        return super.equals(otherDrink) && this.brand.equals(otherDrink.brand);
    }


    @Override
    public String toString() {
        String caffeineString = super.toString();
        int colonLocation = caffeineString.indexOf(":");
        caffeineString = caffeineString.substring(colonLocation + 2); // cut off front label from CaffeinatedBeverage

        return String.format("Energy Drink: %s,  brand: %s", caffeineString, this.brand);
    }
}