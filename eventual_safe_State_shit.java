// public class eventual_safe_State_shit

//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.util.LinkedList;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

public class eventual_safe_State_shit {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();

            List<List<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();

                adj.get(u).add(v);
            }

            Solution obj = new Solution();
            List<Integer> safeNodes = obj.eventualSafeNodes(V, adj);
            for (int i : safeNodes) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends

// User function Template for Java

class Solution {

    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {

        // Your code here
        List<List<Integer>> adjRev = new ArrayList<>();
        int indegree[] = new int[V];

        for(int i=0; i<V; i++){
            adjRev.add(new ArrayList<>());
        }

        for(int i=0; i<V; i++){
            for(int it:adj.get(i)){
                adjRev.get(it).add(i);
                indegree[i]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        List<Integer> safes = new ArrayList<>();

        for(int i=0; i<V; i++){
            if (indegree[i]==0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();
            safes.add(node);

            for(int it: adjRev.get(node)){
                indegree[it]--;
                if (indegree[it]==0){
                    q.add(it);
                }
            }
        }

        Collections.sort(safes);
        return safes;

    }
}
