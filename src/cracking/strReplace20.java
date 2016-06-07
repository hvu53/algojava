/**
 * 
 */
package cracking;

/**
 * @author hoavu
 *
 */
public class strReplace20 {
	public static void replaceSpace(char[] str, int length) {
		int spaceCount =0, newLength, i;
		for (i=0; i< length; i++) {
			if (str[i] == ' ') {
				spaceCount++;
			}
		}
		System.out.println(spaceCount);
		newLength = length + spaceCount *2;
//		str[newLength] = '\0';
		for (i = length-1; i>=0; i--) {
			if (str[i] == ' ') {
				str[newLength-1] = '0';
				str[newLength-2] = '2';
				str[newLength-3] = '%';
				newLength = newLength -3;
			} else {
				str[newLength - 1] = str[i];
				newLength -=1;
			}
		}
	}
	public static void main(String[] args) {
		String input = "Mr John Smith****";
		char[] str = input.toCharArray();
		replaceSpace(str, 13);
		System.out.println(str);
	}
}
