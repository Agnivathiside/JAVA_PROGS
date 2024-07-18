// public class job_searching_shit

//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Job {
    int id, profit, deadline;

    Job(int x, int y, int z) {
        this.id = x;
        this.deadline = y;
        this.profit = z;
    }
}

public class job_searching_shit {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // testcases
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");

            // size of array
            int n = Integer.parseInt(inputLine[0]);
            Job[] arr = new Job[n];
            inputLine = br.readLine().trim().split(" ");

            // adding id, deadline, profit
            for (int i = 0, k = 0; i < n; i++) {
                arr[i] = new Job(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]),
                        Integer.parseInt(inputLine[k++]));
            }

            Solution ob = new Solution();

            // function call
            int[] res = ob.JobScheduling(arr, n);
            System.out.println(res[0] + " " + res[1]);
        }
    }
}
// } Driver Code Ends

// class Solution {
//     // Function to find the maximum profit and the number of jobs done.
//     int[] solve(Job arr[], int index, int n, int count){
//         if (index>n){
//             int fuck[]=new int[2];
//             fuck[0]=0;
//             fuck[1]=0;
//             return fuck;
//         }

//         int include=0;
//         int exclude=0;

//         if (arr[index].deadline!=arr[index+1].deadline){
//             include = arr[index].profit+solve(arr, index+1, n, count+1)[1];
//             exclude = solve(arr, index+1, n, count)[1];
//         }else{
//             return solve(arr, index+1, include, count);
//         }
//         int ans[]= new int[2];
//         ans[0]=count;
//         ans[1]=Math.max(include, exclude);
//         return ans;

//     }
//     int[] JobScheduling(Job arr[], int n) {
//         // Your code here
//         return solve(arr, 0, n, 0);
//     }
// }

class Solution {
    class Result {
        int count;
        int profit;
        
        Result(int count, int profit) {
            this.count = count;
            this.profit = profit;
        }
    }
    
    Result solve(Job arr[], int index, int n, int currentTime) {
        // Base case: If index reaches the end or currentTime exceeds the last deadline
        if (index >= n || currentTime > arr[n - 1].deadline)
            return new Result(0, 0);
        
        // If including the current job
        Result include = new Result(0, 0);
        if (arr[index].deadline >= currentTime + 1) {
            include = solve(arr, index + 1, n, currentTime + 1);
            include.profit += arr[index].profit;
            include.count++;
        }
        
        // If excluding the current job
        Result exclude = solve(arr, index + 1, n, currentTime);
        
        // Return the result with maximum profit
        if (include.profit > exclude.profit)
            return include;
        else
            return exclude;
    }
    
    int[] JobScheduling(Job arr[], int n) {
        // Sort the jobs based on deadline
        Arrays.sort(arr, (a, b) -> a.deadline - b.deadline);
        
        // Call the recursive function to find the maximum profit and count
        Result result = solve(arr, 0, n, 0);
        
        // Return the count and maximum profit
        return new int[] { result.count, result.profit };
    }
}



/*
 * class Job {
 * int id, profit, deadline;
 * Job(int x, int y, int z){
 * this.id = x;
 * this.deadline = y;
 * this.profit = z;
 * }
 * }
 */