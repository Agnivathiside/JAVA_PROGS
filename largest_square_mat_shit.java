// public class largest_square_mat_shit

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class largest_square_mat_shit {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int mat[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    mat[i][j] = sc.nextInt();
                }
            }
            Solution ob = new Solution();
            System.out.println(ob.maxSquare(n, m, mat));
        }
    }
}
// } Driver Code Ends

// User function Template for Java

class Solution {
    static int solve(int mat[][], int i, int j, int max){
        if (i>=mat.length || j>=mat[0].length){
            return 0;
        }

        int right = solve(mat, i, j+1, max);
        int diag = solve(mat, i+1, j+1, max);
        int down = solve(mat, i, j+1, max);

        if (mat[i][j]==1){
            int ans = 1 + Math.min(right, Math.min(diag, down));
            max=Math.max(max, ans);
            return ans;
        }else{
            return 0;
        }
    }

    static int solveMem(int mat[][], int i, int j, int dp[][], int max){
        if (i>=mat.length || j>= mat[0].length){
            return 0;
        }

        if (dp[i][j]!=-1) return dp[i][j];

        int right = solveMem(mat, i, j+1, dp, max);
        int diag = solveMem(mat, i+1, j+1, dp, max);
        int down = solveMem(mat, i+1, j, dp, max);

        if (mat[i][j]==1){
            dp[i][j]=1+Math.min(right, Math.min(diag, down));
            max=Math.max(max, dp[i][j]);
            return dp[i][j];
        } 
        return dp[i][j]=0;
    }

    static int maxSquare(int n, int m, int mat[][]) {
        // code here
        // int maxi=0;
        // return solve(mat, 0, 0, maxi);

        int[][] dp = new int[n+1][m+1];
        for (int i=0; i<n+1; i++){
            for (int j=0; j<m+1; j++){
                dp[i][j]=-1;
            }
        }
        int maxi=Integer.MIN_VALUE;
        return solveMem(mat, 0, 0, dp, maxi);

    }
}
