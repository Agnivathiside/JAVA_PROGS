// public class house_robber_shit

//{ Driver Code Starts
import java.util.*;
import java.io.*;

public class house_robber_shit {
    public static void main(String[] args) {

        // taking input using Scanner class
        Scanner sc = new Scanner(System.in);

        // taking count of testcases
        int t = sc.nextInt();
        while (t-- > 0) {

            // taking count of houses
            int n = sc.nextInt();
            int arr[] = new int[n];

            // inserting money present in
            // each house in the array
            for (int i = 0; i < n; ++i)
                arr[i] = sc.nextInt();

            // calling method FindMaxSum() of class solve
            System.out.println(new Solution().FindMaxSum(arr, n));
        }
    }
}
// } Driver Code Ends

class Solution {
    public int solveMem(int arr[], int dp[], int index) {
        if (index < 0)
            return 0;

        if (index == 0)
            return arr[0];

        if (dp[index] != -1)
            return dp[index];

        int include = solveMem(arr, dp, index - 2) + arr[index];
        int exclude = solveMem(arr, dp, index - 1);

        dp[index] = Math.max(include, exclude);

        return dp[index];
    }
    // public void printArray(int[] arr){
    //     for (int i=0;i<arr.length;i++){
    //         System.out.print(arr[i]+" ");
    //     }
    //     System.out.println("\n");
    // }

    public int FindMaxSum(int arr[], int n) {
        // Your code here
        int[] first = new int[n-1];
        int[] second = new int[n-1];

        for (int i = 0; i < n-1; i++) {
            first[i] = arr[i];
            second[i]=arr[i+1];
        }

        // printArray(first);
        // printArray(second);

        int[] dpF = new int[n];
        int[] dpS = new int[n];
        for (int i = 0; i < n; i++) {
            dpF[i] = -1;
            dpS[i] = -1;
        }

        int ans_first = solveMem(first, dpF, first.length - 1);
        int ans_secon = solveMem(second, dpS, second.length - 1);

        return Math.max(ans_first, ans_secon);

    }
}
