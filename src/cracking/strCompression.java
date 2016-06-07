/**
 * 
 */
package cracking;

/**
 * @author hoavu
 *
 */
public class strCompression {
	public String compressedBad(String str) {
		String mystr = "";
		char prev = str.charAt(0);
		int count = 1;
		for (int i=1; i < str.length(); i++) {
			if (str.charAt(i) == prev) {
				count++;
			} else {
				mystr += prev+""+count;
				prev = str.charAt(i);
				count =1;
			}
		}
		return mystr + prev + count;
	}
	
	// using String Buffer
	public String compressedBetter(String str) {
		int size = countCompression(str);
		if (size >= str.length()) {
			return str;
		}
		
		StringBuilder mystr = new StringBuilder();
		char prev = str.charAt(0);
		int count = 1;
		for (int i=1; i< str.length(); i++) {
			if (str.charAt(i) == prev) {
				count++;
			} else {
				mystr.append(prev);
				mystr.append(count);
				prev = str.charAt(i);
				count = 1;
			}
		}
		
		mystr.append(prev);
		mystr.append(count);
		return mystr.toString();
	}
	
	int countCompression(String str) {
		if (str == null || str.isEmpty()) return 0;
		char prev = str.charAt(0);
		int size = 0;
		int count = 1;
		
		for (int i=1; i < str.length(); i++) {
			if (str.charAt(i) == prev) {
				count++;
			} else {
				prev = str.charAt(i);
				size += 1 + String.valueOf(count).length();
				count =1;
			}
		}
		
		size +=  1 + String.valueOf(count).length();
		return size;
	}
	public String compressedAlternate(String str) {
		// check if compression would create a longer string
		int size = countCompression(str);
		if (size >= str.length()) {
			return str;
		}
		
		char[] array = new char[size];
		int index = 0;
		char prev = str.charAt(0);
		int count = 1;
		
		for (int i=1; i< str.length(); i++) {
			if (str.charAt(i) == prev) {
				count++;
			} else {
				index = setChar(array, prev, index, count);
				prev = str.charAt(i);
				count = 1;
			}
		}
		
		index = setChar(array, prev, index, count);
		return String.valueOf(array);
	}
	
	int setChar(char[] array, char c, int index, int count) {
		array[index] = c;
		index++;
		
		char[] cnt = String.valueOf(count).toCharArray();
		// copy characters from biggest digit to smallest
		for (char x : cnt) {
			array[index] = x;
			index++;
		}
		return index;
	}
	public static void main (String[] args) {
		strCompression s = new strCompression();
		System.out.println(s.compressedBad("aabbccdeeaa"));
		System.out.println(s.compressedBetter("aabbcceeaaaa"));
		System.out.println(s.compressedAlternate("aabbcceeaaaa"));
	}
}
