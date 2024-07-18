import java.util.*;

public class reverse_stack_rec_shit {
    public static void insert_at_bottom(Stack<Integer> st,int val){
        if(st.empty()){
            st.push(val);
            return;
        }
        int top=st.peek();
        st.pop();
        insert_at_bottom(st, val);
        st.push(top);
    }
    public static void reverse_stack(Stack<Integer> st){
        if(st.empty()) return;

        //store the top element
        int top=st.peek();

        //pop the top 
        st.pop();

        // let the recurrsion do it's job
        reverse_stack(st);

        // let's put the num back to the bottom
        insert_at_bottom(st,top);
    }
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the number of elements: ");
        int num=sc.nextInt();
        Stack<Integer> st=new Stack<>();
        for (int i=0;i<num;i++){
            st.push(sc.nextInt());
        }
        reverse_stack(st);
    }
}
