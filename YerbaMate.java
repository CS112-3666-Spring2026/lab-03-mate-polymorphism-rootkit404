/**
 * YerbaMate.java - Represents one YerbaMate drink, containing all data from Tea,
 * and number of passes (represents the number of people that have drank from the
 * same guard when sharing a mate in the traditional customs.)
 * 
 * 
 * @author Nathan Tshishimbi <W7404862@student.miracosta.edu>
 * @version 02/26/2026
 */
public class YerbaMate extends Tea {
    
    //** CONSTANTS **//
    public static final int DEFAULT_NUM_PASSES = 0;


    //** INSTANCE VARIABLES **//
    private int numPasses;


    //** CONSTRUCTORS **//
    /**
     * Full Constructor with error handling (program shuts down on invalid data)
     * 
     * @param name beverage name
     * @param ounces number of fluid ounces present in beverage container (not total capacity of container)
     * @param price cost of beverage, either pruchase or material cost
     * @param brewTemp temperature tea is brewed at (in celsius)
     * @param numPasses number of passes between people that have shared a drink from the gaurd container
     */
    public YerbaMate(String name, int ounces, double price, int brewTemp, int numPasses) {
        super(name, ounces, price, brewTemp); //Sets the old data
        if (!this.setNumPasses(numPasses)) { //Sets the new data
            System.out.println("ERROR: Bad data given to full YerbaMate constructor.");
            System.exit(0);
        }
    }

    /**
     * Overloaded Constructor with error handling (program shuts down on invalid data),
     * defaults numPasses to 0 for easy alterntive to building an object
     * 
     * @param name beverage name
     * @param ounces number of fluid ounces present in beverage container (not total capacity of container)
     * @param price cost of beverage, either pruchase or material cost
     * @param brewTemp temperature tea is brewed at (in celsius)
     */
    public YerbaMate(String name, int ounces, double price, int brewTemp) {
        this(name, ounces, price, brewTemp, DEFAULT_NUM_PASSES);
    }


    /**
     * Default Constructor with class constant variable
     */
    public YerbaMate() {
        super(); // Sets inherited data
        this.setBrewTemp(DEFAULT_BREW_TEMP); // Sets the new data
    }


    /**
     * Copy constructor creats a deep copy of all instance variables with error handling (program shuts down on invalid data)
     */
    public YerbaMate(YerbaMate original) {
        if (original != null) {
            this.setAll(original.getName(), original.getOunces(), original.getPrice(), original.getBrewTemp(), original.numPasses);
        } else {
            System.out.println("ERROR: null data given to copy constructor. ");
            System.exit(0);
        }
    }


    //** SETTERS / MUTATORS **//
    /**
     * Sets number of passes (with error checking)
     * 
     * @param numPasses number of passes between people that have shared a drink from the gaurd container
     * 
     * @return boolean true if valid (>= 0), false otherwise
     */
    public boolean setNumPasses(int numPasses) {
        if (numPasses >= 0) {
            this.numPasses = numPasses;
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
     * @param brewTemp temperature tea is brewed at (in celsius)
     * @param numPasses number of passes between people that have shared a drink from the gaurd container
     *  
     * @return boolean true if all five parameters are valid inputs 
     */
    public boolean setAll(String name, int ounces, double price, int brewTemp, int numPasses) {
        return super.setAll(name, ounces, price, brewTemp) && this.setNumPasses(brewTemp);
    }  


    /**
     * Increments numPasses and prints message to console that the mate was passed (along with the current count)
     */
    public void passMate() {
        this.numPasses++;
        System.out.println("Passed the mate, current # of passes: " + this.numPasses);
    }


    /**
     * When given a # of ounces of warter that were added, method will add to the ounces from CaffeinatedBeverage
     * 
     * @param ounces number of fluid ounces present in beverage container (not total capacity of container)
     */
    public void refill(int ounces) {
        if (ounces > 0) {
            this.setOunces(this.getOunces() + ounces);
        }
    }


    //** GETTERS / ACCESSORS **//
    /**
     * Gets brew temperature in celsius
     * 
     * @return temp tea was brewed at (in °C)
     */
    public int getNumPasses() {
        return this.numPasses;
    }


    //** OTHERS REQUIRED METHODS **//
    @Override
    public boolean equals(Object other) {
        if (other == null || this.getClass() != other.getClass()) {
            return false;
        }
        YerbaMate otherMate = (YerbaMate) other;
        return super.equals(otherMate) && this.numPasses == otherMate.numPasses;
    }

    @Override
    public String toString() {
        String teaString = super.toString();
        int colonLocation = teaString.indexOf(":");
        teaString = teaString.substring(colonLocation + 2); // cut off front label from Tea

        return String.format("YerbaMate: %s, %d passes so far ", teaString, this.numPasses);
    }
}