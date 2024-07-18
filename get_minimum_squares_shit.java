// public class get_minimum_squares_shit

//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

public class get_minimum_squares_shit {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.MinSquares(n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends

// User function Template for Java

class Solution {
    public int solve(int n){
        if (n==0) return 0;

        int ans=n;
        for (int i=1; i*i<=n; i++){
            ans=Math.min(ans, solve(n-i*i))+1;
        }

        return ans;
    }
    public int solveMem(int n, int dp[]){
        if (n==0) return 0;
        
        if (dp[n]!=-1) return dp[n];
        int ans=n;
        for (int i=1; i*i<=n; i++){
            ans = Math.min(ans, 1+solveMem(n-i*i, dp));
        }
        dp[n]=ans;
        return dp[n];
    }
    public int MinSquares(int n) {
        // Code here
        return solve(n);
        // int[] dp = new int[n+1];
        // for (int i=0; i<n+1; i++){
        //     dp[i]=-1;
        // }
        
        // return solveMem(n, dp);

    }
}