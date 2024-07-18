import java.util.*;
public class same_Bday_pair_shit {
    public static void main(String[] args){
        Scanner SC=new Scanner(System.in);
        System.out.println("How many names?: ");
        int a=SC.nextInt();
        String[] name_arr=new String[a];
        Integer[] date_arr=new Integer[a];
        //String[] date_arr=new String[a];
         for (int i=0;i<a;i++){
             System.out.print("Enter the name--> ");
             name_arr[i]=SC.next();
             System.out.print("Enter the day no--> ");
             date_arr[i]=SC.nextInt();
        }
        /*System.out.println("Enter the names with comma in between--> ");
        String name_str=SC.next();
        name_arr=name_str.split(",");
        System.out.println("\nEnter the day numbers with comma in between-->  ");
        String date_str=SC.next();
        date_arr=date_str.split(",");--> THIS SHIT IS NOT WORKING IDK WHY, HAVE NO ENERGY TO FIND*/
        for (int x=0;x<a;x++){
            for (int y=x+1;y<a;y++){
                if (date_arr[x]==date_arr[y]){
                    System.out.println("pair--> "+name_arr[x]+" "+name_arr[y]);
                }
            }
        }
        SC.close();
    }
}
