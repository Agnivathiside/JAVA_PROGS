// public class sum_close_to_zero_shit

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class sum_close_to_zero_shit{
    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine().trim());

        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine().trim());
            int[] arr = new int[n];
            String s[] = in.readLine().trim().split(" ");
            for (int i = 0; i < n; ++i)
                arr[i] = Integer.parseInt(s[i]);

            out.println(new Solution().closestToZero(arr, n));
        }
        out.close();

    }
}

// } Driver Code Ends

// User function Template for Java

class Solution {
    public static int closestToZero(int arr[], int n) {
        // your code here
        Arrays.sort(arr);
        int left = 0;
        int right = n-1;
        int ans1 = Integer.MIN_VALUE;
        int ans2 = Integer.MAX_VALUE;
        while(left<right){
            int sum = arr[left] + arr[right];
            if (sum==0) return 0;
            if (sum<0){
                ans1 = Math.max(ans1, sum);
                left++;
            }else{
                ans2 = Math.min(ans2, sum);
                right--;
            }
        }
        if (ans1==Integer.MIN_VALUE && ans2!=Integer.MAX_VALUE) return ans2;
        if (ans2==Integer.MAX_VALUE && ans1!=Integer.MIN_VALUE) return ans1;
        
        if (Math.abs(ans1)<Math.abs(ans2)) return ans1;
        if (Math.abs(ans1)>Math.abs(ans2)) return ans2;

        return Math.max(ans1, ans2);
    }
}
