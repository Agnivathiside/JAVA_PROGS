import java.util.*;
public class print_the_max_shit {
    public static void main(String[] args){
        Scanner SC=new Scanner(System.in);
        String[] Arr_str=new String[3];//AGAIN GHOST ARRAY ?!
        System.out.print("Enter the sequence of numbers with comman in between: ");
        String str=SC.nextLine();
        Arr_str=str.split(",");
        int max=0;
        for (int i=0;i<Arr_str.length;i++){
            if(Integer.parseInt(Arr_str[i])>max){
                max=Integer.parseInt(Arr_str[i]);
            }
        }
        System.out.println(max);
        SC.close();
    }
}
