
package cracking;

/**
 * @author hoavu
 *
 */
public class stringPermutation {
	// method 1: sorting
	public String sort(String s) {
		char[] content = s.toCharArray();
		java.util.Arrays.sort(content);
		return new String(content);
	}
	
	public boolean permutation(String s, String t) {
		if (s.length() !=  t.length()) {
			return false;
		}
		return sort(s).equals(sort(t));
	}
	
	// method 2: character count
	public boolean permutation2(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		
		int[] letters = new int[256];
		
		for (int i=0; i<s.length(); i++) {
			int val = s.charAt(i);
			letters[val]++;
		}
		
		for (int j=0; j<t.length(); j++){
			int val2 = t.charAt(j);
			if (--letters[val2] < 0) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		stringPermutation res = new stringPermutation();
		System.out.println(res.permutation("dog", "god"));
		System.out.println(res.permutation2("dog", "god"));
	}
}
