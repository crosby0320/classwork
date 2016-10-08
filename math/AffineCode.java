
public class AffineCode {
	public static void main(String[] args) {
		encrypt("thisiswhatiwantyoutoencrypt", 5, 9);
		decrypt("cjiseizczrcfpcuwxcvz", 5, 8);
	}

	/**
	 * This is the function that is used to encrypt any string that you would
	 * like
	 * 
	 * @param Line
	 *            String that you would like to use for the code
	 * @param a
	 *            int The alpha that you want to use for the code
	 * @param b
	 *            int The beta that you would like to use for the code
	 */
	public static void encrypt(String line, int a, int b) {
		char[] aray = line.toCharArray();
		for (int i = 0; i < aray.length; i++) {
			System.out.printf("%5c == %5d ", aray[i], charToNumber(aray[i]));
			System.out.printf(" == %5d == %5c \n",
					algo(a, b, charToNumber(aray[i])),
					intToCodeInt(algo(a, b, charToNumber(aray[i]))));
		}
	}

	/**
	 * This function allows the user to enter a string and the string will be
	 * decrypted using the affine function with the given alpha and beta that is
	 * enter
	 * 
	 * @param line
	 *            String that you would like to decrypt
	 * @param a
	 *            int Alpha that you would like to use
	 * @param b
	 *            int Beta that you would like to use
	 */
	public static void decrypt(String line, int a, int b) {
		char[] aray = line.toCharArray();
		for (int i = 0; i < aray.length; i++) {
			System.out.printf("%5c == %5d ", aray[i], charToNumber(aray[i]));
			System.out.printf(" == %5d == %5c \n",
					algo2(a, b, charToNumber(aray[i])),
					intToCodeInt(algo2(a, b, charToNumber(aray[i]))));
		}
	}

	/**
	 * Take in a character a-z and converts it to ints a = 0 and z = 25
	 * 
	 * @param a
	 *            character that you would like to get converted
	 * @return integer if the letter you have entered
	 */
	public static int charToNumber(char a) {
		return a - 97;
	}

	/**
	 * Takes an int and converts it to a char were 0 = a and 25 = z
	 * 
	 * @param a
	 *            number that you would like to be converted into a character
	 * @return character for the number
	 */
	public static char intToCodeInt(int a) {
		return (char) (a + 97);
	}

	/**
	 * affine algorithm that take in a alpha beta and c for the x or value
	 * entered into the affine function => return = mod((alpha)x + (beta), 26)
	 * 
	 * @param a
	 *            Alpha
	 * @param b
	 *            Beta
	 * @param c
	 *            variable input
	 * @return answer mod 26 for all characters in the alphabet
	 */
	public static int algo(int a, int b, int c) {
		return (a * c + b) % 26;
	}

	/**
	 * affine inverse/decryption function you must enter an Alpha Beta and
	 * variable were return = (alpha)^(-1)(x + beta)
	 * 
	 * @param a
	 *            Alpha
	 * @param b
	 *            Beta
	 * @param c
	 *            variable input
	 * @return returns the inverse of the affine function to decrypt
	 */
	public static int algo2(int a, int b, int c) {
		return (FindInverseMod(a) * (c - b + 26)) % 26;
	}

	/**
	 * finds the mod inverse of a number to the mod 26
	 * 
	 * @param a
	 *            the number you want to find the inverse for
	 * @return inverse mod 26 of a
	 */
	public static int FindInverseMod(int a) {
		for (int i = 0; i < 26; i++) {
			if ((i * a) % 26 == 1) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Prints the GCD using the Euclidian algorithm with every step were
	 * GCD(a,c)
	 * 
	 * @param a
	 * @param c
	 */
	public static void GCDEclid(int a, int c) {
		/*
		 * just used to make sure that user have the greatest value on the left
		 */
		if (a < c) {
			int temp = a;
			a = c;
			c = temp;
		}
		int d = 0, b = 0;

		do {
			b = a / c;
			d = a % c;
			System.out.printf("%10d = %10d * %10d + %10d\n", a, b, c, d);
			a = c;
			c = d;
		} while (d != 0);
	}

	/**
	 * The mathematical Division algorithm
	 * 
	 * @param a
	 * @param b
	 */
	public static void DivisionAlgo(double a, double b) {
		System.out.printf("Q = %-5d  Remainder = %-5d\n",
				(int) (Math.floor(a / b)), (int) (a - b * (Math.floor(a / b))));
	}
}