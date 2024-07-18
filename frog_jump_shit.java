// public class frog_jump_shit

//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

public class frog_jump_shit implements Runnable {
    public void run() {
        try {
            BufferedReader in;
            PrintWriter out;
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
            int t = Integer.parseInt(in.readLine());

            while (t-- > 0) {
                int n = Integer.parseInt(in.readLine().trim());

                Solution g = new Solution();
                out.println(g.countWays(n));
            }
            out.close();
        } catch (Exception e) {
            ;
        }
    }

    public static void main(String args[]) throws IOException {
        new Thread(null, new frog_jump_shit(), "whatever", 1 << 26).start();
    }
}
// } Driver Code Ends

// User function Template for Java

class Solution {
    static long MOD=(long)Math.pow(10, 9)+7;
    static long solve(int n){
        if (n==0) return 1;
        if (n<0) return 0;

        long one = solve(n-1);
        long two = solve(n-2);
        long three = solve(n-3);

        return one+two+three;
    }

    static long solveMem(int n, long dp[]){
        if (n==0) return 1;
        if (n<0) return 0;

        if (dp[n]!=-1) return dp[n];

        long one = solveMem(n-1, dp);
        long two = solveMem(n-2, dp);
        long three=solveMem(n-3, dp);

        dp[n]=(one+two+three)%MOD;

        return dp[n];
    }
    
    static long countWays(int n) {
        // add your code here
        long[] dp = new long[n+1];

        for (int i=0; i<n+1; i++){
            dp[i] = -1;
        }
        // return solve(n);

        return solveMem(n, dp);
    }

}
