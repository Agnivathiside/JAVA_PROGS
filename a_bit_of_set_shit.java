import java.util.*;
public class a_bit_of_set_shit {
    public static Set<Integer> factors(int n){
        Set<Integer> s=new HashSet<Integer>();
        for (int i=1;i<n+1;i++){
            if (n%i==0){
                s.add(i);
            }
        }
        return s;
    }
    public static Set<Integer> common_factors(int n,int m){
        Set<Integer> s1=new HashSet<Integer>();
        Set<Integer> s2=new HashSet<Integer>();
        Set<Integer> s3=new HashSet<Integer>();
        s1=factors(n);
        s2=factors(m);
        for (Integer num1:s1){
            for (Integer num2:s2){
                if (num1==num2){
                    s3.add(num1);
                }
            }
        }
        return s3;
    }
    public static Map<Integer,Set<Integer>> factors_upto(int n){
        Map<Integer,Set<Integer>> dic = new HashMap<>();
        for (int i=1;i<=n;i++){
            dic.put(i, factors(i));
        }
        return dic;
    }
    public static void main(String[] args){
        System.out.println(factors(10));
        System.out.println(common_factors(10, 5));
        System.out.println(factors_upto(4));
    }
}
