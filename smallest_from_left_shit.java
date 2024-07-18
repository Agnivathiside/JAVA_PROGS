//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;
import java.lang.*;

class smallest_from_left_shit{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(in.readLine());
            String a1[] = in.readLine().trim().split("\\s+");
            int a[] = new int[n];
            for(int i = 0;i < n;i++)
                a[i] = Integer.parseInt(a1[i]);
            Solution ob = new Solution();
            List<Integer> ans = new ArrayList<Integer>();
            ans = ob.leftSmaller(n, a);
            for(int i = 0;i < n;i++)
                System.out.print(ans.get(i)+" ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution{
    static List<Integer> leftSmaller(int n, int a[])
    {
        //code here
        // 1, 5, 0, 3, 4, 5
        // -1, 1, -1, 0, 3, 4
        if (a.length==0){
            return null;
        }
        Stack<Integer> s= new Stack<>();
        List<Integer> lis= new ArrayList<>();
        for (int i=0;i<a.length;i++){
            if (s.empty()){
                lis.add(-1);
            }else if(!s.empty() && s.peek()<a[i]){
                lis.add(s.peek());
            }else{
                while (!s.empty() && s.peek()>a[i]){
                    s.pop();
                }
                if (!s.empty()){
                    lis.add(s.peek());
                }else{
                    lis.add(-1);
                }
            }
            s.push(a[i]);
        }
        return lis;
    }
}