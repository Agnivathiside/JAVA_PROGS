// public class maximum_connected_component_shit

//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

public class maximum_connected_component_shit {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[][] grid = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution obj = new Solution();
            int ans = obj.MaxConnection(grid);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    // Direction vectors for moving up, down, left, right
    private int[] rowDirection = {-1, 1, 0, 0};
    private int[] colDirection = {0, 0, -1, 1};
    
    public int MaxConnection(int[][] grid) {
        int n = grid.length;
        int maxConnected = 0;
        
        // Function to perform DFS and count connected 1s
        boolean[][] visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    maxConnected = Math.max(maxConnected, dfs(grid, i, j, visited));
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    grid[i][j] = 1;
                    boolean[][] tempVisited = new boolean[n][n];
                    maxConnected = Math.max(maxConnected, dfs(grid, i, j, tempVisited));
                    grid[i][j] = 0;
                }
            }
        }

        return maxConnected;
    }

    // DFS to count the number of connected 1s
    private int dfs(int[][] grid, int row, int col, boolean[][] visited) {
        int n = grid.length;
        if (row < 0 || row >= n || col < 0 || col >= n || grid[row][col] == 0 || visited[row][col]) {
            return 0;
        }

        visited[row][col] = true;
        int count = 1;
        
        for (int i = 0; i < 4; i++) {
            int newRow = row + rowDirection[i];
            int newCol = col + colDirection[i];
            count += dfs(grid, newRow, newCol, visited);
        }

        return count;
    }
}
