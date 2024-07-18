// public class path_to_origin_shit

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

// } Driver Code Ends
//User function Template for Java

class Solution {
    static int MOD = 1000000007;
    public static int solve(int x, int y){
        if (x==0 && y==0) return 1;
        if (x<0 || y<0) return 0;

        int left = solve(x-1, y) % MOD;
        int down = solve(x, y-1) % MOD;

        return (left+down) % MOD;
    }
    public static int solveMem(int x, int y, int dp[][]){
        if (x==0 && y==0) return 1;
        if (x<0 || y<0) return 0;

        if (dp[x][y]!=-1) return dp[x][y];

        int left = solveMem(x-1, y, dp) % MOD;
        int down = solveMem(x, y-1, dp) % MOD;

        dp[x][y]=(left+down) % MOD;
        return dp[x][y];
    }
    public static int ways(int n, int m) {
        // complete the function
        // return solve(n, m);
        int dp[][] = new int[n+1][m+1];
        for (int i=0; i<n+1; i++){
            for (int j = 0; j<m+1; j++){
                dp[i][j] = -1;
            }
        }
        return solveMem(n, m, dp);
    }
}

// { Driver Code Starts.

// Driver class
public class path_to_origin_shit {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while (testcases-- > 0) {
            String line = br.readLine();
            String[] elements = line.trim().split("\\s+");
            int x = Integer.parseInt(elements[0]);
            int y = Integer.parseInt(elements[1]);
            Solution ob = new Solution();
            System.out.println(ob.ways(x, y));
        }
    }
}
// } Driver Code Ends
