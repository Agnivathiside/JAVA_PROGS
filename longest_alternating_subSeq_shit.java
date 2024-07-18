// public class longest_alternating_subSeq_shit

//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java
//Back-end complete function Template for Java
// class Solution {
//     public int solve(int arr[], int n, int curr, int prev, boolean isIncreasing){
//         if (curr == n){
//             return 0;
//         }

//         int include = 0;
//         if (prev == -1 || (isIncreasing && arr[curr] > arr[prev]) || (!isIncreasing && arr[curr] < arr[prev])) {
//             include = 1 + solve(arr, n, curr + 1, curr, !isIncreasing);
//         }
        
//         int exclude = solve(arr, n, curr + 1, prev, isIncreasing);

//         return Math.max(include, exclude);
//     }

//     public int alternatingMaxLength(int[] arr) {
//         int n = arr.length;
//         int ans1 = solve(arr, n, 0, -1, true);
//         int ans2 = solve(arr, n, 0, -1, false);
//         return Math.max(ans1, ans2);
//     }
// }


// class Solution {
//     public int solve(int arr[], int n, int curr, int prev, boolean isIncreasing, int[][][] memo) {
//         if (curr == n) {
//             return 0;
//         }

//         // Convert boolean isIncreasing to an integer index (0 or 1)
//         int incIndex = isIncreasing ? 1 : 0;

//         // Check memo array
//         if (memo[curr][prev + 1][incIndex] != -1) {
//             return memo[curr][prev + 1][incIndex];
//         }

//         int include = 0;
//         if (prev == -1 || (isIncreasing && arr[curr] > arr[prev]) || (!isIncreasing && arr[curr] < arr[prev])) {
//             include = 1 + solve(arr, n, curr + 1, curr, !isIncreasing, memo);
//         }

//         int exclude = solve(arr, n, curr + 1, prev, isIncreasing, memo);

//         // Store the result in the memo array
//         memo[curr][prev + 1][incIndex] = Math.max(include, exclude);

//         return memo[curr][prev + 1][incIndex];
//     }

//     public int alternatingMaxLength(int[] arr) {
//         int n = arr.length;

//         // Initialize memo array with -1
//         int[][][] memo = new int[n][n + 1][2];
//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j <= n; j++) {
//                 memo[i][j][0] = -1;
//                 memo[i][j][1] = -1;
//             }
//         }

//         int ans1 = solve(arr, n, 0, -1, true, memo);
//         int ans2 = solve(arr, n, 0, -1, false, memo);

//         return Math.max(ans1, ans2);
//     }
// }


class Solution {
    public int alternatingMaxLength(int[] arr) {
        int dec=1,inc=1;
        for(int i=1;i<arr.length;i++){
            if(arr[i]>arr[i-1])inc=dec+1;
            else if(arr[i]<arr[i-1])dec=inc+1;
        }
        return Math.max(inc,dec);
    }
}

//{ Driver Code Starts.

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            String s[] = br.readLine().trim().split(" ");
            int[] nums = new int[s.length];
            for (int i = 0; i < s.length; i++) {
                nums[i] = Integer.parseInt(s[i]);
            }
            Solution obj = new Solution();
            int ans = obj.alternatingMaxLength(nums);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends
