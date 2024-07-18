
//minimum_num_arr_shit
//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

public class minimum_num_arr_shit {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            String st[] = read.readLine().trim().split("\\s+");

            int arr[] = new int[n];

            for (int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(st[i]);

            System.out.println(new Solution().minNumber(arr, 0, n - 1));
        }
    }

}
// } Driver Code Ends

class Solution {
    // Function to find the minimum element in sorted and rotated array.
    static int minNumber(int arr[], int low, int high) {
        // Your code here
        int mid = low + (high - low) / 2;

        while (low < high) {
            if (arr[mid] >= arr[0]) {
                low = mid + 1;
            } else {
                high = mid;
            }
            mid = low + (high - low) / 2;
        }
        return low;
    }
}
