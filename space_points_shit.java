import java.util.*;
public class space_points_shit {
    public static void main(String[] args){
        Scanner SC=new Scanner(System.in);
        System.out.println("Enter the Absicca: ");
        float a=SC.nextFloat();
        System.out.println("Enter the ordinate: ");
        float b=SC.nextFloat();
        if(a>0 && b>0){
            System.out.println("First Quadrant");
        }else if(a<0 && b>0){
            System.out.println("Second Quadrant");
        }else if(a<0 && b<0){
            System.out.println("Third Quadrant");
        }else if(a>0 && b<0){
            System.out.println("Fourth Quadrant");
        }else if(a==0 && b==0){
            System.out.println("ORIGIN");
        }
        SC.close();
    }
    
}
