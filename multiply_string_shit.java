// public class multiply_string_shit

//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.math.*;

public class multiply_string_shit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String a = sc.next();
            String b = sc.next();
            Solution g = new Solution();
            System.out.println(g.multiplyStrings(a, b));
        }
    }
}
// } Driver Code Ends

// User function Template for Java

class Solution {
    public String multiplyStrings(String s1, String s2) {
        // code here.
        int num1=Integer.parseInt(s1);
        int num2=Integer.parseInt(s2);

        return String.valueOf(num1*num2);
    }
}