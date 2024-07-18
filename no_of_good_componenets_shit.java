// public class no_of_good_componenets_shit

//{ Driver Code Starts
import java.io.*;
import java.util.LinkedList;
import java.util.*;

class IntMatrix {
    public static int[][] input(BufferedReader br, int n, int m) throws IOException {
        int[][] mat = new int[n][];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for (int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }

        return mat;
    }

    public static void print(int[][] m) {
        for (var a : m) {
            for (int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }

    public static void print(ArrayList<ArrayList<Integer>> m) {
        for (var a : m) {
            for (int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
}

public class no_of_good_componenets_shit {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int e;
            e = Integer.parseInt(br.readLine());

            int v;
            v = Integer.parseInt(br.readLine());

            int[][] edges = IntMatrix.input(br, e, 2);

            Solution obj = new Solution();
            int res = obj.findNumberOfGoodComponent(e, v, edges);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends

class Solution {
    public static boolean bfs(int node, boolean visited[], int edges[][]) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        visited[node] = true;
        int nodes = 0;
        int e = edges[node].length;
        boolean flag = true;
        while (!q.isEmpty()){
            int curr = q.poll();
            if (edges[curr].length!=e) flag = false;
            nodes++;
            for (int i:edges[curr]){
                if (visited[i]) continue;
                visited[i] = true;
                q.offer(i);
            }
        }
        return flag && e+1==nodes;
    }

    public static int findNumberOfGoodComponent(int e, int v, int[][] edges) {
        // code here
        boolean visited[] = new boolean[v+1];
        int count = 0;

        for (int i = 1; i <= v; i++) {
            if (!visited[i]) {
                if (bfs(i, visited, edges))
                    count++;
            }
        }
        return count;
    }
}
