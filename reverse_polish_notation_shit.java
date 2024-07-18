import java.util.*;

public class reverse_polish_notation_shit {
	public static int eval(String[] tokens)
	{
        // System.out.println("Here in the called function");
		Stack<Integer> st= new Stack<>();
        int arr_len=tokens.length;
        for (int i=0;i<arr_len;i++){
            if (tokens[i]=="+" || tokens[i]=="-" || tokens[i]=="*" || tokens[i]=="/"){
                // System.out.println("Here in the sign section");
                int first=st.pop();
                int second=st.pop();
                if (tokens[i]=="+"){
                    int res=first+second;
                    // System.out.println("Adding "+ res+" to the stack");
                    st.push(res);
                }else if(tokens[i]=="-"){
                    int res=second-first;
                    // System.out.println("Adding "+ res+" to the stack");
                    st.push(res);
                }else if(tokens[i]=="*"){
                    int res=first*second;
                    // System.out.println("Adding "+ res+" to the stack");    
                    st.push(res);
                }else{
                    int res=second/first;
                    // System.out.println("Adding "+ res+" to the stack");        
                    st.push(res);
                }
            }else{
                // System.out.println("Adding "+Integer.valueOf(tokens[i])+ " to the stack");
                st.push(Integer.valueOf(tokens[i]));
            }
        }
        return st.peek();
	}

	public static void main(String[] args)
	{

		String[] tokens
			= {"4","13","5","/","+"};

		int res = eval(tokens);
		System.out.println(
			"Value of given expression '10 6 9 3 + -11 * / * 17 + 5 +' = "
			+ res);
	}
}
// this code is contributed by Ravi Singh
