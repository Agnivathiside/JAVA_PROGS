//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.nthFibonacci(n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

//User function Template for Java
class Solution {
    public static long fib(long n, long[] dp){
        if (n<=1){
            return n;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        dp[n]= fib(n-1, dp)+fib(n-2,dp);
        return dp[n];
    }
    static int nthFibonacci(int n){
        // code here
        long[] dp = new long[n+1];
        for(int i=0;i<n+1;i++){
            dp[i]=-1;
        }
        return (int) fib(n,dp);
    }
}