// public class longest_k_unique_shit

//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class longest_k_unique_shit {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}
// } Driver Code Ends

// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        // code here
        if (s == null || s.length() == 0 || k <= 0) {
            return -1;
        }

        int maxLen = -1;
        int left = 0, right = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        while (right < s.length()) {
            char currChar = s.charAt(right);
            // i'll check if this is present in the map or not, increment accordingly
            map.put(currChar, map.getOrDefault(currChar, 0) + 1);

            while (map.size() > k) {
                char charLeft = s.charAt(left);
                map.put(charLeft, map.get(charLeft) - 1);
                if (map.get(charLeft) == 0) {
                    map.remove(charLeft);
                }
                left++;
            }

            if (map.size() == k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
            right++;
        }
        return maxLen;
    }
}