// public class dice_throw_shit 

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class dice_throw_shit{
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");

            int M = Integer.parseInt(S[0]);
            int N = Integer.parseInt(S[1]);
            int X = Integer.parseInt(S[2]);

            Solution ob = new Solution();
            System.out.println(ob.noOfWays(M, N, X));
        }
    }
}
// } Driver Code Ends

// User function Template for Java
// https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/
class Solution {
    static long solve(int n, int k, int target, int dp[][]){
        
        if (n==0 && target == 0){
            return 1;
        }
        if (n==0 || target>0){
            return 0;
        }

        if (dp[n][target]!=-1){
            return dp[n][target];
        }
        int ans = 0;
        for(int i=1; i<=k; i++){
            ans += solve(n-1, k, target-i, dp);
        }
        return dp[n][target] = ans;
    }
    static long noOfWays(int M, int N, int X) {
        // code here
        int dp[][]= new int[N+1][X+1];
        
        for(int i=0; i<N+1; i++){
            Arrays.fill(dp[i], -1);
        }
        return solve(N, M, X, dp);
    }
}
