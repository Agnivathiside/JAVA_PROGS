//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class prerequisite_task_shit {
	public static void main(String args[]) throws IOException
	{
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
		while(t>0)
		{
		    int N = sc.nextInt();
		    int P = sc.nextInt();
		    int prerequisites[][] = new int[P][2];
		    for(int i=0;i<P;i++)
		    {
		        for(int j=0;j<2;j++)
		        {
		            prerequisites[i][j] = sc.nextInt();
		        }
		    }
			Solution ob = new Solution();
			if(ob.isPossible(N,P,prerequisites))
			{
			    System.out.println("Yes");
			}
			else{
			    System.out.println("No");
			}
			t--;
		}
	}
	
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public static void createAdjList(int[][] prerequisites,HashMap<Integer, ArrayList<Integer>> map){
        for (int i=0;i<prerequisites.length;i++){
            // map.put(prerequisites[i][0], prerequisites[i][1]);
            ArrayList<Integer> arl= new ArrayList<>();
            for (int j=1;j<prerequisites[i].length;j++){
                arl.add(prerequisites[i][j]);
            }
            map.put(prerequisites[i][0], arl);
        }
    }
    public boolean isPossible(int N,int P, int[][] prerequisites)
    {
        // Create adj list first
        // check for cycle present in directed graph
        // if present then false, else true
        HashMap<Integer, ArrayList<Integer>> map= new HashMap<>();
        createAdjList(prerequisites, map);
        System.out.println(map);
    }
    
}