// public class sub_array_sum_K_shit

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class sub_array_sum_K_shit{
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int Arr[] = new int[N];
            for (int i = 0; i < N; i++)
                Arr[i] = Integer.parseInt(input_line[i]);
            int k = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.findSubArraySum(Arr, N, k));
        }
    }
}
// } Driver Code Ends

// User function Template for Java

class Solution {
    static int findSubArraySum(int arr[], int N, int k) {
        int count = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // Add 0 to the hashmap with frequency 1 to handle subarrays starting from index 0
        map.put(0, 1);
        
        for (int i = 0; i < arr.length; i++) {
            // Update the current sum
            sum += arr[i];
            
            // Check if (sum - k) has been encountered before, if yes, update the count
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            
            // Update the frequency of the current sum in the hashmap
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        
        return count;
    }
}