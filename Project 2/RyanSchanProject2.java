import java.util.Scanner;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Project1V2 
{

	public static void main(String[] args) 
	{
		// declare variables
		String choice = "y";

		Scanner scan = new Scanner(System.in);
		Date now = new Date();

		// get currency and date format
		NumberFormat fmt = NumberFormat.getCurrencyInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("M/dd/yyyy");
		sdf.setLenient(false);

		// Print the date and time

		System.out.println("	Ryan's Power & Light");
		System.out.println("	   Billing Statement");
		System.out.println("	   ");
		System.out.println("Today's Date: " + sdf.format(now));
		while (!choice.equalsIgnoreCase("n")) // the main loop that controls and repeats the program.
										
		{
			// declare variables
			String name;
			String dateIn = "";
			int month = 0;
			int usedKW = 0;
			double total = 0.0;
			double excess = 0.0;
			double baserate = 0.0;
			double overBase = 0.0;
			double baseline = 0.0;
			boolean valid = false;
			boolean valid1 = false;
			double overBaseCharge = 0.0;
			double excessCharge = 0.0;
			// get inputs
			System.out.print("Please enter your name(Last, First I.): ");
			name = scan.nextLine();

			while (valid1 == false) 
			{
				try // data validation for date
				{
					Scanner scan1, scan2;
					scan1 = new Scanner(System.in);
					System.out.print("Please enter a date (mm/dd/yyyy) > ");

					// Date must be valid or the next statement will fail
					dateIn = scan1.nextLine();

					// Try to convert dateIn to a valid date
					sdf.parse(dateIn);

					// Date entered must be valid to get this far
					valid1 = true;

					// Create a new scanner using the existing valid input
					scan2 = new Scanner(dateIn);
					scan2.useDelimiter("/");

					// Parse input for individual values
					month = scan2.nextInt();
				}

				catch (Exception e) // if date is not valid
				{
					System.out
							.println("Date entered is not valid.  Please try again.");
					continue;
				}

				// data validation for KW used.
				while (valid == false) 
				{
					System.out.print("please enter electricity used: ");
					if (scan.hasNextDouble()) {
						usedKW = scan.nextInt();
						valid = true;
					} else { // if kw used is not valid.
						scan.nextLine();
						System.out
								.println("please enter a valid integer. Please try again.");

					}
				}

				// calculations

				if ((month <= 2 | month == 12)) // if the month is January, February, or December
				{ 
					baserate = .10;								
					total = usedKW * baserate;
					baseline = usedKW * baserate;
					
				}

				if (month >= 3 & month <= 5)  // if the month is March,April,
				{
					baserate = .12;							
					total = usedKW * baserate;
					baseline = usedKW * baserate;
					

				}
				if ((month >= 6 & month <= 11)) // all other months
				{
				
					baserate = .15;
					total = usedKW * baserate;
					baseline = usedKW * baserate;
					
				}

				if (usedKW >= 350 & usedKW <= 500) // checks to see if the KW is in between 350 and 500								
				{
					overBase = usedKW - 350; //subtracts the first rate zone 
					baseline = 350 * baserate;
					overBaseCharge = overBase * (baserate * 1.1);
					total = baseline + overBaseCharge;

				}
				if (usedKW >= 500) // checks to see if the KW is over 500
				{

					excess = usedKW - 500; // subtracts the third rate zone from the 500					
					overBase = usedKW - 350 - excess; //subtracts the second rate zone and the first rate zone
					baseline = 350 * baserate;
					overBaseCharge = overBase * (baserate * 1.1);
					excessCharge = excess * (baserate * 1.25);
					total = baseline + overBaseCharge + excessCharge;

				}

				// round total
				total = Math.round(total * 100) / 100.0;

				// display output
				scan = new Scanner(System.in);
				System.out.println(" ");
				System.out.println("Name: " + name);
				System.out.println("Meter reading date: " + dateIn);
				System.out.println("Electricity Used(KW): " + usedKW);
				System.out.println(" ");
				System.out.printf("%-7s %20s\n", "Your Baseline charge is:",fmt.format(baseline));
				System.out.printf("%-1s %15s\n","Your Over-baseline charge is:",fmt.format(overBaseCharge));
				System.out.printf("%-7s %22s\n", "Your Excess charge is:", fmt.format(excessCharge));
				System.out.println("     ");
				System.out.printf("%-7s %19s\n", "Your Total amount due is:",fmt.format(total));
				System.out.print("Would you like to calculate another bill(Y/N): ");
				choice = scan.nextLine();
				System.out.println(" ");
			}

		}
		System.out.println("	Thank you for letting us serve you!");
	}
}
