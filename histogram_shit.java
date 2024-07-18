// import java.util.Stack;

// public class histogram_shit {
//     private int[] nextSmaller(int[] arr, int n) {
//         Stack<Integer> st = new Stack<>();
//         st.add(-1);
//         int ans[] = new int[n];

//         for (int i=n; i>=0; i--){
//             int curr = arr[i];

//             while (st.peek()!=-1 && arr[st.peek()]>=curr){
//                 st.pop();
//             }
//             ans[i]=st.peek();
//             st.add(i);
//         }
//         return ans;
//     }
//     private int[] prevSmaller(int arr[], int n){
//         Stack<Integer> st = new Stack<>();
//         st.add(-1);
//         int ans[] = new int[n];

//         for (int i=0; i<n; i++){
//             int curr = arr[i];

//             while (st.peek()!=-1 && arr[st.peek()]>=curr){
//                 st.pop();
//             }
//             ans[i]=st.peek();
//             st.add(i);
//         }
//         return ans;
//     }

//     public int largestRectangleArea(int[] heights) {
//         int n = heights.length;

//         int next[] = new int[n];
//         next = nextSmaller(heights, n);

//         int prev[] = new int[n];
//         prev = prevSmaller(heights, n);

//         int area = Integer.MIN_VALUE;

//         for (int i=0; i<n; i++){
//             int l = heights[i];
//             if (next[i]==-1){
//                 next[i]=n;
//             }
//             int b = next[i] - prev[i]-1;

//             int newArea = l*b;
//             area = Math.max(area, newArea);
//         }
//         return area;
//     }
// }

//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            long n = Long.parseLong(br.readLine().trim());
            String inputLine[] = br.readLine().trim().split(" ");
            long[] arr = new long[(int) n];
            for (int i = 0; i < n; i++)
                arr[i] = Long.parseLong(inputLine[i]);
            System.out.println(new Solution().getMaxArea(arr, n));
        }
    }
}

// } Driver Code Ends

class Solution {
    private static long[] nextSmaller(long[] hist, long n) {
        Stack<Long> st = new Stack<>();
        st.add(-1);
    }
    
    public static long getMaxArea(long hist[], long n) {
        long next[] = new long[(int) n];
        next = nextSmaller(hist, n);
        
        long prev[] = new long[(int) n];
        prev = prevSmaller(hist, n);

        long area = Long.MIN_VALUE;

        for (long i=0; i<n; i++){
            long l = hist[(int)i];
            long b = next[(int)i] - prev[(int)i] -1;

            if (next[(int)i]==-1){
                next[(int)i] = n;
            }

            long newArea = l*b;
            area = Math.max(area, newArea);

        }
        return area;
    }

    

}
