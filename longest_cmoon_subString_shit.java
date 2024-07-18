// public class longest_cmoon_subString_shit

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class longest_cmoon_subString_shit {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String input[] = read.readLine().trim().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);

            String S1 = read.readLine().trim();
            String S2 = read.readLine().trim();

            Solution ob = new Solution();
            System.out.println(ob.longestCommonSubstr(S1, S2, n, m));
        }
    }
}
// } Driver Code Ends

// User function Template for Java

class Solution {
    int solveMem(String s1, String s2, int i, int j, int dp[][]) {
        if (i == s1.length() || j == s2.length()) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        int ans = 0;
        if (s1.charAt(i) == s2.charAt(j)) {
            ans = 1 + solveMem(s1, s2, i + 1, j + 1, dp);
        } else {
            // If characters don't match, reset ans to 0
            ans = 0;
        }
        dp[i][j] = ans;
        return dp[i][j];
    }
    int longestCommonSubstr(String s1, String s2, int n, int m) {
        // code here
        int[][] dp = new int[m][n];

        int maxLength = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
                maxLength = Math.max(maxLength, solveMem(s1, s2, i, j, dp));
            }
        }
        return maxLength;
    }
}
