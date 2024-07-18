import java.util.*;
public class wierd_meeting_shit {
    public static void main(String[] args){
        Scanner SC=new Scanner(System.in);
        System.out.println("kitne aadmi the?: ");
        int a=SC.nextInt();
        int arr[]=new int[a];
        for (int i=0;i<arr.length;i++){
            System.out.print("ELEMENT "+(i+1)+": ");
            arr[i]=SC.nextInt();
        }
        Boolean flag =true;
        if (arr[0]%2==0){
            for (int i=1;i<arr.length;i++){
                if(arr[i]%2==0){
                    continue;
                }else{
                    flag = false;
                    break;
                }
            }
        }else if(arr[0]%2!=0){
            for (int i=1;i<arr.length;i++){
                if(arr[i]%2!=0){
                    continue;
                }else{
                    flag =false;
                    break;
                }
            }
        }
        if(flag==true){
            System.out.println("chalega! ");
        }else{
            System.out.println("bhaag bhsdk meeting nhi hoga!");
        }
        SC.close();
    }
}
