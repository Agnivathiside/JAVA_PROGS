import java.util.*;
public class hashmap_shit {
    public static void main(String[] args){
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1,2);
        System.out.println(map);
        map.put(1, 0);
        System.out.println(map);
    }
}
