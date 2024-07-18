// public class min_steps_destination_shit

//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class min_steps_destination_shit{
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int d = Integer.parseInt(in.readLine());

            Solution ob = new Solution();
            System.out.println(ob.minSteps(d));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// class Solution {
//     static int solve(int d, int sum, int i){
//         if(sum==d) return 1;
//         if (sum>d) return 0;

//         int positive = 1 + solve(d, sum+i, i+1);
//         int negative = 1 + solve(d, sum-i, i+1);

//         return Math.min(positive, negative);
//     }
//     static int minSteps(int d) {
//         // code here
//         return solve(d, 0, 1);
//     }
// }
class Solution {
    static int minSteps(int d) {
        // code here
        return solve(d, 0, 0, 1);
    }
    
    static int solve(int d, int sum, int steps, int i) {
        // Base case: if the sum equals or exceeds the destination
        if (sum >= d) return steps;
        
        // Recursive cases: move either to the right or to the left
        int positive = solve(d, sum + i, steps + 1, i + 1); // Move to the right
        int negative = solve(d, sum - i, steps + 1, i + 1); // Move to the left

        // Return the minimum number of steps
        return Math.min(positive, negative);
    }
}
