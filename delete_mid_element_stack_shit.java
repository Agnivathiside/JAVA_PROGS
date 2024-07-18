import java.util.*;
public class delete_mid_element_stack_shit {
    public static void deleteMid(Stack<Integer> st, int size){
        int kick_point=((size+1)/2)-1;
        Stack<Integer> temp_st= new Stack<>();
        for(int i=0;i<size;i++){
            if (i==kick_point){
                st.pop();
                //System.out.println("item popped");
            }else{
                System.out.println(i);
                temp_st.push(st.pop());
                // System.out.println("Temp stack is "+temp_st);
                // System.out.println("actual stack is "+st);
            }

        }
        int temp_size=temp_st.size();
        for (int j=0;j<temp_size;j++){
            st.push(temp_st.pop());
        }
            //System.out.println(st);

    } 
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the number of elements: ");
        int count=sc.nextInt();
        Stack<Integer> st= new Stack<>();
        for (int i=0;i<count;i++){
            System.out.println("push baby");
            st.push(sc.nextInt());
        }
        System.out.println("Before deletion "+st);
        deleteMid(st, st.size());
        System.out.println("after deletion "+st);

        sc.close();
    }
}
