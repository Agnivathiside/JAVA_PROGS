//{ Driver Code Starts
//Initial Template for JAVA

import java.io.*;
import java.util.*;

class minimum_climbing_stairs_shit {
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
    public static int solve(int[] cost, int n){
        if(n==0) return cost[0];
        if(n==1) return cost[1];

        int ans=Math.min(solve(cost,n-1), solve(cost, n-2));
        return ans;
    }
    static int minCostClimbingStairs(int[] cost , int N) {
        //Write your code here
        int ans=Math.min(solve(cost, N-1), solve(cost,N-2));
        return ans;
    }
}