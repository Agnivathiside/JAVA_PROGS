
//public class first_last_occurence_shit
//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

// } Driver Code Ends
//User function Template for Java

class GFG {

    public static int findFisrtIndex(int arr[], int n, int x){
        int start=0;
        int end=n-1;

        int mid=start+(end-start)/2;
        int ans=-1;
        while (start<=end){
            if (x==arr[mid]){    
                ans=mid;
                end=mid-1;

            }else if(x>arr[mid]){
                start=mid+1;

            }else{
                end=mid-1;

            }
            mid=start+(end-start)/2;
        }
        return ans;

    }
    public static int findLastIndex(int arr[], int n, int x){
        int start=0;
        int end=n-1;

        int mid=start+(end-start)/2;
        int ans=-1;
        while (start<=end){
            if (x==arr[mid]){    
                ans=mid;
                start=mid+1;

            }else if(x>arr[mid]){
                start=mid+1;

            }else{
                end=mid-1;

            }
            mid=start+(end-start)/2;
        }
        return ans;

    }

    ArrayList<Integer> find(int arr[], int n, int x) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        int firstIndex = findFisrtIndex(arr, n, x);
        int lastIndex = findLastIndex(arr, n, x);

        System.out.println("First index is "+firstIndex);
        System.out.println("Last index is "+lastIndex);

        if (firstIndex == -1 || lastIndex == -1) {
            ans.add(-1);
            return ans;
        }

        ans.add(firstIndex);
        ans.add(lastIndex);
        return ans;

    }
}

// { Driver Code Starts.

// Driver class
public class first_last_occurence_shit {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while (testcases-- > 0) {
            // int n = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] q = line.trim().split("\\s+");
            int n = Integer.parseInt(q[0]);
            int x = Integer.parseInt(q[1]);
            // //int y =Integer.parseInt(q[2]);
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(a1[i]);
            }
            GFG ob = new GFG();
            ArrayList<Integer> ans = ob.find(arr, n, x);
            System.out.println(ans.get(0) + " " + ans.get(1));
        }
    }
}

// } Driver Code Ends
