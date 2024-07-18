import java.util.*;
public class avg_shit {
    public static void main(String[] args){
        Scanner SC=new Scanner(System.in);
        System.out.print("Enter the no of students: ");
        int a= SC.nextInt();
        int[] marks=new int [a];
        int sum=0;
        for (int i=0;i<a;i++){
            System.out.print("Marks of Student "+(i+1)+": ");
            marks[i]=SC.nextInt();
            sum=sum+marks[i];
        }
        System.out.println("Average marks of the students is-->"+(sum/a));
        SC.close();
    }
}
