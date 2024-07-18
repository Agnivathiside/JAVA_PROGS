//SOME ISSUE IN MEDIAN CALCUATION, OTHERWISE IT'S FINE !
import java.util.*;
public class median_of_marks_shit {
    public static void main(String[] args){
        Scanner SC=new Scanner(System.in);
        System.out.println("how many elements bitch!: ");
        int a=SC.nextInt();
        List<Integer> int_lis=new ArrayList<Integer>();
        for (int i=0;i<a;i++){
            System.out.println("Enter value: ");
            int_lis.add(SC.nextInt());
        }
        //System.out.println(int_lis);
        for (int i=0;i<int_lis.size();i++){
            for (int j=i+1;j<int_lis.size();j++){
                if (int_lis.get(j)>int_lis.get(i)){
                    int temp=int_lis.get(j);
                    int_lis.set(j, int_lis.get(i));
                    int_lis.set(i, temp);
                }
            }
        }
        System.out.println(int_lis);
        if (int_lis.size()%2==0){
            System.out.println("Here is your median-->"+ (int_lis.get(int_lis.size()/2-1) + int_lis.get(int_lis.size()/2))/2);

        }else if(int_lis.size()%2!=0){
            System.out.print("Here is your median-->"+ int_lis.get((int_lis.size()+1)/2));
        }
        SC.close();
    }
}
