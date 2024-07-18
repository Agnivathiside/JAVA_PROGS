// public class coin_change_Shit

//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class coin_change_Shit {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int sum = sc.nextInt();
            int N = sc.nextInt();
            int coins[] = new int[N];
            for (int i = 0; i < N; i++)
                coins[i] = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.count(coins, N, sum));
        }
    }
}

// } Driver Code Ends

// User function Template for Java

class Solution {
    public int solve(int coins[], int N, int sum){
        if (sum<0){
            return 0;
        }
        int ans=0;
        for (int i=0; i<N; i++){
            ans = 1+ solve(coins, N, sum-coins[i]);
        }
        return ans;
    }
    public long count(int coins[], int N, int sum) {
        // code here.
        return solve(coins, N, sum);

    }
}