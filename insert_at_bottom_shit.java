import java.util.*;
import java.io.*;

public class insert_at_bottom_shit {
    public static Stack<Integer> pushAtBottom(Stack<Integer> myStack, int x)
	{
		// Base Case
		if (myStack.empty())
		{
			myStack.push(x);
			return myStack;
		}

		// Store top element in 'num'
		int num = myStack.peek();

		// Pop the top element
		myStack.pop();

		// Recursive call
		pushAtBottom(myStack, x);

		// Add 'num' to stack
		myStack.push(num);

		return myStack;
	}
    // public static Stack<Integer> pushAtBottom(Stack<Integer> myStack, int x) {
    //     // Write your code here
    //     Stack<Integer> st = new Stack<>();
    //     int myStack_size=myStack.size();
    //     for (int i = 0; i < myStack_size; i++) {
    //         st.push(myStack.pop());
    //     }
    //     myStack.push(x);
    //     int st_size=st.size();
    //     for (int i=0;i<st_size;i++){
    //         myStack.push(st.pop());
    //     }
    //     return myStack;

    // }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the stack: ");
        int num=sc.nextInt();
        Stack<Integer> st= new Stack<>();
        for (int i=0;i<num;i++){
            st.push(sc.nextInt());
        }
        System.out.println("Enter the number to be inserted: ");
        int num_ins=sc.nextInt();
        Stack<Integer> st_out=pushAtBottom(st, num_ins);
        System.out.println(st_out);
        sc.close();
    }

}
