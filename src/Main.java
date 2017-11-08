import java.util.*;
import java.lang.*;
public class Main {
	private static Scanner in;
	public static void main(String[] args) {
		int iInt = 0;
		int moveCount = 1;
		int eInt = 0;
		int len = 0;
		iInt = getInt(iInt);
		if (iInt < 0) {
			iInt *= -1;
		}
		while (iInt != 0) {
			len = (int)(Math.log10(iInt));
			boolean choice = checkForZeros(iInt, len);
			if (choice == true) {
				iInt = isZeros(iInt, eInt,len);
				System.out.println(iInt);
				if (iInt > 0) {moveCount +=1;}
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
	public static int getInt(int iInt) {
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
		for (int i = 0; i < len; i++) {
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
	private static int isZeros(int iInt, int eInt, int len) {
		eInt = iInt;
		iInt = findAndRemove(iInt, eInt, len);
		return iInt;
	}
	private static int findAndRemove(int iInt, int eInt, int len) {
		List<Integer> number = new ArrayList<Integer>();
		int x = 10;
		int y = 1;
		int z = 0;
		int zero = 0;
		int tlen = 0;
		for (int i = 0; i < len; i++) {
			z = (iInt % x) / y;
			x *= 10;
			y *= 10;
			number.add(z);
		}
		zero = number.indexOf(0);
		for (int i = zero; i < len;i++) {
				number.remove(zero);
			}
		if (zero == 0)
			number.removeAll(number);
		tlen = number.size();
		int p = 1;
		eInt = 0;
		if (zero > 0) {
			for (int i = 0; i < tlen;i++) {
				int k = number.get(i);
				eInt = eInt + (k * p);
				p *= 10;
			}
		} else {
			eInt = 0;
		}
		
		return eInt;
	}
	//////////////
	// NO ZEROS //
	//////////////
	private static int noZeros(int iInt, int eInt, int len) {
		eInt = iInt;
		iInt = findAndReplace(eInt);
		return iInt;
	}
	private static int findAndReplace(int eInt) {
		// Search for currentLargest in eInt and replace it with editedLargest.
		// int tInt = 0; //use a temp int to manipulate then set it equal to eInt once you have the final edited value
		int len = (int)(Math.log10(eInt)+1);
		int l = findL(eInt);
		int n = 0;
		boolean type = evenOrOdd(l); // true = even / false = odd
		if (type == true) {
			n = l - 2;
		}
		if (type == false) {
			n = l - 1;
		}
		List<Integer> number = new ArrayList<Integer>();
		int z = 0;
		int x = 10;
		int y = 1; 
		int tlen = 0;
		for (int i = 0; i < len; i++) {
			z = (eInt % x) / y;
			x *= 10;
			y *= 10;
			number.add(z);
		}
		l = number.indexOf(l);
		number.set(l,n);
		tlen = number.size();
		eInt = 0;
		int p = 1;
		for (int i = 0; i < tlen;i++) {
			int k = number.get(i);
			eInt = eInt + (k * p);
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
