// public class count_ways_nth_stair_shit

//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class count_ways_nth_stair_shit {
    public static void main(String[] args) {

        // taking input using Scanner class
        Scanner sc = new Scanner(System.in);

        // taking total testcases
        int t = sc.nextInt();

        while (t-- > 0) {

            // taking count of stairs
            int m = sc.nextInt();

            // creating an object of class DynamicProgramming
            Solution obj = new Solution();

            // calling method countWays() of class
            // DynamicProgramming
            System.out.println(obj.countWays(m));

        }

    }
}
// } Driver Code Ends

class Solution {
    int solve(int n, int index){
        if(index>n) return 0;
        if (index==n) return 1;

        int one = solve(n, index+1);
        int two = solve(n, index+2);

        return one+two;
    }
    int solveMem(int n, int index, int dp[]){
        if (index>n) return 0;
        if (index==n) return 1;

        if (dp[index]!=-1) return dp[index];

        int one = solve(n, index+1);
        int two = solve(n, index+2);

        dp[index]=one+two;
        return dp[index];
    }
    int countWays(int n) {

        // your code here
        int dp[] = new int[n+1];
        for (int i=0; i<n+1; i++){
            dp[i]=-1;
        }
        return solveMem(n, 0, dp);
        // return solve(n, 0);
    }
}
