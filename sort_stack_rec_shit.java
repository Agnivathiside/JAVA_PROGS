import java.util.* ;
import java.io.*; 
public class sort_stack_rec_shit {
    public static void sortedinsertion(Stack<Integer> st, int val){
        if ((st.empty())|| (!st.empty()&&st.peek()<val)){
            st.push(val);
            return;
        }
        int top=st.peek();
        st.pop();
        sortedinsertion(st, val);
        st.push(top);
    }
    public static void sortStack(Stack<Integer> st) {
        if (st.empty()) return;
        int top=st.peek();
        st.pop();
        sortStack(st);
        sortedinsertion(st,top);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements of the stack: ");
        int num=sc.nextInt();
        Stack<Integer> st= new Stack<>();
        for (int i=0;i<num;i++){
            st.push(sc.nextInt());
        }
        sortStack(st);
        System.out.println(st);
        sc.close(); 
    }
}