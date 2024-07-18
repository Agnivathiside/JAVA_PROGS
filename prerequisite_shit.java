// public class prerequisite_shit

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class prerequisite_shit {
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
    public static ArrayList<ArrayList<Integer>> createAdjacencyList(int N, int[][] prerequisites) {
        // Initialize the adjacency list
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            adjList.add(new ArrayList<>());
        }
        
        // Populate the adjacency list with the given prerequisites
        for (int[] prerequisite : prerequisites) {
            int task = prerequisite[0];
            int preTask = prerequisite[1];
            adjList.get(preTask).add(task);
        }
        
        return adjList;
    }
    public boolean dfs(int node, int vis[], int dfsVis[], ArrayList<ArrayList<Integer>> arl){
        vis[node] = 1;
        dfsVis[node] = 1;

        for(int i:arl.get(node)){
            if (vis[i]==-1){
                if (dfs(i, vis, dfsVis, arl)) return true;
            }else if(dfsVis[i]==1){
                return true;
            }
        }
        dfsVis[node] = -1;
        return false;
    }
    public boolean isPossible(int N,int P, int[][] prerequisites)
    {
        // Your Code goes here
        ArrayList<ArrayList<Integer>> arl = createAdjacencyList(N, prerequisites);
        int vis[] = new int[N];
        int dfsVis[] = new int[N];
        for(int i=0; i<N; i++){
            vis[i] = -1;
            dfsVis[i] = -1;
        }

        for(int i=0; i<N; i++){
            if (vis[i]==-1){
                if (dfs(i, vis, dfsVis, arl)) return true;
            }
        }
        return false;

        
    }
    
}