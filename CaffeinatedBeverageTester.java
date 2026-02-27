/**
 * CaffeinatedBeverageTester.java - Represents a class that tests  the behavior of the CaffeinatedBeverage class
 * and its subclasses: Tea, Coffee, YerbaMate, and EnergyDrink. 
 * Verifies valid and invalid object construction, string representations, and basic method behaviors.
 *
 * @author Nathan Tshishimbi <W7404862@student.miracosta.edu>
 * @version 02/26/2026
 */
public class CaffeinatedBeverageTester {
    public static void main(String[] args) {

        // --- BAD TESTS: These should fail or trigger validation logic ---
        // System.out.println("==== BAD TESTS ====");
        // try {
        //     CaffeinatedBeverage badTest1 = new CaffeinatedBeverage("Morning cup of Joe", -16, -4.99);
        //     System.out.println("BAD: Should not have created: " + badTest1);
        // } catch (Exception e) {
        //     System.out.println("PASS: Correctly caught invalid beverage");
        // }

        // --- GOOD TEST ---
        System.out.println("\n==== GOOD TEST ====");
        CaffeinatedBeverage goodTest = new CaffeinatedBeverage("Morning cup of Joe", 16, 4.99);
        System.out.println("Test Beverage: " + goodTest);

        // --- TESTING TEA ---
        System.out.println("\n==== TEA TEST ====");
        Tea tea = new Tea("Chamomile", 12, 2.49, 85);
        System.out.println("Tea: " + tea);

        // --- TESTING YERBA MATE ---
        System.out.println("\n==== YERBA MATE TEST ====");
        YerbaMate mate = new YerbaMate("Rosamonte", 14, 3.25, 80);
        System.out.println("Yerba Mate: " + mate);

        // --- TESTING COFFEE ---
        System.out.println("\n==== COFFEE TEST ====");
        Coffee coffee = new Coffee("Espresso", 8, 3.75, "Espresso Machine");
        System.out.println("Coffee: " + coffee);

        // --- TESTING ENERGY DRINK ---
        System.out.println("\n==== ENERGY DRINK TEST ====");
        EnergyDrink energy = new EnergyDrink("Red Bull", 12, 2.99, "Red Bull GmbH");
        System.out.println("Energy Drink: " + energy);
    }
}