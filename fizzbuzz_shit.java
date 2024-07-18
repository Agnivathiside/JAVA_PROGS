import java.util.*;
public class fizzbuzz_shit {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter the fooking range idiot: ");
        int range=sc.nextInt();
        ArrayList<String> arl=new ArrayList<>();
        for(int i=1;i<=range;i++){
            if(i%3==0 && i%15!=0){
                arl.add("fizz");
            }else if(i%5==0 && i%15!=0){
                arl.add("buzz");
            }else if(i%15==0){
                arl.add("fizzbuzz");
            }else{
                arl.add(String.valueOf(i));
            }
        }
        for(int x=0;x<arl.size();x++){
            System.out.println(arl.get(x));
        }
        sc.close();
    }
    
}
