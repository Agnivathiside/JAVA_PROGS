// public class minimum_operation_shit

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class minimum_operation_shit {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.minOperation(n));
        }
    }
}
// } Driver Code Ends

// User function Template for Java

class Solution {
    public int solve( int curr, int n ){
        if (curr==n) return 1;
        if (curr>n) return Integer.MAX_VALUE;

        int add=solve(curr + 1 , n)+1;
        int mul=solve(curr*curr, n)+1;

        return Math.min(add, mul);

    }
    public static int solver(int n, int steps) {
        // Base case
        if (n == 0) {
            return steps;
        }

        // If number divisible by 2
        if (n % 2 == 0) {
            return solver(n / 2, ++steps);
        }
        // Else just subtract 1
        else {
            return solver(n - 1, ++steps);
        }
    }

    public static int minOperation(int n) {
        int steps = 0;
        return solver(n, steps);
    }
}