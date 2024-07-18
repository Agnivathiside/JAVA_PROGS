import java.util.*;
public class max_val_shit {
    public static Integer max_val(Integer arr[]){
        int max=0;
        for (int i=0;i<arr.length;i++){
            if (arr[i]>max){
                max=arr[i];
            }
        }
        return max;
    }
    public static void main(String[] args){
        Scanner SC=new Scanner(System.in);
        System.out.println("How many numbers: ");
        int a=SC.nextInt();
        Integer[] num_arr=new Integer[a];
        for (int i=0;i<a;i++){
            num_arr[i]=SC.nextInt();
        }
        System.out.println("The the greatest number is--> "+ max_val(num_arr));
        SC.close();


    }
}
