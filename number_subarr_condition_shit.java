// public class number_subarr_condition_shit

//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

public class number_subarr_condition_shit {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());

        while (testcases-- > 0) {

            String line1 = br.readLine();
            String[] element = line1.trim().split(" ");
            int n = Integer.parseInt(element[0]);
            int l = Integer.parseInt(element[1]);
            int r = Integer.parseInt(element[2]);

            int arr[] = new int[n];

            String line = br.readLine();
            String[] elements = line.trim().split(" ");

            for (int index = 0; index < n; index++) {
                arr[index] = Integer.parseInt(elements[index]);
            }

            Solution obj = new Solution();

            System.out.println(obj.countSubarrays(arr, n, l, r));

        }

    }
}

// } Driver Code Ends

// User function Template for Java

class Solution {

    static long countSubarrays(int arr[], int n, int L, int R) {
        // Complete the function
        long count = 0;
        int left = 0, right = 0; // Pointers for the sliding window
        long subarrays = 0; // Count of subarrays with maximum in the range [L, R]

        // Loop through the array using the sliding window technique
        while (right < n) {
            // Expand the window until the maximum element in the current window is within
            // the range [L, R]
            while (right < n && (arr[right] < L || arr[right] > R)) {
                if (arr[right] > R) {
                    left = right + 1; // Move the left pointer to the next element after the element greater than R
                }
                right++; // Move the right pointer to the next element
            }

            // Count the subarrays with maximum in the range [L, R] ending at the current
            // right pointer
            System.out.println("the sub array is from index "+left+" to "+right);
            subarrays += right - left + 1;

            // Move the left pointer to the next element to start a new window
            left++;
            // Move the right pointer to the next element
            right++;
        }

        return subarrays;
    }
}
