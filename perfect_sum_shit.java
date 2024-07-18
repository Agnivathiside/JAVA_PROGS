// public class perfect_sum_shit

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class perfect_sum_shit {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int sum = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            Solution ob = new Solution();
            System.out.println(ob.perfectSum(arr, n, sum));
        }
    }
}
// } Driver Code Ends

// class Solution {
//     public int solve(int index, int arr[], int sum, int n, int curSum){
//         // if (index>n){
//         //     return 0;
//         // }
//         // if (arr[index]==sum){
//         //     return 1;
//         // }
//         // if (curSum==sum){
//         //     return 1;
//         // }
//         if (index >= n) {
//             return 0;
//         }
//         if (arr[index] == sum || curSum + arr[index] == sum) {
//             return 1;
//         }
//         int include = solve(index+1, arr, sum, n, curSum+arr[index]);
//         int exclude = solve(index+2, arr, sum, n, curSum);

//         return include+exclude;
//     }
//     public int perfectSum(int arr[], int n, int sum) {
//         // Your code goes here
//         int count=0;
//         for(int i=0; i<n; i++){
//             count+=solve(i, arr, sum, n-1, 0);
//         }
//         return count;
//     }
// }

class Solution {
    static final int MOD = 1000000007;
    static int[][] memo;

    public int solve(int index, int arr[], int sum, int n, int curSum) {
        if (index == n) {
            return curSum == sum ? 1 : 0;
        }

        int include = solve(index + 1, arr, sum, n, curSum + arr[index]);
        int exclude = solve(index + 1, arr, sum, n, curSum);

        return (include % MOD + exclude % MOD) % MOD;
    }
    
    public int solveMem(int index, int arr[], int sum, int n, int curSum, int dp[]){
        if (index == n) {
            return curSum == sum ? 1 : 0;
        }

        if (memo[index][curSum] != -1) {
            return memo[index][curSum];
        }

        int include = solve(index + 1, arr, sum, n, curSum + arr[index]);
        int exclude = solve(index + 1, arr, sum, n, curSum);

        memo[index][curSum] = (include % MOD + exclude % MOD) % MOD;
        return memo[index][curSum];
    }
    public int perfectSum(int arr[], int n, int sum) {
        // int count = solve(0, arr, sum, n, 0);
        // return count;
        memo = new int[n][sum + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        int count = solve(0, arr, sum, n, 0);
        return count;
    }
}

