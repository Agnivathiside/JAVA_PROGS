import java.util.ArrayList;
public class detect_cycle_shit {
  public static boolean checkForCycle(int start, int V, ArrayList < ArrayList < Integer >> edges, boolean visited[], boolean dfsVis[]){
    visited[start] = true;
    dfsVis[start] = true;

    for(int i: edges.get(start)){
      if (visited[i]==false){
        if (checkForCycle(i, V, edges, visited, dfsVis)) return true;
      }else if (dfsVis[i]==true){
        return true;
      }
    }
    dfsVis[start] = false;
    return false;
  }
  public static boolean detectCycleInDirectedGraph(int n, ArrayList < ArrayList < Integer >> edges) {
    // Write your code here.
    boolean visited[] = new boolean[n];
    boolean dfsVis[] = new boolean[n];

    for(int i=0; i<n; i++){
      visited[i] = false;
      dfsVis[i] = false;
    }

    for(int i=0; i<n; i++){
      if (visited[i]==false){
        if (checkForCycle(i, n, edges, visited, dfsVis)) return true;
      }
    }
    return false;
  }
}