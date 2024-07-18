import java.util.*;
public class just_checking_1_shit {
    public static void createAdjList(int[][] prerequisites,HashMap<Integer, ArrayList<Integer>> map){
        for (int i=0;i<prerequisites.length;i++){
            // map.put(prerequisites[i][0], prerequisites[i][1]);
            ArrayList<Integer> arl= new ArrayList<>();
            for (int j=1;j<prerequisites[i].length;j++){
                arl.add(prerequisites[i][j]);
            }
            map.put(prerequisites[i][0], arl);
        }
    }
    public static void main(String[] args){
        int[][] prerequisites={{1,0},{2,1},{3,2}};
        HashMap<Integer, ArrayList<Integer>> map= new HashMap<>();
        createAdjList(prerequisites, map);
        System.out.println(map);
    }
}

