// public class maximize_arr_value_shit

//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class maximize_arr_value_shit {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            String line = in.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array)
                arr[idx++] = i;

            // int key = Integer.parseInt(in.readLine().trim());

            out.println(new Solution().Maximize(arr));
        }
        out.close();
    }
}
// } Driver Code Ends

// User function Template for Java

class Solution {
    int MOD = (int) Math.pow(10, 9)+7;
    int Maximize(int arr[]) {
        // Complete the function
        Arrays.sort(arr);
        int ans = 0;
        for(int i=0; i<arr.length; i++){
            ans += (arr[i]*i) % MOD;
        }
        return ans % MOD;
    }
}
