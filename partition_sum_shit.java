// public class partition_sum_shit

//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class partition_sum_shit {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for (int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);

            Solution ob = new Solution();
            int x = ob.equalPartition(N, arr);
            if (x == 1)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
// } Driver Code Ends

// User function Template for Java

class Solution {
    static int findTwoSum(int n, int arr[], int sum, int index, int dp[][]) {
        // If the sum becomes zero, it means we have found a partition
        // with the desired sum.
        if (sum == 0) {
            return 1;
        }
        
        // If we have considered all elements and the sum is still not zero,
        // it means no partition with the desired sum is possible.
        if (index < 0 || sum < 0) {
            return 0;
        }

        if(dp[sum][index]!=-1) return dp[sum][index];

        // Two choices at each step: include the current element in the sum
        // or exclude it.
        int include = findTwoSum(n, arr, sum - arr[index], index - 1, dp);
        int exclude = findTwoSum(n, arr, sum, index - 1, dp);

        // Return 1 if either of the choices leads to a partition with the desired sum.
        dp[sum][index]= include | exclude;
        return dp[sum][index];
    }

    static int equalPartition(int N, int arr[]) {
        int curSum = 0;
        for (int i = 0; i < N; i++) {
            curSum += arr[i];
        }
        
        // If the total sum is odd, equal partition is not possible.
        if (curSum % 2 != 0) {
            return 0;
        }

        // Compute half of the total sum.
        int halfSum = curSum / 2;
        int dp[][]= new int[halfSum+1][N+1];
        for(int i=0; i<halfSum+1; i++){
            for(int j=0; j<N+1; j++){
                dp[i][j]=-1;
            }
        }
        return findTwoSum(N, arr, halfSum, N - 1, dp);
    }
}
