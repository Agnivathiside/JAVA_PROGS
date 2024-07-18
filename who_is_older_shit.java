import java.util.*;
public class who_is_older_shit {
    public static void main(String[] args){
        Scanner SC=new Scanner(System.in);
        System.out.println("NAME 1: ");
        String name_1=SC.next();
        System.out.println("DATE 1: ");
        String date_1=SC.next();
        System.out.println("NAME 2: ");
        String name_2=SC.next();
        System.out.println("DATE 2: ");
        String date_2=SC.next();
        if (Integer.parseInt(date_2.substring(6,date_2.length()))!=Integer.parseInt(date_1.substring(6,date_1.length()))){
            if (Integer.parseInt(date_2.substring(6,date_2.length()))>Integer.parseInt(date_1.substring(6,date_1.length()))){
                System.out.println(name_2);

            }else{
                System.out.println(name_1);
            }

        }//THE REST OF THE CONCEPT IS SAME
        SC.close();
    }
}
