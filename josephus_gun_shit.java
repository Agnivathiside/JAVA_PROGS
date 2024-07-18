import java.util.*;
public class josephus_gun_shit {
    public static int josephus(int a, int b){
        if (a==1){
            return 0;
        }
        return ((josephus(a-1, b)+b)%a);
    }
    public static void main(String[] args){
        Scanner SC= new Scanner(System.in);
        System.out.print("Enter the number of people: ");
        int a=SC.nextInt();
        System.out.print("Enter the interval: ");
        int b=SC.nextInt();
        System.out.print("Person at index "+josephus(a, b)+" will be alive at the end");
        SC.close();
    }
}
