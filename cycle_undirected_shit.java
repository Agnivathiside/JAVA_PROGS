// public class cycle_undirected_shit

//{ Driver Code Starts
import java.util.*;
import java.util.LinkedList;
import java.lang.*;
import java.io.*;

public class cycle_undirected_shit {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends

class Solution {
    public void makeAdjList(ArrayList<ArrayList<Integer>> adj, HashMap<Integer, ArrayList<Integer>> adj_lis){
        for (int i=0;i<adj.size();i++){
            adj_lis.put(i, adj.get(i));
        }
    }
    public boolean isPresent(HashMap<Integer, ArrayList<Integer>> adj_lis, HashMap<Integer, Boolean> visited, int node){
        HashMap<Integer, Integer> parent=new HashMap<>();

        parent.put(node, -1);
        visited.put(node, true);
        Queue<Integer> q = new LinkedList<>();

        q.add(node);

        while (!q.isEmpty()){
            int frontNode=q.poll();

            for (int i=0;i<adj_lis.get(frontNode).size(); i++){
                if (visited.get(adj_lis.get(frontNode).get(i))==true && adj_lis.get(frontNode).get(i)!=parent.get(frontNode)){
                    return true;
                }else if (!visited.get(adj_lis.get(frontNode).get(i))){
                    q.add(adj_lis.get(frontNode).get(i));
                    visited.put(adj_lis.get(frontNode).get(i), true);
                    parent.put(adj_lis.get(frontNode).get(i), frontNode);
                }
            }
        }
        return false;
    }
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        HashMap<Integer, ArrayList<Integer>> adj_lis = new HashMap<>();
        HashMap<Integer, Boolean> visited = new HashMap<>();

        makeAdjList(adj, adj_lis);
        for (int i = 0;i<V;i++){
            visited.put(i, false);
        }

        for (int i=0;i<V;i++){
            if (!visited.get(i)){
                boolean ans= isPresent(adj_lis, visited, i);
                if (ans) return true;
            }
        }
        return false;
             
    }
}
