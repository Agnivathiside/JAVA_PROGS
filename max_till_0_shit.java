import java.util.*;
public class max_till_0_shit {
    public static void main(String[] args){
        Scanner SC=new Scanner(System.in);
        System.out.println("Start entering number: ");
        int a=SC.nextInt();
        List<Integer> l1 = new ArrayList<Integer>();
        while (a!=0 ){
            System.out.println("NUMBER: ");
            int i=SC.nextInt();
            if (i==0){
                break;
            }
            l1.add(i);
        }
        System.out.println(Collections.max(l1));
        SC.close();
    }
}
