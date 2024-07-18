import java.util.*;
public class divide_n_gold_shit {
    public static void main(String[] args){
        Scanner SC=new Scanner(System.in);
        System.out.println("Enter the total number of coins: ");
        int a =SC.nextInt();
        int arr[]=new int[3];
        for (int i=0;i<3;i++){
            System.out.println("Enter "+"share "+(i+1)+":");
            arr[i]=SC.nextInt();
        }
        if(arr[0]!=0 && arr[1]!=0 && arr[2]!=0 && ((arr[0]+arr[1]+arr[2])==a)){
            System.out.println("Chalega");
        }else{
            System.out.println("Nhi Chalega");
        }
        SC.close();
    }
}
