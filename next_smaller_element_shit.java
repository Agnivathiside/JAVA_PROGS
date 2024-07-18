import java.util.*;
import java.io.*;

public class next_smaller_element_shit{
    public static ArrayList<Integer> nextSmallerElement(ArrayList<Integer> arr, int n){
        Stack<Integer> st=new Stack<>();
        ArrayList<Integer> arl=new ArrayList<>();
        //Collections.reverse(Arrays.asList(arr));
        for (int i=n-1;i>-1;i--){
            if (st.empty()){
                st.push(arr.get(i));
                arl.add(-1);
            }else if(arr.get(i)>st.peek()){
                arl.add(st.pop());
                st.push(arr.get(i));
            }else{
                st.push(arr.get(i));
                arl.add(-1);
            }
        }
        Collections.reverse(Arrays.asList(arl));
        return arl;
    }
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        ArrayList<Integer> arl=new ArrayList<>();
        System.out.println("Enter number of array elements: ");
        int count=sc.nextInt();
        for(int i=0;i<count;i++){
            arl.add(sc.nextInt());
        }
        ArrayList<Integer> arl_out=nextSmallerElement(arl,count);
        System.out.println(arl_out);
        sc.close();
    }
}