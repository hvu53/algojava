package cracking;

// determine if a string has all unique characters. Cannot use additional character

// Solution
// ASCII or Unicode
// optimization: automatically return false if string length > 128
public class uniqueChar {
	public boolean isUniqueChar(String s) {
		if (s.length() > 128 ) return false;
		boolean char_set[] = new boolean[256];
		
		for (int i=0; i<s.length(); i++) {
			int val = s.charAt(i);
			System.out.println(val);
			if (char_set[val]) {
				return false;
			}
			char_set[val] = true;
		}
		return true;
	}
	
	public boolean isUniqueChar2(String s) {
		int checker = 0;
		for (int i=0; i < s.length(); i++) {
			int val = s.charAt(i) - 'a';
			if ((checker & (1 << val)) > 0) {
				return false;
			}
			checker |= (1 << val);
		}
		return true;
	}
	
	public void main(String[] args) {
		String s = "hoavu";
		uniqueChar uniqueChar = new uniqueChar();
		System.out.println(uniqueChar.isUniqueChar(s));
		System.out.println(uniqueChar.isUniqueChar2(s));
	}
}
