// public class form_a_palindrome_shit

//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class form_a_palindrome_shit {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String str = read.readLine();

            Solution ob = new Solution();

            System.out.println(ob.countMin(str));
        }
    }
}
// } Driver Code Ends

// User function Template for Java

// class Solution {
//     static int solve(String str, int index){
//         int count=0;
//         int l = index-1;
//         int r = index+1;
//         while(l>=0 && r<str.length()){
//             if (str.charAt(l)!=str.charAt(r)){
//                 count++;
//             }
//             l--;
//             r++;
//         }
//         while(l>=0){
//             count++;
//             l--;
//         }
//         while(r<str.length()){
//             count++;
//             r++;
//         }
//         return count;
//     }
//     static int countMin(String str) {
//         // code here
//         int ans = Integer.MAX_VALUE;
//         for(int i=0; i<str.length(); i++){
//             ans = Math.min(ans, solve(str, i));
//         }
//         return ans;
//     }
// }

class Solution{
    static int countMin(String str)
    {
       int[][] dp = new int[str.length()][str.length()];
       for(int [] arr : dp)
        Arrays.fill(arr , -1);
    
       String rev = new StringBuilder(str).reverse().toString();
       return str.length() - solve(0,0,str,rev,dp);
    }
    public static int solve(int i , int j , String str , String rev , int[][] dp){
        if(i == str.length() || j == rev.length())
            return 0;
        if(dp[i][j] != -1)
            return dp[i][j];
        
        if(str.charAt(i) == rev.charAt(j))
            dp[i][j] =  1 + solve(i+1 , j+1 , str , rev , dp);
        
        else
        
        dp[i][j] =  Math.max(solve(i+1 , j , str , rev , dp) ,
        solve(i , j+1 , str , rev , dp));
        
        return dp[i][j];
        
    }
}