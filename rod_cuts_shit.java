// public class rod_cuts_shit

//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

public class rod_cuts_shit {
    public static void main(String args[]) throws IOException {
        // reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        // reading total testcases
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            // reading length of line segment
            int n = Integer.parseInt(read.readLine().trim());

            // reading 3 segment lengths
            String str[] = read.readLine().trim().split(" ");

            int x = Integer.parseInt(str[0]);
            int y = Integer.parseInt(str[1]);
            int z = Integer.parseInt(str[2]);

            // calling method maximizeCuts() of class Solution()
            // and printinting the result
            System.out.println(new Solution().maximizeCuts(n, x, y, z));
        }
    }
}

// } Driver Code Ends

// User function Template for Java

class Solution {
    public int solve(int n, int x, int y, int z) {
        if (n == 0 || n < 0)
            return 0;

        int xcuts = solve(n - x, x, y, z) + 1;
        int ycuts = solve(n - y, x, y, z) + 1;
        int zcuts = solve(n - z, x, y, z) + 1;

        return Math.max(xcuts, Math.max(ycuts, zcuts));
    }

    public int maximizeCuts(int n, int x, int y, int z) {
        // Your code here
        if (n == 0)
            return 0;

        int xcuts = solve(n, x, y, z);
        int ycuts = solve(n, x, y, z);
        int zcuts = solve(n, x, y, z);

        return Math.max(xcuts, Math.max(ycuts, zcuts));
    }
}
