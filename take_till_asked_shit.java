import java.util.*;
public class take_till_asked_shit {
    public static void main(String[] args){
        Scanner SC=new Scanner(System.in);
        List<String> l1 = new ArrayList<String>();
        System.out.println("Enter how many words: ");
        int a=SC.nextInt();
        for (int i=0;i<a;i++){
            String sc=SC.next();
            l1.add(sc);
        }
        System.out.println(l1);
        SC.close();
    }
}
