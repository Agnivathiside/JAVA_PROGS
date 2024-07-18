import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class list_shit {
    public static void main(String[] args){
        Scanner SC=new Scanner(System.in);
        List<Integer> l1 = new ArrayList<Integer>();
        //System.out.println("How many elements?: " );
        //int a=SC.nextInt();
        // for (int i=0;i<a;i++){
        //     System.out.print("ELEMENT "+(i+1)+" : ");
        //     int b=SC.nextInt();
        //     l1.add(b);
        // }
        // System.out.println(l1);
        for (int i=0;i<1001;i++){
            l1.add(i);
        }
        for (int i=1000;i>-1;i--){
            l1.add(i);
        }
        //System.out.println(l1);
        Boolean flag=l1.contains(1000);
        System.out.println(flag);
        System.out.println(l1.get(5));
        SC.close();
    }
    
}
