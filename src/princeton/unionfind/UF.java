/**
 * @author hoavu
 *
 */
package princeton.unionfind;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class UF {
	private int[] id;    // parent link
	private int[] sz; 	 // size of root's components
    private int count;   // number of components

    public UF(int N) {
    	count = N;
    	id = new int[N];
    	for (int i=0; i <N; i++) id[i] = i;
    	sz = new int[N];
    	for (int i=0; i <N; i++) sz[i] = 1;
    }
    
    public int count() {
    	return count;
    }
    
    public boolean connected(int p, int q) {
    	return find(p) == find(q);
    }
    
    public int find(int p) {
    	// follow links to find a root
    	while (p != id[p]) p = id[p];
    	return p;
    }
    
    public void union(int p, int q) {
    	// give p and q the same root
    	int pRoot = find(p);
    	int qRoot = find(q);
    	
    	if (pRoot == qRoot) return;
    	
    	// make smaller root point to larger one
    	if (sz[pRoot] < sz[qRoot]) {
    		id[pRoot] = qRoot;
    		sz[qRoot] += sz[pRoot];
    	} else {
    		id[qRoot] = pRoot;
    		sz[pRoot] += sz[qRoot];
    	}
    	
    	count --;
    }
    
    public static void main(String[] args) {
    	try {
    		FileReader file = new FileReader("tinyUF.txt");
    		System.out.println(file);
    		BufferedReader buff = new BufferedReader(file);
    		String line = buff.readLine();
    		int N = Integer.parseInt(line);
    		
    		QuickFindUF uf = new QuickFindUF(N);
    		boolean eof = false;
    		
    		while(!eof) {
    			line = buff.readLine();
    			if (line == null) {
    				eof = true;
    			} else {
    				int p = Integer.parseInt(line.split(" ")[0]);
    				int q = Integer.parseInt(line.split(" ")[1]);
    				if (uf.connected(p, q)) continue;
    				uf.union(p, q);
    				System.out.println(p + " is connected to " + q);
    			}
    		}
    		if (uf.connected(4, 1)) {
    			System.out.println("4 is connectd to 1");
    		} else {
    			System.out.println("4 is not connectd to 1");
    		}
    		System.out.println(uf.count() + " components");
    		buff.close();
    	} catch (IOException e) {
    		System.out.println("Error reading file");
    	}
    }
}
