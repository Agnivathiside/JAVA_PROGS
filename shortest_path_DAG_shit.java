// public class shortest_path_DAG_shit

//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

public class shortest_path_DAG_shit{
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] edge = new int[m][3];
            for (int i = 0; i < m; i++) {
                edge[i][0] = sc.nextInt();
                edge[i][1] = sc.nextInt();
                edge[i][2] = sc.nextInt();
            }
            Solution obj = new Solution();
            int res[] = obj.shortestPath(n, m, edge);
            for (int i = 0; i < n; i++) {
                System.out.print(res[i] + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends

// User function Template for Java
class pair{
    int first;
    int secind;

    pair(int first, int second){
        this.first = first;
        this.secind = second;
    }
}
class Solution {
    public void dfs(int node, int vis[], Stack<Integer> st, ArrayList<ArrayList<pair>> arl){
        vis[node] = 1;
        for(int i=0; i<arl.get(node).size(); i++){
            int v = arl.get(node).get(i).first;
            if (vis[v]==0){
                dfs(v, vis, st, arl);
            }
        }
        st.add(node);
    }

    public int[] shortestPath(int N, int M, int[][] edges) {
        // Code here
        ArrayList<ArrayList<pair>> arl = new ArrayList<>();
        for(int i=0; i<N; i++){
            ArrayList<pair> temp = new ArrayList<>();
            arl.add(temp);
        }

        for(int i=0; i<M; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            arl.get(u).add(new pair(v, wt));
        }

        int vis[] = new int[N];
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<N; i++){
            if (vis[i]==0){
                dfs(i, vis, st, arl);
            }
        }

        int dist[] = new int[N];
        for(int i=0; i<N; i++){
            dist[i] = (int) (1e9);
        }
        dist[0] = 0;
        while(!st.isEmpty()){
            int node = st.peek();
            st.pop();

            for(int i=0; i<arl.get(node).size(); i++){
                int v = arl.get(node).get(i).first;
                int wt = arl.get(node).get(i).secind;
                if (dist[node]+wt<dist[v]){
                    dist[v] = wt + dist[node];
                }
            }
        }
        return dist;
    }
}