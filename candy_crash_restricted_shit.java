import java.util.Stack;

public class candy_crash_restricted_shit{
    public static String reduced_String(int k, String s)
    {
        // Your code goes here
        Stack<Character> st =new Stack<>();
        Stack<Character> st1 =new Stack<>();
        int count=1;
        String output="";
        for (int i=0;i<s.length();i++){
            if (st.empty()){
                st.push(s.charAt(i));
            }else if(!st.empty() && s.charAt(i)==st.peek()){ // geegesforgeeeks
                //count++;
                System.out.println("current character "+s.charAt(i));
                System.out.println("stack character "+st.peek());
                System.out.println("count of "+s.charAt(i)+" is "+count);
                count++;
                System.out.println("now count is "+count);
                if (count==k){
                    System.out.println("time to pop items");
                    while (count>1){
                        st.pop();
                        count--;
                    }
                    //count=1;
                }
            }else if(!st.empty() && s.charAt(i)!=st.peek()){
                System.out.println("Stack character "+st.peek());
                System.out.println("current character "+s.charAt(i));
                st.push(s.charAt(i));
                count=1;
            }
        }
        while (!st.empty()){
            st1.push(st.pop());
        }
        while (!st1.empty()){
            output+=st1.pop();
        }
        return output;
    }
    public static void main(String[] args){
        String s= "geegsforgeeks";
        int k=3;
        //reduced_String(k, s);
        System.out.println(reduced_String(k, s));
    }
}