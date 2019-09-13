import java.util.Scanner;

/** Heading  *****************************************************/
/*	Your name: Anubhav Shelat
	Class block: H				Date Started: 9/6/2019
	Lab Number: 0
	Title: Simple Algorithms
	Purpose: Program some simple functions
*/

public class src {
	
	private static Scanner input;	// scanner input 
	
	public src() {
		input = new Scanner(System.in);		// init scanner
		menu();								// call menu()
	}
	public void menu()
	{
	    int choice = 0;
	    do 
	    {
	       
	       System.out.println("1. Find Factors");
	       System.out.println("2. Find GCD");
	       System.out.println("3. Count digits");
	       System.out.println("4. List Digits");
	       System.out.println("5. Find digits");
	       System.out.println("6. Raise a number to a power.");
	       System.out.println("7. Determine if an int is prime");
	       System.out.println("8. Quit");
	       choice = input.nextInt();
	       
	       switch (choice) {
	       		case 1: 
	       			System.out.print("Enter a number: ");
	       			factors(input.nextInt());
	       			break;
	       		case 2:
	       			System.out.print("Enter two numbers to find GCD of: ");
	       			int gcd = GCD(input.nextInt(), input.nextInt());
	       			System.out.println("GCD: " + gcd);
	       			break;
	       		case 3:
	       			System.out.print("Enter a number: ");
	       			int count = countDigits(input.nextInt());
	       			System.out.println("Your number has " + count + " digits.");
	       			break;
	       		case 4:
	       			System.out.print("Enter number to print digits of: ");
	       			downDigits(input.nextInt());
	       			break;
	       		case 5:
	       			System.out.print("Enter a number and a number n that indicates number of digits to the right: ");
	       			int digit = findDigit(input.nextInt(), input.nextInt());
	       			System.out.println("Your digit is " + digit);
	       			break;
	       		case 6:
	       			System.out.print("Enter a base and an exponent in that order: ");
	       			double answer = power(input.nextDouble(), input.nextInt());
	       			System.out.println("Answer: " + answer);
	       			break;  
	       		case 7:
	       			System.out.print("Enter a number: ");
	       			boolean prime = prime(input.nextInt());
	       			if (prime == true) {
	       				System.out.println("The number is prime.");
	       			}
	       			else {
	       				System.out.println("The number isn't prime.");
	       			}
	       			break;
	       }
	    } while (choice != 8);
	}

	public static void factors(int number) {
  
		  if (number == 0) {
			  System.out.print("All numbers");
		  }
		  else {
			  for (int i = 1; i < number; i++) {
				  if (number % i == 0) {
					  System.out.print(i + ", ");
				  }
			  }
			  System.out.println(number);
		  }
		  
	}
	
	public static int GCD(int a, int b) {
		// Check for trivial cases
		if (a == 0) {
			return b;
		}
		else if (b == 0) {
			return a;
		}
		else if (a % b == 0) {
			return b;
		}
		else if (b % a == 0) {  
			return a;
		}
		// Euclidean algorithm
		int remainder;
		while (a != 0 && b != 0) {
			remainder = a % b;
			if (b % remainder == 0) {
				return remainder;
			}
			else {
				a = b;
				b = remainder; 
			}
		}
		return a;
	}
	
	public static double power(double base, int exponent) {
		double answer = 1;
		if (exponent > 0) {
			for (int i = 0; i < exponent; i++) {
				answer *= base;
			}
		}
		else if (exponent < 0) {
			for (int j = 0; j < -1*(exponent); j++) {
				answer /= base;
			}
		}
		else {
			return 1;
		}
		return answer;
	}
	
	public static boolean prime(int num) {
		for (int i = 2; i < num; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static int countDigits(double number) {
		int count = 0;
		if (number == 0) {
			return 1;
		}
		for (int i = 1; i <= number; i *= 10) {
			count++;
		}
		return count;
	}
	
	public static int findDigit(int num, int n) {
		int digit;
		if (num >= 0) {
			double place = power(10, n);
			digit = (int) (((num % place) - (num % (place/10))) / (place / 10));
			return digit;
		}
		else {
			digit = findDigit(-1 * num, n);
			return digit;
		}
	}
	
	public static void downDigits(int num) {			
		int numDigits = countDigits(num);
		System.out.println("The digits of " + num + " are: ");
		for (int i = 0; i < numDigits; i++) {
			System.out.println(findDigit(num, numDigits - i));
		}	
	}
	
	public static void main(String[] args) 
	{
		new src();
	}
}
