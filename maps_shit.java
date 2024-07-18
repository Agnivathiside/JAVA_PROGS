//import java.util.*;
import java.util.HashMap;
//import java.util.Map;
public class maps_shit {
    public static void main(String[] args){
        //IN PYTHON I HAD A CONCEPT CALLED DICITONARY, IN JAVA THE SAME THING IS CALLED MAPS:))
        //Map M=new HashMap();
        HashMap<String, Integer> M= new HashMap<String, Integer>();//this is like defining how the map is gonna be
        M.put("AGNIVA", 100);
        M.put("SUCHISMITA", 99);
        M.put("SHUBHAJIT", 98);
        M.put("SHRIPARNA", 97);
        // System.out.println(M);
        // Scanner SC= new Scanner(System.in);
        // System.out.println("How many elements?: ");
        // int a = SC.nextInt();
        // for (int i=0;i<a;i++){
        //     System.out.print("NAME "+(i+1)+": ");
        //     String name=SC.next();
        //     System.out.print("MARKS: ");
        //     int b=SC.nextInt();
        //     M.put(name, b);
        // }
        System.out.println("HERE IS YOUR DICTIONARY: "+M);
        //Boolean flag=M.isEmpty();//CHECKS IF THE DICTIONARY IS EMPTY OR NOT
        //System.out.println(flag);
        System.out.println(M.entrySet());
        System.out.println(M.keySet());
        System.out.println(M.values());
        // for (Map.Entry<String,Integer> entry : M.entrySet()) 
        //     System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        //map.get(a)
            //map.keySet()
            //map.entrySet()
            //map.values()
        //SC.close();
        for (String key : M.keySet()) {
            System.out.println(key +": "+ M.get(key));
        }
    }
}
