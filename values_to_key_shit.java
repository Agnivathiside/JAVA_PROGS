//JAVA DOESN'T HAVE ANY SHORT WAY TO DISPLAY AN ARRAY OR WHAT ??!! PATHETIC FUCK!!!
import java.util.*;
public class values_to_key_shit {
    public static Integer[] values_to_key(Map<Integer,Integer> dic, Integer value){
        Integer[] key_lis=new Integer[dic.size()];
        int i=0;
        for (Integer keys:dic.keySet()){
            if (value==dic.get(keys)){
                key_lis[i]=keys;
            }
        }
        return key_lis;

    }
    public static void main(String[] args){
        Scanner SC=new Scanner(System.in);
        System.out.println("How many entries?: ");
        int a=SC.nextInt();
        Map<Integer,Integer> dic=new HashMap<>();
        for (int i=0;i<a;i++){
            int key=SC.nextInt();
            int value=SC.nextInt();
            dic.put(key, value);
        }
        System.out.println("What value to look for?: ");
        int v=SC.nextInt();
        System.out.println(values_to_key(dic,v));
        SC.close();
    }
}
