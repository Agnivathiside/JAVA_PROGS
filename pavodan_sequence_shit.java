// public class pavodan_sequence_shit

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class pavodan_sequence_shit {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.padovanSequence(n));
        }
    }
}
// } Driver Code Ends

// User function Template for Java

class Solution {
    public int MOD =(int) Math.pow(10, 9) + 7;
    public int solve(int n, int ans[]){
        if (n==0) return ans[0];
        if (n==1) return ans[1];
        if (n==2) return ans[2];

        if (ans[n]!=-1) return ans[n];

        ans[n] = ((solve(n-2, ans) % MOD) + (solve(n-3, ans) % MOD)) % MOD;
        return ans[n] % MOD;
    }
    public int padovanSequence(int n) {
        // code here.
        if (n==0 || n==1 || n==2) return 1;
        int ans[] = new int[n+1];
        Arrays.fill(ans, -1);
        ans[0] = 1;
        ans[1] = 1;
        ans[2] = 1;
        return solve(n, ans) % MOD;
    }

}
// class Solution
// {
    
//   public int padovanSequence(int n)
//     {
//         if (n==0 || n==1 || n==2) return 1;
//         return padovanSequence(n-2) + padovanSequence(n-3);
//     }
    
// }