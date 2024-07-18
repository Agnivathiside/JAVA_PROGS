//import java.util.*;
import java.util.Scanner;
public class taking_printing_name_shit {
    public static void main(String[] args){
        Scanner SC=new Scanner(System.in);
        System.out.println("How many names?: ");
        int a=SC.nextInt();
        String[]names=new String[a];
        for (int i=0;i<a;i++){
            System.out.println("TYPE SOMETHING");
            names[i]=SC.next();//CAN'T USE nextLine() here!! why ?
        }
        for (int i=0;i<a;i++){
            System.out.println("NAME "+(i+1)+':'+names[i]);
        }
        SC.close();
    }
}
