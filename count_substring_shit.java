// public class count_substring_shit

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            System.out.println(new Solution().substrCount(s, k));
        }

    }
}
// } Driver Code Ends

// User function Template for Java

class Solution {
    long solve(String s, int index, int n){
        if (index>n) return 0;
        
    }
    long substrCount(String S, int K) {
        // your code here
    }
}