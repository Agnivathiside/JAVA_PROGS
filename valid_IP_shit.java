// public class valid_IP_shit

//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.util.*;
import java.io.*;

public class valid_IP_shit {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            String s = sc.next();
            Solution obj = new Solution();

            if (obj.isValid(s))
                System.out.println(1);
            else
                System.out.println(0);
        }
    }
}
// } Driver Code Ends

// User function Template for Java

class Solution {
    public void print(String str[]){
        System.out.println("it came here and length of thr string array is "+str.length);
        for(String st:str){
            System.out.println(st);
            System.out.println("here too");
        }
    }

    public boolean isValid(String s) {
        // Write your code here
        String str[]=s.split(".");
        print(str);
        for (String st:str){
            if ((Integer.parseInt(st)<=255) && (Integer.parseInt(st)>=0)){
                continue;
            }else{
                return false;
            }
        }
        return true;
    }
}
