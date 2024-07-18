// public class number_of_islands_shit

//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.LinkedList;

public class number_of_islands_shit{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[i][j] = S[j].charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends

class pair {
    int first;
    int second;

    public pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public void bfs(char grid[][], int visited[][], int ro, int co) {
        visited[ro][co] = 1;
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(ro, co));
        int n = grid.length;
        int m = grid[0].length;

        while (!q.isEmpty()) {
            int row = q.peek().first;
            int col = q.peek().second;
            q.remove();

            for (int delrow = -1; delrow <= 1; delrow++) {
                for (int delcol = -1; delcol <= 1; delcol++) {
                    int nrow = row + delrow;
                    int ncol = col + delcol;
                    if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m &&
                            grid[nrow][ncol] == '1' && visited[nrow][ncol] == 0) {
                        visited[nrow][ncol] = 1;
                        q.add(new pair(nrow, ncol));
                    }
                }
            }

        }
    }

    public int numIslands(char[][] grid) {
        // Code here
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        int visited[][] = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] == 0 && grid[i][j] == '1') {
                    count++;
                    bfs(grid, visited, i, j);
                }
            }
        }
        return count;

    }
}
