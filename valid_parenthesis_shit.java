//{ Driver Code Starts
    import java.util.*;
    import java.io.*;
    import java.lang.*;
    
    class valid_parenthesis_shit
    {
        public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            
            //Reading total number of testcases
            int t= sc.nextInt();
            
            while(t-- >0)
            {
                //reading the string
                String st = sc.next();
                
                //calling ispar method of Paranthesis class 
                //and printing "balanced" if it returns true
                //else printing "not balanced"
                if(new Solution().ispar(st) == true)
                    System.out.println("balanced");
                else
                    System.out.println("not balanced");
            
            }
        }
    }
    // } Driver Code Ends
    
    
    
    class Solution
    {
        static boolean is_matching(Character a, Character b){
            if (a=='(' && b==')'){
                return true;
            }else if(a=='{' && b=='}'){
                return true;
            }else if(a=='[' && b==']'){
                return true;
            }
            return false;
        }
        //Function to check if brackets are balanced or not.
        static boolean ispar(String x)
        {
            Stack<Character> st=new Stack<>();
            int str_len=x.length();
            if (str_len%2!=0) return false;
            for (int i=0;i<str_len;i++){
                if(st.empty()){
                    st.push(x.charAt(i));
                }else if (is_matching(st.peek(),x.charAt(i)))/*check if they are matching*/{
                    st.pop();
                }else{
                    st.push(x.charAt(i));
                }
            }
            if (st.empty()) return true;
            return false;

        }
    }
    