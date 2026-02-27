import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		//Array of size 10 to store number of drink options
		CaffeinatedBeverage[] inventory = new CaffeinatedBeverage[10];
		Scanner keyboard = new Scanner(System.in);
		// Prompt user with options in a loop
		int choice, ounces = 0, brewTemp = 0, count = 0;
		String name = null, brewType = null, brand = null;
		double price = 0.0;
		
		do
    	{
			System.out.println("1) Enter new Tea");
			System.out.println("2) Enter new Yerba Mate");
			System.out.println("3) Enter new Coffee");
			System.out.println("4) Enter new Energy Drink");
			System.out.println("5) Exit\n");
			System.out.print(">>");
			choice = keyboard.nextInt();
			keyboard.nextLine(); // clear newline in buffer
			
			if (choice >= 1 && choice <= 4) {
				//CaffeinatedBeverage data
				System.out.print("Enter name      : ");
				name = keyboard.nextLine();
				System.out.print("Enter ounces    : ");
				ounces = keyboard.nextInt();
				System.out.print("Enter price     $ ");
				price = keyboard.nextDouble();
				keyboard.nextLine(); // clear newline in buffer
			}


			// Getting specific data from derived classes
			switch (choice)
			{
				case 1:
					// Tea specific data
					System.out.println("Enter brew temperature (in °C): ");
					brewTemp = keyboard.nextInt();

					// Create a Tea, put into array
					inventory[count] = new Tea(name, ounces, price, brewTemp);
					System.out.println("Your tea order has been added! " + inventory[count]);

					count++;
					break;
				case 2:
					// YerbaMate specific data
					// NONE assuming number of passes is 0, (but data input is optional)

					// Create a YerbaMate, put into array
					inventory[count] = new YerbaMate(name, ounces, price, brewTemp);

					count++;
					break;
				case 3:
					// Coffee specific data
					System.out.println("Enter brew type or method used: ");
					brewType = keyboard.nextLine();

					// Create a Coffee, put into array
					inventory[count] = new Coffee(name, ounces, price, brewType);
					System.out.println("Your coffee order has been added! " + inventory[count]);

					count++;
					break;
				case 4:
					// Energy Drink specific data
					System.out.println("Enter energy drink brand: ");
					brand = keyboard.nextLine();

					// Create a Energy Drink, put into array
					inventory[count] = new EnergyDrink(name, ounces, price, brand);
					System.out.println("Your energy drink order has been added! " + inventory[count]);

					count++;
					break;
				case 5:
					// Print all drinks
					System.out.printf("\n\nAll Drinks: ");
					Main.printDrinks(inventory, count);

					//Print average price 
					System.out.format("\nAverage Price = $%.2f\n", Main.findAveragePrice(inventory, count));

					// Print highest priced yerba mate
					YerbaMate mostExpensive = Main.findHighestPriceYerbaMate(inventory, count);
					if (mostExpensive != null) {
						System.out.format("\nHighest Priced Mate = %s%n", mostExpensive);
					} else {
						System.out.println("No YerbaMate found in list of drinks.");
					}
					break;
				default:
					System.out.println("ERROR: not a valid choice. Please choice again from the available lsit of drinks.\n");
			}

		} while (choice != 5);
			
		keyboard.close();

		//insert hacker challenge
	} 

	/** 
	 * Prints all drinks in partially filled array, numbered  in array order
	 * 
	 * @param drinks partially filled array with caffeinated drinks
	 * @param numDrinks size of partially filled array
	 */
	public static void printDrinks(CaffeinatedBeverage[] drinks, int numDrinks) {
		for (int i = 0; i < numDrinks; i++) {
			System.out.println("Drink # " + (i+1) + " = " + drinks[i]);
		}
	}


	/**
	 * Gets the average of all beverages in partially filled array
	 * 
	 * @param drinks partially filled array with caffeinated drinks
	 * @param numDrinks size of partially filled array
	 * 
	 * @return average price of caffeinated drinks (no rounding) 
	 */
	public static double findAveragePrice(CaffeinatedBeverage[] drinks, int numDrinks) {
		double totalPrice = 0;
		for (int i = 0; i < numDrinks; i++) {
			totalPrice += drinks[i].getPrice();
		}
		return totalPrice / numDrinks;
	}


	/**
	 * Finds the YerbaMate with the highest price in the partially filled array
	 * 
	 * @param drinks partially filled array with caffeinated drinks
	 * @param numDrinks size of partially filled array
	 * 
	 * @return YerbaMate with highest price, if none present in array then null
	 */
	public static YerbaMate findHighestPriceYerbaMate(CaffeinatedBeverage[] drinks, int numDrinks) {
		YerbaMate mate = new YerbaMate(), highestPrice = null;

		for (int i = 0; i < numDrinks; i++) {
			if (drinks[i].getClass() == mate.getClass()) { // Checks if the drink at give point in array is the same as yerba mate (can also use "drinks[i] instanceof YerbaMate")
				if(highestPrice == null) { // checks if a price has been set
					highestPrice = (YerbaMate)drinks[i]; // if not, gets set here
				} else if (highestPrice.getPrice() < drinks[i].getPrice()) { // otherwise compares previously set price valie
					highestPrice = (YerbaMate)drinks[i]; // replaces if higher price value is present
				}
			}
		}
		return highestPrice;
	}
}