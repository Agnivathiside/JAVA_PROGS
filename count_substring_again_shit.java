// public class count_substring_again_shit 

//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class count_substring_again_shit {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            //br.readLine();
            String s;
            s = br.readLine();
            
            Solution obj = new Solution();
            int res = obj.countSubstring(s);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int countSubstring(String s) {
        // code here
        int count[] = {0, 0, 0};
        int res = 0, i = 0;
        
        for(int j=0; j<s.length(); j++){
            count[s.charAt(j) - 'a']++;
            while(count[0]>0 && count[1]>0 && count[2]>0){
                count[s.charAt(i) - 'a']--;
                i++;
            }
            res+=i;
        }
        return res;
    }
}
        

