/**
 * @author hoavu
 *
 */
package princeton.unionfind;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class QuickFindUF {
    private int[] id;    // id[i] = component identifier of i
    private int count;   // number of components

    public QuickFindUF(int N) {
    	count = N;
    	id = new int[N];
    	for (int i=0; i <N; i++) {
    		id[i] = i;
    	}
    }
    
    public int count() {
    	return count;
    }
    
    public boolean connected(int p, int q) {
    	return find(p) == find(q);
    }
    
    public int find(int p) {
    	return id[p];
    }
    
    public void union(int p, int q) {
    	int pID = find(p);
    	int qID = find(q);
    	
    	if (pID == qID) return;
    	
    	// rename p's component to q's name
    	for (int i=0; i <id.length; i++) {
    		if (id[i] == pID) id[i] = qID;
    	}
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