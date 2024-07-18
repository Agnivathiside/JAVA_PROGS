// public class zero_sum_subarray_shit

//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

public class zero_sum_subarray_shit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            int n;
            n = sc.nextInt();

            long arr[] = new long[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextLong();
            }
            Solution ob = new Solution();
            System.out.println(ob.findSubarray(arr, n));
        }

    }
}

// } Driver Code Ends

// User function Template for Java

class Solution {
    // Function to count subarrays with sum equal to 0.
    public static long findSubarray(long[] arr, int n) {
        // Your code here
        HashMap<Integer, Integer> map = new HashMap<>();
        int curSum = 0;
        int count = 0;
        int start = -1;
        int end = -1;
        for (int i=0; i<n; i++){
            curSum += arr[i];

            if (curSum == 0){
                start = 0;
                end = i;
                count++;
                System.out.println("The sub array is from "+start+" to "+end+" and count is "+count);
            }

            if (map.containsKey(curSum)){
                start = map.get(curSum)+1;
                end = i;
                count++;
                System.out.println("The sub array is from "+start+" to "+end+" and count is "+count);
            }

            map.put(curSum, i);
        }
        return count;
    }
}