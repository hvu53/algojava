/**
 * @author hoavu
 *
 */
package main;
public class RemoveDuplicates {
	public static int removeDuplicates(int[] nums) {
		int length = nums.length;
		if(length <2) return length;
		
		int i = 0;
		for(int j =1; j<length; j++) {
			if (nums[j] != nums[i]) {
				i++;
				nums[i] = nums[j];
			}
		}
		return i+1;
	}
	public static void main(String[] args) {
		int[] a = {1,1,2};
		System.out.println(removeDuplicates(a));
	}
}

