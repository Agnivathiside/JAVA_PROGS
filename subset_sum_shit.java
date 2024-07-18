// public class subset_sum_shit

//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class subset_sum_shit {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for (int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if (ob.isSubsetSum(N, arr, sum))
                System.out.println(1);
            else
                System.out.println(0);

        }
    }
}

// } Driver Code Ends

// User function Template for Java

// class Solution {
//     static int solve(int arr[], int index, int sum){
//         if (index<0) return 0;
//         if (sum <0) return 0;
//         if (sum==0) return 1;

//         int include = solve(arr, index-1, sum-arr[index]);
//         int exclude = solve(arr, index-1, sum);

//         return include | exclude;

//     }
//     static int solveMem(int arr[], int index, int sum, int dp[][]){
//         if (index<0 || sum<0) return 0;
//         if (sum==0) return 1;

//         if (dp[index][sum]!=-1) return dp[index][sum];

//         int include = solveMem(arr, index-1, sum-arr[index], dp);
//         int exclude = solveMem(arr, index-1, sum, dp);

//         dp[index][sum]=include | exclude;
//         return dp[index][sum];
//     }
//     static Boolean isSubsetSum(int N, int arr[], int sum) {
//         // code here
//         // int found = solve(arr, N-1, sum);
//         // if (found==1) return true;
//         // return false;

//         int dp[][] = new int[N+1][sum+1];
//         for (int i=0; i<N+1; i++){
//             for (int j=0; j<sum+1; j++){
//                 dp[i][j] = -1;
//             }
//         }
//         int found= solveMem(arr, N-1, sum, dp);
//         return found==1?true:false;
//     }
// }

class Solution {
    static boolean solveMem(int arr[], int index, int sum, int dp[][]) {
        if (sum < 0) return false; // If sum becomes negative, return false
        if (sum == 0) return true; // Base case: subset with sum 0 found
        if (index < 0) return false; // Base case: reached end of array
        
        if (dp[index][sum] != -1) return dp[index][sum] == 1;

        boolean include = solveMem(arr, index - 1, sum - arr[index], dp);
        boolean exclude = solveMem(arr, index - 1, sum, dp);

        dp[index][sum] = include || exclude ? 1 : 0;
        return dp[index][sum] == 1;
    }
    
    static boolean isSubsetSum(int N, int arr[], int sum) {
        int dp[][] = new int[N][sum + 1];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < sum + 1; j++) {
                dp[i][j] = -1;
            }
        }
        return solveMem(arr, N - 1, sum, dp);
    }
}
