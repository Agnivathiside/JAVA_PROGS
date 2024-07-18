import java.util.*;
public class reverse_str_use_stack_shit {
    public static void print_Stack(Stack<Character> st){
        // for (int i=0;i<st.size();i++){
        //     System.out.println(st.peek());
        // }
        System.out.println(st);
    }
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        String str_out="";
        System.out.println("Enter the input string");
        String str=sc.next();
        Stack<Character> st= new Stack<>();
        for (int i=0;i<str.length();i++){
            st.add(str.charAt(i));
        }
        print_Stack(st);
        for (int j=0;j<str.length();j++){
            str_out=str_out+String.valueOf(st.peek());
            //System.out.println("before popping "+st);
            st.pop();
            //System.out.println("after pospping "+st);
            //System.out.println("count is "+j+ "and size is "+st.size());
        }
        System.out.println("Final string is "+ str_out);
        sc.close();
    }
}
