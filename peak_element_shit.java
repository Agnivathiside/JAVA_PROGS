
//{ Driver Code Starts
import java.util.*;
import java.io.*;

public class peak_element_shit {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine().trim());
            int[] a = new int[n];
            int[] tmp = new int[n];
            String s[] = in.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(s[i]);
                tmp[i] = a[i];
            }

            int f = 0;
            int A = (new Solution()).peakElement(tmp, n);

            if (A < 0 && A >= n)
                out.println(0);
            else {
                if (n == 1 && A == 0)
                    f = 1;
                else if (A == 0 && a[0] >= a[1])
                    f = 1;
                else if (A == n - 1 && a[n - 1] >= a[n - 2])
                    f = 1;
                else if (A >= 0 && A < n && a[A] >= a[A + 1] && a[A] >= a[A - 1])
                    f = 1;
                else
                    f = 0;
                out.println(f);
            }
        }
        out.close();
    }
}
// } Driver Code Ends

/* Complete the function below */

class Solution {
    // Function to find the peak element
    // arr[]: input array
    // n: size of array a[]
    public int peakElement(int[] arr, int n) {
        // add code here.
        int start = 0;
        int end = n - 1;
        int mid=start+(end-start)/2;
        int ans = -1;

        while (start < end) {
            if (arr[mid]>arr[mid+1] && arr[mid]<arr[mid-1]){
                System.out.println("in the middle i have found something");
                ans=mid;
            }else if (arr[mid+1]>arr[mid]){
                System.out.println("in the right part");
                start=mid+1;
            }else if (arr[mid-1]>arr[mid]){
                System.out.println("in the left part");
                end=mid;
            }
            mid=start+(end-start)/2;
        }
        return ans;
    }
}