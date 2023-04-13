// Java program for the above approach

import java.util.*;

public class FlamesGame {

	// Function to find out the flames result
	public static void flame(char[] a, char[] b) {
		int l = 1, sc = 0, rc = 0, fc = 5;
		String f = "flames";
		char[] flames = f.toCharArray();
		String q = new String(a);
		String w = new String(b);

		int n = a.length;
		int m = b.length;
		int tc = n + m;

		for (int i = 0; i < n; i++) {
			char c = a[i];
			for (int j = 0; j < m; j++) {
				if (c == b[j]) {
					a[i] = b[j] = '-'; // mark the matched characters with '-'
					sc += 2;
					break;
				}
			}
		}

		rc = tc - sc;
		int i = 0;

		while (i >= 0) {
			if (l == rc) {
				for (int k = i; k < f.length()-1; k++) {
					flames[k] = flames[k + 1];
				}
				flames[flames.length-1] = '0';
				fc--;
				i--;
				l = 0;
			}
			if (i == fc) {
				i = -1;
			}
			if (fc == 0) {
				break;
			}
			l++;
			i++;
		}

		// Print the results
		char result = flames[0];
		switch (result) {
			case 'e':
				System.out.println(q + " is ENEMY to " + w);
				break;
			case 'f':
				System.out.println(q + " is FRIEND to " + w);
				break;
			case 'm':
				System.out.println(q + " is going to MARRY " + w);
				break;
			case 'l':
				System.out.println(q + " is in LOVE with " + w);
				break;
			case 'a':
				System.out.println(q + " has more AFFECTION on " + w);
				break;
			default:
				System.out.println(q + " and " + w + " are SISTERS/BROTHERS ");
				break;
		}
	}

	// Driver code
	public static void main(String[] args) {
		String a = "AJAY";
		String b = "PRIYA";
		char[] charA = a.toCharArray();
		char[] charB = b.toCharArray();

		flame(charA, charB);
	}
}

// This code is contributed by codebraxnzt
