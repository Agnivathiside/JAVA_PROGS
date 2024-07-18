// public class reach_score_shit

//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class reach_score_shit {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t > 0) {
            int n = in.nextInt();
            Geeks obj = new Geeks();
            System.out.println(obj.count(n));
            t--;
        }
    }
}
// } Driver Code Ends

// Complete this function!

class Geeks {
    public long solveMem(long dp[], int n) {
        if (n == 0)
            return 1;
        if (n < 0)
            return 0;

        if (dp[n] != -1)
            return dp[n];

        long three = solveMem(dp, n - 3);
        long five = solveMem(dp, n - 5);
        long ten = solveMem(dp, n - 10);

        dp[n] = three + five + ten;
        return dp[n];
    }

    public long count(int n) {
        long[] dp = new long[n + 1];
        for (int i = 0; i < n + 1; i++) {
            dp[i] = -1;
        }
        return solveMem(dp, n);
    }
}
