// public class bfs_loop_shit

//{ Driver Code Starts
// Initial Template for Java
import java.util.*;
import java.util.LinkedList;
import java.lang.*;
import java.io.*;
public class bfs_loop_shit {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                // adj.get(v).add(u);
            }
            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.bfsOfGraph(V, adj);
            for (int i = 0; i < ans.size(); i++)
                System.out.print(ans.get(i) + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


// class Solution {
//     public void makeAdjList(ArrayList<ArrayList<Integer>> adj,HashMap<Integer, ArrayList<Integer>> adj_lis){
//         for (int i=0;i<adj.size(); i++){
//             adj_lis.put(i, adj.get(i));
//         }
//     }
//     public ArrayList<Integer> bfs(HashMap<Integer, ArrayList<Integer>> adj_lis,HashMap<Integer, Boolean> visited,ArrayList<Integer> ans, int node){
//         Queue<Integer> q= new LinkedList<>();
//         q.add(node);
//         visited.put(node, true);
        
//         while (!q.isEmpty()){
//             // System.out.println("Current Queue is "+q);
//             int frontNode = q.poll();
//             // System.out.println("Queue after polling "+frontNode+" is "+q);

//             // System.out.println("Node is "+frontNode);
//             ans.add(frontNode);

//             for (int i=0; i<adj_lis.get(frontNode).size();i++){
//                 if (!visited.get(adj_lis.get(frontNode).get(i))){

//                     // System.out.println("Adding "+adj_lis.get(frontNode).get(i)+" to Queue");
//                     q.add(adj_lis.get(frontNode).get(i));
//                     visited.put(adj_lis.get(frontNode).get(i), true);

//                 }
//             }
//         }
//         return ans;
//     }
//     public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
//         // Code here
//         ArrayList<Integer> ans = new ArrayList<>();
//         HashMap<Integer, Boolean> visited=new HashMap<>();
//         HashMap<Integer, ArrayList<Integer>> adj_lis=new HashMap<>();

//         makeAdjList(adj, adj_lis);
//         // System.out.println("map is "+adj_lis);
//         for (int i=0;i<V; i++){
//             visited.put(i, false);
//         }

//         // for (int i=0; i<V; i++){
//         //     if (!visited.get(i)){
//         //         System.out.println("It's coming back here");
//         //         return bfs(adj_lis, visited, ans, i);
//         //     }
//         // }
//         return bfs(adj_lis, visited, ans, 0);
//         // System.out.println("answer array is "+ans);
//         // return ans;
//     }
// }

class Solution {
    // Function to create adjacency list
    public static void makeAdjList(HashMap<Integer, ArrayList<Integer>> adj_lis, ArrayList<ArrayList<Integer>> adj){
        for (int i = 0; i < adj.size(); i++){
            adj_lis.put(i, adj.get(i));
        }
    }

    // Recursive function to perform BFS traversal
    public static void bfsRecursive(HashMap<Integer, ArrayList<Integer>> adj_lis, HashMap<Integer, Boolean> visited, Queue<Integer> queue, ArrayList<Integer> ans){
        if (queue.isEmpty()) // Base case: if the queue is empty, traversal is complete
            return;

        int currentNode = queue.poll(); // Dequeue the current node
        ans.add(currentNode); // Add current node to the result list

        // Explore neighbors of the current node
        for (int neighbor : adj_lis.get(currentNode)) {
            if (!visited.get(neighbor)) {
                visited.put(neighbor, true);
                queue.offer(neighbor); // Enqueue unvisited neighbors
            }
        }

        bfsRecursive(adj_lis, visited, queue, ans); // Recursive call to explore next level
    }

    // Function to perform BFS traversal of the graph
    public static ArrayList<Integer> bfsOfGraph(int n, ArrayList<ArrayList<Integer>> adj){
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Integer, Boolean> visited = new HashMap<>();
        HashMap<Integer, ArrayList<Integer>> adj_lis = new HashMap<>();

        makeAdjList(adj_lis, adj);
        
        System.out.println(adj_lis);
        // Initialize visited map
        for (int i = 0; i < n; i++){
            visited.put(i, false);
        }

        // Perform BFS traversal for each unvisited node
        for (int i = 0; i < n; i++){
            if (!visited.get(i)){
                System.out.println("It's coming back here and the node is "+i);
                for (int j=0;j<adj_lis.get(i).size();j++){
                    if (!visited.get(adj_lis.get(i).get(j))){
                        visited.put(i, true); // Mark the starting node as visited
                        Queue<Integer> queue = new LinkedList<>();
                        queue.offer(i); // Enqueue the starting node
                        bfsRecursive(adj_lis, visited, queue, ans); // Start BFS from the current node
                    }
                }
                // visited.put(i, true); // Mark the starting node as visited
                // Queue<Integer> queue = new LinkedList<>();
                // queue.offer(i); // Enqueue the starting node
                // bfsRecursive(adj_lis, visited, queue, ans); // Start BFS from the current node
            }
        }

        return ans;
    }
}