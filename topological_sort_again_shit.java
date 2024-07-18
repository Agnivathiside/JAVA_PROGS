// public class topological_sort_again_shit

//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

public class topological_sort_again_shit {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            String st[] = read.readLine().trim().split("\\s+");
            int edg = Integer.parseInt(st[0]);
            int nov = Integer.parseInt(st[1]);

            for (int i = 0; i < nov; i++)
                list.add(i, new ArrayList<Integer>());

            int p = 0;
            for (int i = 1; i <= edg; i++) {
                String s[] = read.readLine().trim().split("\\s+");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                list.get(u).add(v);
            }

            int[] res = new Solution().topoSort(nov, list);

            if (check(list, nov, res) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }

    static boolean check(ArrayList<ArrayList<Integer>> list, int V, int[] res) {

        if (V != res.length)
            return false;

        int[] map = new int[V];
        for (int i = 0; i < V; i++) {
            map[res[i]] = i;
        }
        for (int i = 0; i < V; i++) {
            for (int v : list.get(i)) {
                if (map[i] > map[v])
                    return false;
            }
        }
        return true;
    }
}

// } Driver Code Ends

/* Complete the function below */

class Solution {
    public static void makeAdjList(ArrayList<ArrayList<Integer>> adj, 
                    HashMap<Integer, ArrayList<Integer>> adj_lis){
        for(int i=0; i<adj.size(); i++){
            adj_lis.put(i, adj.get(i));
        }
    }

    private static void topoLogicalSort(HashMap<Integer, ArrayList<Integer>> adj_lis,
            HashMap<Integer, Boolean> visited, Stack<Integer> st, int node) {
        visited.put(node, true);

        for(int neighbor:adj_lis.get(node)){
            if(!visited.get(neighbor)){
                
                topoLogicalSort(adj_lis, visited, st, neighbor);
            }
        }
        System.out.println("Adding "+node+" to the stack");
        st.add(node);
    }
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        // add your code here
        HashMap<Integer, ArrayList<Integer>> adj_lis= new HashMap<>();
        HashMap<Integer, Boolean> visited = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        // Stack<Integer> st2 = topoLogicalSort(adj_lis, visited, st, 0);

        makeAdjList(adj, adj_lis);

        for(int i=0; i<V; i++){
            visited.put(i, false);
        }

        for(int i=0; i<V; i++){
            if (!visited.get(i)){
                System.out.println("calling the function");
                topoLogicalSort(adj_lis, visited, st, i);
            }
        }
        System.out.println("Stack is "+st);
        int[] ans = new int[V];
        int i=0;
        while(!st.empty()){
            ans[i]=st.pop();
            i++;
        }
        return ans;
    }
    
}
