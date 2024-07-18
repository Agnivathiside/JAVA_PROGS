//{ Driver Code Starts
//Initial Template for Java



import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

// { 1, 3, 5, 5, 5, 5, 67, 123, 125 }
class GFG
{
    public static void solve(ArrayList<Integer> arl, int arr[], int n, int x, int s, int l){
        if(arr.length==0) return;

        int mid=arr[(s+l)/2];
        if(x>arr[mid]){
            solve(arl, arr, n, x, mid+1, l);
        }else if(x<arr[mid]){
            solve(arl, arr, n, x, s, mid-1);
        }else{
            arl.add(mid);
        }
    }
    ArrayList<Integer> find(int arr[], int n, int x)
    {
        // code here
        ArrayList<Integer> arl=new ArrayList<>();
        solve(arl, arr, n, x, 0, n-1);
        return arl;
    }
}



//{ Driver Code Starts.

// Driver class
class first_and_last_shit {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while (testcases-- > 0) {
//            int n = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] q = line.trim().split("\\s+");
            int n =Integer.parseInt(q[0]);
            int x =Integer.parseInt(q[1]);
//            //int y =Integer.parseInt(q[2]);
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(a1[i]);
            }
            GFG ob = new GFG();
            ArrayList<Integer> ans=ob.find(arr,n,x);
            System.out.println(ans.get(0)+" "+ans.get(1));
        }
    }
}

// } Driver Code Ends