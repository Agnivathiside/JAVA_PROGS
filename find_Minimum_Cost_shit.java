import java.util.* ;
import java.io.*; 
public class find_Minimum_Cost_shit {
    public static boolean is_matching(Character a, Character b){
        if (a=='{' && b=='}') return true;
        return false;
    }
    public static int findMinimumCost(String str){
        Stack<Character> st= new Stack<>();
        int str_len=str.length();
        for (int i=0;i<str_len;i++){
            if (st.empty()){
                st.push(str.charAt(i));
            }else if(!st.empty() && is_matching(st.peek(),str.charAt(i))){
                st.pop();
            }else{
                st.push(str.charAt(i));
            }
        }
        System.out.println(st);
        int a=0,b=0;
        while (!st.empty()){
            if (st.peek()=='{'){
                a++;
            }else{
                b++;
            }
        }
        return (a+1)/2 + (b+1)/2;
        // if (st.size()%2!=0){
        //     return -1;
        // }else if (!st.empty() && st.peek()=='{' && st.get(1)=='}'){
        //     st.pop();
        //     st.pop();
        //     return st.size()/2+2;
        //     // if (st.peek()=='}'){
        //     //     st.pop();
        //     //     return (st.size()/2)+2;
        //     // }
        // }
        // //System.out.println("bc direct yha kiyu !?");
        // //System.out.println("stack size is"+st.size());
        // return st.size()/2;
    }
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the number of tes cases: ");
        int t=sc.nextInt();
        while (t>0){
            //System.out.println("Emter the input string: ");
            String str=sc.next();
            int minimum_cost=findMinimumCost(str);
            System.out.println("Minimum cost is "+minimum_cost);
            sc.close();
            t--;
        }
    }
}
// {}{}{}