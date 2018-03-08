import java.util.*;
import java.lang.*;
public class Main {
	private static Scanner in;
	public static void main(String[] args) {
		int iInt = 0; // Initial Int (Not changed often)
		int moveCount = 1; 
		int eInt = 0; // Edited Int (Used for manipulation)
		int len = 0; // Get length
		iInt = getInt(iInt); // get int
		if (iInt < 0) { // make postitive
			iInt *= -1;
			moveCount += 1;
		}
		while (iInt != 0) { // run until 0
			len = (int)(Math.log10(iInt)); // get length
			boolean choice = checkForZeros(iInt, len); // determine what to run
			if (choice == true) {
				iInt = isZeros(iInt, eInt,len); // assign new iInt
				System.out.println(iInt);
				if (iInt > 0) {moveCount +=1;} // add to move count
			} else {
				iInt = noZeros(iInt, eInt,len);
				System.out.println(iInt);
				moveCount +=1;
			}
		}
		System.out.println(moveCount);
	}
	///////////////////////
	// UNIVERSAL METHODS //
	///////////////////////
	public static int getInt(int iInt) { // get the Integer from user
		// Obtains an Int from user
		in = new Scanner(System.in);
		System.out.println("Enter an Integer: ");
		iInt = in.nextInt();
		return iInt;
	}
	public static boolean checkForZeros(int iInt,int len) {
		// Checks the int to see is there are any Zeros
		List<Integer> number = new ArrayList<Integer>();
		int x = 10;
		int y = 1;
		int z = 0;
		int zero = 0;
		for (int i = 0; i < len; i++) {  // put int into list
			z = (iInt % x) / y;
			x *= 10;
			y *= 10;
			number.add(z);
		}
		zero = number.indexOf(0);
		if (zero > -1) {
			return true;
		} else {
			return false;
		}
		 
	}
	//////////////
	// is Zeros //
	//////////////
	private static int isZeros(int iInt, int eInt, int len) { //runs functions that are required when there is a zero
		eInt = iInt;
		iInt = findAndRemove(iInt, eInt, len);
		return iInt;
	}
	private static int findAndRemove(int iInt, int eInt, int len) { //finds the 0 and removes #s to left
		List<Integer> number = new ArrayList<Integer>();
		int x = 10;
		int y = 1;
		int z = 0;
		int zero = 0;
		int tlen = 0;
		for (int i = 0; i < len; i++) {  // put int into list
			z = (iInt % x) / y; // find digit using integer proscessing
			x *= 10; // next digit
			y *= 10; // next digit
			number.add(z); // add digit to list
		}
		zero = number.indexOf(0); // find index of 0
		for (int i = zero; i < len;i++) { 
				number.remove(zero); // remove all numbers left of zero (right of in list)
			}
		if (zero == 0) // if 0 is at the far right of # remove all #s
			number.removeAll(number);
		tlen = number.size(); 
		int p = 1;
		eInt = 0;
		if (zero > 0) { // take #s out of list
			for (int i = 0; i < tlen;i++) {
				int k = number.get(i);
				eInt = eInt + (k * p);
				p *= 10;
			}
		} else { // if zero = 0 set int to 0
			eInt = 0;
		}
		
		return eInt; 
	}
	//////////////
	// NO ZEROS //
	//////////////
	private static int noZeros(int iInt, int eInt, int len) { //deals with int when there are no zeros
		eInt = iInt;
		iInt = findAndReplace(eInt);
		return iInt;
	}
	private static int findAndReplace(int eInt) { //find the largest num and replaces it with the new one
		// Search for currentLargest in eInt and replace it with editedLargest.
		// int tInt = 0; //use a temp int to manipulate then set it equal to eInt once you have the final edited value
		int len = (int)(Math.log10(eInt)+1);
		int l = findL(eInt);  // finds max
		int n = 0;
		boolean type = evenOrOdd(l); // true = even / false = odd  //finds type of L
		if (type == true) {
			n = l - 2; // subtracts 2 from even #
		}
		if (type == false) {
			n = l - 1; // subtracts 1 from odd #
		}
		List<Integer> number = new ArrayList<Integer>();
		int z = 0;
		int x = 10;
		int y = 1; 
		int tlen = 0;
		for (int i = 0; i < len; i++) { // #s into list
			z = (eInt % x) / y;
			x *= 10;
			y *= 10;
			number.add(z);
		}
		l = number.indexOf(l); // where L is
		number.set(l,n); // replace
		tlen = number.size(); // new size of list
		eInt = 0; // reset edited int
		int p = 1;
		for (int i = 0; i < tlen;i++) { // take #s out of list
			int k = number.get(i); //assign k to # at index i
			eInt = eInt + (k * p); // put is right digits spot according to size
			p *= 10;
		}
		
		return eInt;
	}
	private static boolean evenOrOdd(int l) {
		if (l%2 == 0 ) {
			return true;
		} else {
			return false;
		}
	}
	private static int findL(int eInt) {
		int largest=0; 
		while( eInt > 0 ) { 
			int digit = eInt % 10; 
			eInt = eInt / 10; 
			if (digit > largest) largest = digit; 
		}
		return largest;
	}

}