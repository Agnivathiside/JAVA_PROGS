import java.util.*;
public class talking_tom_time {
    public static void main(String[] args){
        Scanner SC=new Scanner(System.in);
        System.out.println("Enter your time:");
        int a=SC.nextInt();
        if (a<0){
            System.out.println("INVALID");
        }else if(0<= a && a<=5){
            System.out.println("NIGHT");
        }else if(6<= a && a<=11){
            System.out.println("MORNING");
        }else if(12<=a && a<=17){
            System.out.println("AFTERNOON");
        }else if(18<=a && a<=23){
            System.out.println("EVENING");
        }else{
            System.out.println("INVALID");
        }
        SC.close();
    }
    
}
