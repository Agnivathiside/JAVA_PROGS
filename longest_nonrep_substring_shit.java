// public class longest_nonrep_substring_shit

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class longest_nonrep_substring_shit {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s = read.readLine().trim();

            Solution ob = new Solution();
            System.out.println(ob.longestUniqueSubsttr(s));
        }
    }
}
// } Driver Code Ends

// User function Template for Java

// class Solution {
//     int longestUniqueSubsttr(String S) {
//         int left=0, right=0;
//         HashSet<Character> set = new HashSet<>();
//         int maxi=-1;
//         while (right<S.length()){
//             if (!set.contains(S.charAt(right))){
//                 set.add(S.charAt(right));
//                 maxi=Math.max(maxi, right-left+1);
//                 right++;
//             }else{
//                 left=right;
//                 right++;
//                 set.remove(S.charAt(right));
//             }
//         }
//         return maxi;
//     }
// }

class Solution {
    int longestUniqueSubsttr(String S) {
        int left = 0, right = 0;
        HashSet<Character> set = new HashSet<>();
        int maxLength = 0;
        while (right < S.length()) {
            if (!set.contains(S.charAt(right))) {
                set.add(S.charAt(right));
                maxLength = Math.max(maxLength, right - left + 1);
                right++;
            } else {
                set.remove(S.charAt(left));
                left++;
            }
        }
        return maxLength;
    }
}
