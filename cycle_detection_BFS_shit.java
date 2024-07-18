
//{ Driver Code Starts
import java.util.*;
import java.util.LinkedList;
import java.lang.*;
import java.io.*;

public class cycle_detection_BFS_shit{
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

// class Solution {
// // Function to detect cycle in an undirected graph.
// public static boolean isCyclicBFS(int src, boolean[] visited,
// ArrayList<ArrayList<Integer>> adj) {
// Map<Integer, Integer> parent = new HashMap<>();
// parent.put(src, -1);
// visited[src] = true;
// Queue<Integer> q = new ArrayDeque<>();
// q.add(src);

// while (!q.isEmpty()) {
// int front = q.peek();
// q.poll();

// for (int neighbor : adj.get(front)) {
// if (visited[neighbor] == true && parent.get(front) != neighbor) {
// return false;
// } else if (visited[neighbor] == false) {
// q.add(neighbor);
// visited[neighbor] = true;
// parent.put(neighbor, front);
// }
// }
// }
// return false;
// }
// // public static boolean isCyclicBFSmine(int src,int parent, boolean[]
// visited ,
// // ArrayList<ArrayList<Integer>> adj){
// // // Map<Integer, Integer> parent=new HashMap<>();
// // // parent.put(src, -1);
// // visited[src]=true;
// // Queue<Integer> q=new ArrayDeque<>();
// // q.add(src);

// // while (!q.isEmpty()){
// // int front=q.peek();
// // q.poll();

// // for (int neighbor:adj.get(front)){
// // if (visited[neighbor]==true && parent.get(front)!=neighbor){
// // return false;
// // }else if(visited[neighbor]==false){
// // q.add(neighbor);
// // visited[neighbor]=true;
// // parent.put(neighbor, front);
// // }
// // }
// // }
// // return false;
// // }
// public static boolean isCyclicDFS(int node, int parent, boolean[] visited,
// ArrayList<ArrayList<Integer>> adj) {
// visited[node] = true;

// for (int neighbor : adj.get(node)) {
// if (!visited[neighbor]) {
// boolean ans = isCyclicDFS(neighbor, node, visited, adj);
// if (ans == true)
// return true;
// } else if (neighbor != parent)
// return true;
// }
// return false;
// }

// public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
// // Code here
// boolean[] visited = new boolean[V];
// // for (int i=0;i<V;i++){
// // if (visited[i]==false){
// // boolean ans=isCyclicBFS(i, visited, adj);
// // if (ans==true) return true;
// // }
// // }
// // return false;
// for (int i = 0; i < V; i++) {
// if (visited[i] == false) {
// boolean ans = isCyclicDFS(i, -1, visited, adj);
// if (ans == true)
// return true;
// }
// }
// return false;
// // for (int i=0;i<V;i++){
// // if (visited[i]==false){
// // boolean ans=isCyclicBFSmine(i,-1, visited, adj);
// // if (ans==true) return true;
// // }
// // }
// // return false;
// }
// }
class Solution {
    public void makeAdjList(ArrayList<ArrayList<Integer>> adj, HashMap<Integer, ArrayList<Integer>> adj_lis) {
        for (int i = 0; i < adj.size(); i++) {
            adj_lis.put(i, adj.get(i));
        }
    }

    public boolean checkCycleDFS(int node, int parent, HashMap<Integer, Boolean> visited, HashMap<Integer, ArrayList<Integer>> adj_lis){
        visited.put(node, true);

        for(int neighbor:adj_lis.get(node)){
            if (!visited.get(neighbor)){
                boolean ans = checkCycleDFS(neighbor, node, visited, adj_lis);
                if (ans) return true;
            }else if(neighbor!=parent){
                return true;
            }
        }
        return false;
    }

    public boolean checkCycleBFS(HashMap<Integer, ArrayList<Integer>> adj_lis, HashMap<Integer, Boolean> visited, int node) {
        HashMap<Integer, Integer> parent = new HashMap<>();
        parent.put(node, -1);
        visited.put(node, true);
        Queue<Integer> q = new LinkedList<>();
        q.add(node);

        while (!q.isEmpty()) {
            int frontNode = q.poll();
            System.out.println("Front Node is "+frontNode);
            for (int i = 0; i < adj_lis.get(frontNode).size(); i++) {
                if (visited.get(adj_lis.get(frontNode).get(i)) && parent.get(frontNode) != adj_lis.get(frontNode).get(i)) {
                    System.out.println("here the current node is "+adj_lis.get(frontNode).get(i)+" and parent is "+ parent.get(frontNode));
                    return true;
                } else if (!visited.get(adj_lis.get(frontNode).get(i))){
                    q.add(adj_lis.get(frontNode).get(i));
                    visited.put(adj_lis.get(frontNode).get(i), true);
                    parent.put(adj_lis.get(frontNode).get(i), frontNode);
                    System.out.println("parent set for "+adj_lis.get(frontNode).get(i)+ " as "+ frontNode);
                }
            }
        }
        System.out.println(parent);
        return false;
    }

    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        HashMap<Integer, ArrayList<Integer>> adj_lis = new HashMap<>();
        HashMap<Integer, Boolean> visited = new HashMap<>();

        makeAdjList(adj, adj_lis);
        // System.out.println(adj_lis);
        for (int i = 0; i < V; i++) {
            visited.put(i, false);
        }
        boolean ans = false;
        for (int i = 0; i < V; i++) {
            if (!visited.get(i)) {
                ans = checkCycleDFS(i, -1, visited, adj_lis);
            }
        }
        return ans;
    }
}
