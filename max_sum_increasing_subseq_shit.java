// public class max_sum_increasing_subseq_shit

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class max_sum_increasing_subseq_shit{
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int Arr[] = new int[n];
            for (int i = 0; i < n; i++)
                Arr[i] = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.maxSumIS(Arr, n));
        }
    }
}
// } Driver Code Ends

// User function Template for Java

// class Solution {
//     public int solve(int arr[], int index, int n){
//         if (index>n) return 0;
        
//         System.out.println("Current element is "+arr[index]);
//         int include=0, exclude=0;
//         if(index+1<n && arr[index+1]>arr[index]){
//             include = arr[index] +  solve(arr, index+1, n);
//             exclude = solve(arr, index+1, n);
//         }else{
//             return solve(arr, index+1, n);
//         }
//         System.out.println("Returning "+Math.max(include, exclude));
//         return Math.max(include, exclude);
//     }
//     public int maxSumIS(int arr[], int n) {
//         // code here..
//         int max=Integer.MIN_VALUE;
//         for (int i=0; i<n; i++){
//             max=Math.max(max, solve(arr, i, n-1));
//         }
//         return max;
//     }
// }


class Solution {
    public int solve(int arr[], int index, int n, int prev){
        if (index >= n) return 0; // Base case: out of bounds
        
        // If the current element is greater than the previous element,
        // we have two options: include it or exclude it
        int include = 0;
        if (arr[index] > prev) {
            include = arr[index] + solve(arr, index + 1, n, arr[index]); // Include current element
        }
        
        int exclude = solve(arr, index + 1, n, prev); // Exclude current element
        
        // Return the maximum sum obtained by either including or excluding the current element
        return Math.max(include, exclude);
    }
    
    public int maxSumIS(int arr[], int n) {
        // Iterate through the array and call the solve function for each index
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            maxSum = Math.max(maxSum, solve(arr, i, n, Integer.MIN_VALUE)); // Pass Integer.MIN_VALUE as previous element initially
        }
        return maxSum;
    }
}
