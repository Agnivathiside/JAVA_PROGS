//{ Driver Code Starts
//Initial Template for JAVA

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            
            int[] cost = new int[N];
            
            for(int i=0 ; i<N ; i++)
                cost[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.minCostClimbingStairs(cost,N));
        }
    }
}
// } Driver Code Ends


//Back-end complete function Template for Java

class Solution {
    static int solve(int[] cost, int n){
        if (n==1) return cost[1];
        if (n==0) return cost[2];

        return cost[n]+Math.min(solve(cost, n-1), solve(cost, n-2));
    }
    static int solve2(int[] cost, int n, int[] dp){
        if (n==1) return cost[1];
        if (n==0) return cost[0];

        if (dp[n]!=-1) return dp[n];
        dp[n]=cost[n]+Math.min(solve2(cost, n-1,dp), solve2(cost, n-2,dp));
        return dp[n];

    }
    static int minCostClimbingStairs(int[] cost , int N) {
        //Write your code here
        // int n= cost.length;
        // int ans=Math.min(solve(cost, n-1), solve(cost,n-2));
        // return ans;
        int n= cost.length;
        int[] dp=new int[n+1];
        int ans=Math.min(solve2(cost, n-1,dp), solve2(cost,n-2,dp));
        return ans;
    }
};