// public class min_cost_weight_shit

//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            int w;
            w = Integer.parseInt(br.readLine());

            int[] cost = IntArray.input(br, n);

            Solution obj = new Solution();
            int res = obj.minimumCost(n, w, cost);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends

// class Solution {
//     public static int solve(int i, int w, int cost[]){
//         if (w==0){
//             return 0;
//         }

//         if (i==0 || w<0){
//             return Integer.MAX_VALUE;
//         }

//         int notTake = solve(i-1, w, cost);

//         int take = Integer.MAX_VALUE;
//         if (cost[i-1]!=-1 && w>=i){
//             int subRes = solve(i, w-i, cost);
//             if (subRes!=Integer.MAX_VALUE){
//                 take = cost[i] + subRes;
//             }
//         }

//         return Math.min(notTake, take);
//     }
//     public static int minimumCost(int n, int w, int[] cost) {
//         // code here
//         int result = solve(n, w, cost);

//         return result==Integer.MAX_VALUE?-1:result;
//     }
// }


class Solution {
    public static int minimumCost(int n, int w, int[] cost) {
        // Initialize memoization array with -1
        int[][] dp = new int[n + 1][w + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= w; j++) {
                dp[i][j] = -1;
            }
        }
        
        // Start the recursion with memoization
        int result = solve(n, w, cost, dp);
        
        // If result is infinity, it means it's not possible to buy exactly w kg
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    // Helper function to recursively solve the problem with memoization
    public static int solve(int i, int w, int[] cost, int[][] dp) {
        // Base cases
        if (w == 0) {
            return 0;
        }
        if (i == 0 || w < 0) {
            return Integer.MAX_VALUE;
        }

        // If already computed, return the stored value
        if (dp[i][w] != -1) {
            return dp[i][w];
        }

        // Option 1: Do not take the i-th packet
        int notTake = solve(i - 1, w, cost, dp);

        // Option 2: Take the i-th packet (if it's available)
        int take = Integer.MAX_VALUE;
        if (cost[i - 1] != -1 && w >= i) {
            int subResult = solve(i, w - i, cost, dp);
            if (subResult != Integer.MAX_VALUE) {
                take = cost[i - 1] + subResult;
            }
        }

        // Store the result in the dp array
        dp[i][w] = Math.min(take, notTake);
        
        // Return the computed value
        return dp[i][w];
    }
}
