/**
 * @author hoavu
 *
 */

package leetcode;

public class reverseString {
	
	// using 2 pointers
	public String reverse(String s) {
		String[] charArray = s.split("");
		int count = s.length();
		int left = 0;
		int right = s.length()-1;
		while (left < right) {
			String temp = charArray[left];
			charArray[left] = charArray[right];
			charArray[right] = temp;
			left++;
			right--;
		}
		
		return String.join("",charArray);
	}
	
	// using StringBuilder
	public String reverse2(String s) {
		StringBuilder sb = new StringBuilder(s);
		return sb.reverse().toString();
	}
	public void main(String[] args) {
		reverseString rs = new reverseString();
		System.out.println(rs.reverse("hoavu"));
		System.out.println(rs.reverse2("hoavu"));
	}
}
