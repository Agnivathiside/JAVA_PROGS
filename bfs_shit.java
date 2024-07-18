// public class bfs_shit {
    
// }
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
public class bfs_shit {
    public static void makeAdjList(HashMap<Integer, List<Integer>> adj_lis,List<List<Integer>> adj){
        for (int i=0;i<adj.size();i++){
            adj_lis.put(i, adj.get(i));
        }
    }
    public static void bfs(HashMap<Integer, List<Integer>> adj_lis,HashMap<Integer, Boolean> visited, List<Integer> ans,int node){
        // Queue<Integer> qu=new LinkedList<>();

        if(visited.get(node)) return;

        visited.put(node, true);
        ans.add(node);

        for(int i=0;i<adj_lis.get(node).size();i++){
            bfs(adj_lis, visited, ans, adj_lis.get(node).get(i));
        }
        
    }
    public static List<Integer> bfsTraversal(int n, List<List<Integer>> adj){
        // Write your code here
        List<Integer> ans=new ArrayList<>();
        HashMap<Integer, Boolean> visited=new HashMap<>();
        HashMap<Integer, List<Integer>> adj_lis=new HashMap<>();

        makeAdjList(adj_lis, adj);

        for(int i=0;i<n;i++){
            visited.put(i, false);
        }

        for(int i=0;i<n;i++){
            if(!visited.get(i)){
                bfs(adj_lis, visited, ans, i);
            }
        }
        return ans;

    }
}

