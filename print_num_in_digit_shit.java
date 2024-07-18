import java.util.*;
public class print_num_in_digit_shit {
    public static void main(String[] args){
        Scanner SC=new Scanner(System.in);
        HashMap<Integer,String> M=new HashMap<Integer,String>();
        M.put(1, "one");
        M.put(2,"two");
        M.put(3,"three");
        M.put(4,"four");
        M.put(5,"five");
        M.put(6, "six");
        M.put(7,"seven");
        M.put(8,"eight");
        M.put(9,"nine");
        M.put(0,"zero");
        System.out.println("Number dao BC: ");
        String num_str=SC.next();
        for (int i=0;i<num_str.length();i++){
            char str=num_str.charAt(i);
            //Character. getNumericValue()--> way to convert char into integer
            //int str_int=Integer.parseInt(str);--> way to convert string into integer
            int a=Character.getNumericValue(str);
            System.out.println(M.get(a));
            //map.get(a)
            //map.keySet()
            //map.entrySet()
            //map.values()
        }
        SC.close();
    }
    
}
