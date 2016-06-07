/**
 * 
 */
package cracking;

import java.util.Arrays;

/**
 * @author hoavu
 *
 */
public class rotateImage {
	public static final int n = 5;
	public static void rotate(int[][] matrix, int N) {
		
		
		for(int layer=0; layer < N/2; layer++) {
			int first = layer;
			int last = N - layer -1;
			
			for (int cell= first; cell < last; cell++) {
				int offset = cell - first;
				// save top
				int top = matrix[first][cell];
				
				// bottom -> top
				matrix[first][cell] = matrix[last-offset][first];
				
				// right -> left
				matrix[last-offset][first] = matrix[last][last-offset];
				
				// top -> bottom
				matrix[last][last-offset] = matrix[cell][last];
				
				// left -> right
				matrix[cell][last] = top;
				

			}
		}
	}
	
	public static void rotate2(int[][] matrix, int N) {
		// int[][] res = new int[N][N];
		for (int i=0; i <N/2; i++) {
			for (int j =0; j <(N+1)/2; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[N-1-j][i];
				matrix[N-1-j][i] = matrix[N-1-i][N-1-j];
				matrix[N-1-i][N-1-j] = matrix[j][N-1-i];
				matrix[j][N-1-i] = temp;
			}
		}
		// res[j][N-i-1] = matrix[i][j];
	}
		
	public static void tranpose(int[][] matrix, int s) {
		if (s== n-1) return;
		
		for (int i = s; i<n; i++) {
			int temp = matrix[s][i];
			matrix[s][i] = matrix[i][s];
			matrix[i][s] = temp;
			
		}
		
		tranpose(matrix, s+1);
	}
	public static void main(String[] args) {
		int[][] matrix = new int[][] {
			{1,2,3,4,5},
			{6,7,8,9,10},
			{11,12,13,14,15},
			{16,17,18,19,20},
			{21,22,23,24,25}
		};
		tranpose(matrix,0);
		System.out.println(Arrays.deepToString(matrix));
	}
}
