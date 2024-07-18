import java.util.*;
public class two_map_function_shit {
    public static boolean is_key(Map<String, Integer> dic,String key ){
        if (dic.containsKey(key)==true){
            //boolean flag=true;
            return true;
        }
        return false;
        //return flag;
    }
    public static Integer value(Map<String, Integer> dic,String key){
        if (dic.containsKey(key)==true){
            return dic.get(key);
        }
        return 0;
    }
    public static void main(String[] args){
        Scanner SC=new Scanner(System.in);
        Map<String,Integer> dic=new HashMap<>();
        dic.put("good", 4);
        dic.put("day", 3);
        System.out.println(is_key(dic,"good"));
        System.out.println(value(dic,"day"));
        SC.close();
        //System.out.println(value({"good": 4, "day": 3}, "day"));
    }
}
