// public class largest_num_arr_shit

//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

public class largest_num_arr_shit {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            String[] arr = br.readLine().trim().split(" ");

            String ans = new Solution().printLargest(n, arr);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends

// User function Template for Java

class Solution {
    void reverse(String arr[], int n, String reversedArr[]){
        int j=n;

        for (int i=0; i<n; i++){
            reversedArr[j-1]=arr[i];
            j-=1;
        }

    }
    String solve(int index, String arr[], int n){
        if (index>n) return "";


        String preAppend = "";
        String postAppend= "";

        preAppend= solve(index+1, arr, n)+ preAppend + arr[index];
        postAppend = postAppend + arr[index] + solve(index+1, arr, n);

        // return Math.max(Integer.parseInt(preAppend), Integer.parseInt(postAppend));
        long preAppend_int=Long.parseLong(preAppend);
        long postAppend_int = Long.parseLong(postAppend);

        if (preAppend_int>postAppend_int) return preAppend;
        // if (preAppend>postAppend) return preAppend; 
        return postAppend;
        
    }
    String printLargest(int n, String[] arr) {
        // code here
        Arrays.sort(arr);
        String reversedArr[]= new String[n];
        reverse(arr, n, reversedArr);
        return solve(0, reversedArr, n-1);
    }
}
