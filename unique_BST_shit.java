// public class unique_BST_shit

//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;
// { Driver Code Starts.

public class unique_BST_shit {
    public static void main(String args[]) {
        // taking input using Scanner class
        Scanner sc = new Scanner(System.in);

        // taking total testcases
        int t = sc.nextInt();

        while (t-- > 0) {
            // taking n
            int n = sc.nextInt();

            // creating an object of class Solution
            Solution ob = new Solution();

            // calling method numTrees() of
            // class Solution
            System.out.println(ob.numTrees(n));
        }
    }
}
// } Driver Code Ends
// User function Template for Java

class Solution {
    static int solveMem(int dp[], int N){
        // Base case: If N is 0 or 1, there is only one unique BST.
        if (N <= 1) {
            return 1;
        }
    
        if (dp[N] != -1) {
            return dp[N]; // If result is already computed, return it.
        }
    
        int total = 0;
        for(int i = 1; i <= N; i++){
            // Count the number of left subtrees for the root i.
            int leftSubtrees = solveMem(dp, i - 1);
            // Count the number of right subtrees for the root i.
            int rightSubtrees = solveMem(dp, N - i);
            // Total number of unique BSTs rooted at i is the product
            // of the number of left and right subtrees.
            total += leftSubtrees * rightSubtrees;
        }
        // Memoize the result for N.
        dp[N] = total;
        return total;
    }
    
    static int numTrees(int N) {
        int dp[] = new int[N+1];
        for(int i=0; i<N+1; i++){
            dp[i]=-1;
        }
        return solveMem(dp, N);
    }
}
