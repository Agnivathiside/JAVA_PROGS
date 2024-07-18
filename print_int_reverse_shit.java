import java.util.*;
public class print_int_reverse_shit {
    public static void main(String[] args){
        Scanner SC=new Scanner(System.in);
        String[] Arr_str=new String[10];
        System.out.println("Enter the words in comma in between");
        String str=SC.next();
        Arr_str=str.split(",");
        for (int i=Arr_str.length-1;i>=0;i--){
            System.out.print(Arr_str[i]+" ");
        }
        SC.close();

    }
}
