// public class M_partile_graph_shit

//{ Driver Code Starts
import java.util.*;
import java.util.LinkedList;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int tc = scan.nextInt();

        while (tc-- > 0) {
            int N = scan.nextInt();
            int M = scan.nextInt();
            int E = scan.nextInt();

            boolean graph[][] = new boolean[N][N];

            for (int i = 0; i < E; i++) {
                int u = scan.nextInt() - 1;
                int v = scan.nextInt() - 1;
                graph[u][v] = true;
                graph[v][u] = true;
            }

            System.out.println(new solve().graphColoring(graph, M, N) ? 1 : 0);
        }
    }
}

// } Driver Code Ends
// I DON'T UNDERSTAND THIS PROBLEM, HOW THE FUCK IS BOOLEAN GRAPH????
class solve {
    // Function to determine if graph can be coloured with at most M colours
    // such
    // that no two adjacent vertices of graph are coloured with same colour.
    private boolean issafe(boolean graph[][], int v, int[] colors, int c, int n) {
          for(int i=0;i<n;i++){
              if(graph[v][i]&& c==colors[i]){
                  return false;
              }
          }   
        
        
        return true;
    }
    public boolean graphColoring(boolean graph[][], int m, int n) {
        // Your code here
        int colors[] = new int[n]; // to store colors assigned to all vertices
        for(int i=0;i<n;i++){
            colors[i]=0;
            
        } // all zero means no color assigned
        // start coloring from the first vertex 
        if(solve(graph,m,colors,0,n)){
            
            return true;
        }else{
            return false;
        }
    }
    public boolean solve(boolean graph[][] , int m ,int colors[] , int v,int n){
        if(v==n){
            return true ; // all vertex coloured 
        }
        for(int c=1;c<=m;c++){
            if(issafe(graph,v,colors,c,n)){
                 // if color no assisned 
                 colors[v]=c;
                  if(solve(graph,m,colors,v+1,n)){
                      return true;
                  }
                 // if not true then backtrack 
                 colors[v]=0;
                
            }
            
            
        }
        
        return false;
        
    }
}