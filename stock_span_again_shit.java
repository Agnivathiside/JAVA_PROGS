// public class stock_span_again_shit

//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

public class stock_span_again_shit {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];

            int i = 0;
            for (i = 0; i < n; i++)
                a[i] = sc.nextInt();

            int[] s = new Solution().calculateSpan(a, n);

            for (i = 0; i < n; i++) {
                System.out.print(s[i] + " ");
            }

            System.out.println();
        }
    }

}
// } Driver Code Ends

class Solution {
    // Function to calculate the span of stockâ€™s price for all n days.
    public static int[] calculateSpan(int price[], int n) {
        // Your code here
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();

        st1.add(price[0]);
        int ans[] = new int[n];
        ans[0]=1;

        for (int i=1; i<n; i++){
            if (price[i]<st1.peek()){
                st1.add(price[i]);
                ans[i]=1;
                // System.out.println("here1 "+ans[i]);
            }else{
                while(!st1.isEmpty() && price[i]>=st1.peek()){
                    st2.add(st1.pop());
                }
                ans[i]=st2.size()+1;
                // System.out.println("here2 "+ ans[i]);
                while(!st2.isEmpty()){
                    st1.add(st2.pop());
                }
                st1.add(price[i]);
            }
        }
        return ans;
    }

}