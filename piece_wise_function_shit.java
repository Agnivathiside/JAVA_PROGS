import java.util.*;
public class piece_wise_function_shit {
    public static void main(String[] args){
        Scanner SC=new Scanner(System.in);
        System.out.println("Enter the number: ");
        float a =SC.nextFloat();
        if(0<a && a<10){
            System.out.println(a+2);
        }else if(10<=a){
            System.out.println(Math.pow(a, 2)+2);
        }else{
            System.out.println(0);
        }
        SC.close();
    }
}
