// public class palindrome_shit 

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class palindrome_shit {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.isPalindrome(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int solve(String s, int first, int last) {
        // Base case: if the indices cross each other or if the length of the string becomes 0 or 1
        if (first >= last) 
            return 1;

        // If the characters at the current indices don't match, the string is not a palindrome
        if (s.charAt(first) != s.charAt(last)) 
            return 0;

        // Recursive case: check if the substring formed by excluding the first and last characters is a palindrome
        return solve(s, first + 1, last - 1);
    }

    int isPalindrome(String S) {
        // Check if the input string is null or empty
        if (S == null || S.isEmpty())
            return 1; // An empty string is considered a palindrome
        
        // Call the recursive function with the indices pointing to the start and end of the string
        return solve(S, 0, S.length() - 1);
    }
}