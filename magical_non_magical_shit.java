import java.util.*;
import java.util.Arrays;
public class magical_non_magical_shit {
    public static void main(String[] args){
        Scanner SC= new Scanner(System.in);
        System.out.println("How many strings?: ");
        int a=SC.nextInt();
        String arr[]=new String[a];
        for(int i=0;i<a;i++){
            System.out.println("STRING "+ (i+1)+":");
            String str=SC.next();
            arr[i]=str;
        }
        System.out.println(Arrays.toString(arr));
        Boolean flag=true;
        for (int i=0;i<arr.length-1;i++){
            if (arr[i+1].contains(arr[i])){
                continue;
            }else{
                flag=false;
                break;
            }
        }
        if(flag==true){
            System.out.println("magical");
        }else{
            System.out.println("not so magical");
        }
        SC.close();
    }  
}
