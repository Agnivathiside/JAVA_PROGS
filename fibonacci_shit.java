import java.util.*;
public class fibonacci_shit {
    public static void main(String[] args){
		int n, a=0,b=0,c=1;
		Scanner SC= new Scanner(System.in);
		System.out.print("Enter a value: ");
		n= SC.nextInt();
		System.out.print("Fibbonacci series : ");
		for (int i=1;i<=n;i++){
			a=b;
			b=c;
			c=a+b;
			System.out.println(a+" ");
		}
        SC.close();
    }
}
