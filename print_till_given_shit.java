import java.util.*;
public class print_till_given_shit {
    public static void main(String[] args){
        Scanner SC=new Scanner(System.in);
        System.out.println("Enter the limit: ");
        int a=SC.nextInt();
        List<Integer> l1 = new ArrayList<Integer>();
        for (int i=0;i<a;i++){
            l1.add(i);
        }
        System.out.println(l1);
        SC.close();
    }
}
