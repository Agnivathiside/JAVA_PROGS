//{ Driver Code Starts
import java.io.*;
import java.util.*;

class count_provinces_shit {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int V = Integer.parseInt(read.readLine());
            
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            for(int i=0; i<V; i++)
            {
                String S[] = read.readLine().split(" ");
                ArrayList<Integer> temp = new ArrayList<>();
                for(int j=0; j<V; j++)
                    temp.add(Integer.parseInt(S[j]));
                adj.add(temp);
            }

            Solution ob = new Solution();
            System.out.println(ob.numProvinces(adj,V));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public static boolean isCyclicDFS(int node, int parent, boolean[] visited , ArrayList<ArrayList<Integer>> adj){
            visited[node]=true;

            for (int neighbor:adj.get(node)){
                if (!visited[neighbor]){
                    boolean ans=isCyclicDFS(neighbor, node, visited, adj);
                    if (ans==true) return true;
                }else if(neighbor!=parent) return true;
            }
            return false;
    }
    public static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here
        boolean[] visited = new boolean[V];
        int count=1;
        
        for (int i=1;i<=V;i++){
            if (visited[i]==false){
                count++;
                System.out.println("now node is: "+i);
                boolean ans=isCyclicDFS(i,-1, visited, adj);
                // if (ans==true) return true;
            }
        }
        return count;
    }
};