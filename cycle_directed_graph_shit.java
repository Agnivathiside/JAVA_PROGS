// public class cycle_directed_graph_shit

//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

public class cycle_directed_graph_shit{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends

/* Complete the function below */
/*
4 4
0 1
1 2
2 3
3 3
 */
class Solution {
    public void makeAdjList(ArrayList<ArrayList<Integer>> adj, HashMap<Integer, ArrayList<Integer>> adj_lis){
        for (int i=0; i<adj.size(); i++){
            adj_lis.put(i, adj.get(i));
        }
    }
    public boolean checkDirectedDFS(int node, HashMap<Integer, Boolean> visited, HashMap<Integer, Boolean> dfs_visited, HashMap<Integer, ArrayList<Integer>> adj_lis){
        visited.put(node, true);
        dfs_visited.put(node, true);

        for (int neighbor:adj_lis.get(node)){
            if (visited.get(neighbor) && dfs_visited.get(neighbor)){
                return true;
            }else if(!visited.get(neighbor)){
                boolean check = checkDirectedDFS(neighbor, visited, dfs_visited, adj_lis);
                if (check) return true;
            }
        }
        dfs_visited.put(node, false);
        return false;
    }
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        HashMap<Integer, ArrayList<Integer>> adj_lis = new HashMap<>();
        HashMap<Integer, Boolean> visited = new HashMap<>();
        HashMap<Integer, Boolean> dfs_visited = new HashMap<>();
        makeAdjList(adj, adj_lis);
        // System.out.println(adj_lis);

        for (int i=0; i<V; i++){
            visited.put(i, false);
            dfs_visited.put(i, false);
        }

        for (int i=0; i<V; i++){
            if (!visited.get(i)){
                boolean ans = checkDirectedDFS(i, visited, dfs_visited, adj_lis);
                if (ans) return true;
            }
        }
        return false;
    }
}