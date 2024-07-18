// public class knapsack_shit

//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

public class knapsack_shit {
    public static void main(String args[]) throws IOException {
        // reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        // reading total testcases
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            // reading number of elements and weight
            int n = Integer.parseInt(read.readLine());
            int w = Integer.parseInt(read.readLine());

            int val[] = new int[n];
            int wt[] = new int[n];

            String st[] = read.readLine().trim().split("\\s+");

            // inserting the values
            for (int i = 0; i < n; i++)
                val[i] = Integer.parseInt(st[i]);

            String s[] = read.readLine().trim().split("\\s+");

            // inserting the weigths
            for (int i = 0; i < n; i++)
                wt[i] = Integer.parseInt(s[i]);

            // calling method knapSack() of class Knapsack
            System.out.println(new Solution().knapSack(w, wt, val, n));
        }
    }
}

// } Driver Code Ends

class Solution {
    public static int solve(int index, int wt[], int val[], int capacity) {
        if (index == 0) {
            if (wt[0] <= capacity) {
                return val[0];
            } else {
                return 0;
            }
        }

        int include = 0;
        if (wt[index] <= capacity) {
            include = val[index] + solve(index - 1, wt, val, capacity - wt[index]);
        }

        int exclude = solve(index - 1, wt, val, capacity);

        int ans = Math.max(include, exclude);

        return ans;
    }

    public static int solveMem(int index, int capacity, int wt[], int val[], int[][] dp) {
        if (index == 0) {
            if (wt[0] <= capacity) {
                return val[0];
            } else {
                return 0;
            }
        }
        if (dp[index][capacity]!=-1) return dp[index][capacity];
        int include = 0;
        if (wt[index] <= capacity) {
            include = val[index] + solveMem(index - 1,capacity - wt[index], wt, val, dp);
        }

        int exclude = solveMem(index - 1,capacity, wt, val, dp);

        dp[index][capacity] = Math.max(include, exclude);

        return dp[index][capacity];
    }

    public static int knapSack(int W, int wt[], int val[], int n) {
        // return solve(n - 1, wt, val, W);
        int[][] dp = new int[n+1][W+1];
        for (int i=0; i<n+1; i++){
            for (int j=0; j<W+1; j++){
                dp[i][j] = -1;
            }
        }
        return solveMem(n-1, W, wt, val, dp);

    }
}
