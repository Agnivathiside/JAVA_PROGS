import java.util.*;
public class pythagorus_in_range_shit {
    public static void main(String[] args){
        Scanner SC=new Scanner(System.in);
        System.out.println("Enter your shitty range: ");
        int a = SC.nextInt();
        Boolean flag = false;
        for (int i=3;i<a-2;i++){
            for (int j=i+1;j<a-1;j++){
                for (int k=j+1;k<a;k++){
                    if (Math.pow(i, 2)+Math.pow(j, 2)==Math.pow(k, 2)){
                        List<Integer> l1 = new ArrayList<Integer>();
                        l1.add(i);
                        l1.add(j);
                        l1.add(k);
                        System.out.println(l1);
                        flag =true;

                    }
                }
            }
        }
        if (flag==false){
            System.out.println("NO SOLUTION BITCH!!, NOW U CAN FUCK OFF");
        }
        SC.close();

    }
}
