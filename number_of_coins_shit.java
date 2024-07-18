// public class number_of_coins_shit

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
public class number_of_coins_shit
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int v = sc.nextInt();
                    int m = sc.nextInt();
                    int coins[] = new int[m];
                    for(int i = 0;i<m;i++)
                        coins[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minCoins(coins, m, v));
                }
        }
}    
// } Driver Code Ends


class Solution {
    public int solve(int coins[], int n, int target) {
        if (target == 0) {
            return 0; // Base case: successfully made the change
        }
        if (target < 0 || n < 0) {
            return -1; // Base case: not possible to make change
        }

        int include = 1 + solve(coins, n, target - coins[n]); // Use the current coin
        int exclude = solve(coins, n - 1, target); // Skip the current coin

        // Check if both options are valid before taking the minimum
        if (include == -1) {
            return exclude; // Cannot use the current coin
        } else if (exclude == -1) {
            return include; // Cannot skip the current coin
        } else {
            return Math.min(include, exclude);
        }
    }

    public int minCoins(int coins[], int M, int V) {
        // Your code goes here
        int result = solve(coins, M - 1, V);
        return result == Integer.MAX_VALUE ? -1 : result; // Return -1 if not possible
    }
}


