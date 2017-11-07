import java.util.*;
public class Main {
	private static Scanner in;
	public static void main(String[] args) {
		int iInt = 1;
		int moveCount = 0;
		int eInt = 0;
		int currentLargest = 0;
		int editedLargest = 0;
		boolean cEven = true;
		getInt(iInt);
		if (checkForZeros(iInt) == true) {
			isZeros(iInt, eInt, moveCount, currentLargest, cEven, editedLargest);
		} else {
			//noZeros(iInt, eInt, moveCount, currentLargest, cEven, editedLargest);
		}
	}
	///////////////////////
	// UNIVERSAL METHODS //
	///////////////////////
	public static int getInt(int iInt) {
		// Obtains an Int from user
		in = new Scanner(System.in);
		System.out.println("Enter an Integer: ");
		iInt = in.nextInt();
		return iInt;
	}
	public static boolean checkForZeros(int iInt) {
		// Checks the int to see is there are any Zeros
		 while(iInt > 0) {
		        if(iInt % 10 == 0)
		            return true;
		        iInt /= 10;
		    }
		 return false;	
	}
	private static boolean checkType(int currentLargest, boolean cEven) {
		if (currentLargest%2 == 0 ) {
			cEven = true;
		} else {
			cEven = false;
		}
		return cEven;
	}
	private static int findLargest(int eInt, int currentLargest) {
		// TODO Find the largest Value in the integer
		// set that number = currentLargest and return it
		
		//last
		return currentLargest;
	}

	//////////////
	// is Zeros //
	//////////////
	private static void isZeros(int iInt, int eInt, int moveCount, int currentLargest, boolean cEven, int editedLargest) {
			// TODO Functions that run when a Zero is found
		findAndRemove(iInt, eInt);
		findLargest(eInt, currentLargest);
		checkType(currentLargest, cEven);
		if(cEven == true) {
			editedLargest = currentLargest - 2;
		} else {
			editedLargest = currentLargest - 1;
		}
		findAndRepalce(eInt, currentLargest, editedLargest);	
		eInt = iInt;
		moveCount += 1;
	}
	private static int findAndRepalce(int eInt, int currentLargest, int editedLargest) {
		// TODO Auto-generated method stub
		// Search for currentLargest in eInt and replace it with editedLargest.
		// int tInt = 0; //use a temp int to manipulate then set it equal to eInt once you have the final edited value
		
		
		
		
		return eInt;
	}
	private static int findAndRemove(int iInt, int eInt) {
		// TODO Find Zeros and Remove #s to the left

		// First find the zero AND WHERE IT IS reading from right to left
		// Then remove all numbers to the left
		// assign the new number to eInt
		//this is last
		return eInt;
	}
	//////////////
	// NO ZEROS //
	//////////////
	/*private static int noZeros(int iInt) {
		// TODO Functions that run when no zeros are found
		findLargest(iInt);
		checkType(iInt);
		
		//last
		return iInt;
		
	}*/
}
