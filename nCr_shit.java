// public class nCr_shit

//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

public class nCr_shit {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            String read[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(read[0]);
            int r = Integer.parseInt(read[1]);

            Solution ob = new Solution();
            System.out.println(ob.nCr(n, r));
        }
    }
}
// } Driver Code Ends

// User function Template for Java

class Solution {
    static int MOD=(int)Math.pow(10, 9)+7;
    static int fac(int n){
        if (n==1 || n==0) return 1;
        return n*fac(n-1);
    }
    // static int nCr(int n, int r) {
    //     // code here
    //     if (r>n) return 0;
    //     System.out.println("factorial of n is "+fac(n));
    //     System.out.println("factorial if r is "+fac(r));
    //     System.out.println("factorial of n-r is "+fac(n-r));
    //     return (fac(n)/(fac(r)*fac(n-r)))%MOD;
    // }
    static int solve(int dp[][], int n, int r){
        if (r==0 || r==n) return 1;

        if (dp[n][r]!=-1) return dp[n][r];

        dp[n][r]= (solve(dp, n-1, r-1) + solve(dp, n-1, r))%MOD;
        return dp[n][r];
    }
    static int nCr(int n, int r) {
        // code here
        int dp[][] = new int[n+1][r+1];
        for (int i=0; i<n+1; i++){
            for (int j=0; j<r+1; j++){
                dp[i][j]=-1;
            }
        }
        return solve(dp, n, r);
    }
}
