import java.util.*;
class graph{
    HashMap<Integer, List<Integer>> map= new HashMap<>();
    void addEdge(int u, int v, int direction){
        // List<Integer> lis=new ArrayList<>();
        // lis.add(v);
        // map.put(u, lis);
        //map.get(u).add(v);
        if (!map.containsKey(u)){
            map.put(u, null);
            map.get(u).add(v);
        }else{
            map.get(u).add(v);
        }

        if (direction==0){
            List<Integer> lis1=new ArrayList<>();
            lis1.add(u);
            map.put(v, lis1);
        }
    }
    void printAdjList(){
        for (int i:map.keySet()){
            for (List<Integer> l:map.values()){
                System.out.println(i+" "+l);
            }
        }
    }
}
public class graph_beginning_shit {
    
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of nodes: ");
        int n =sc.nextInt();

        System.out.println("Enter the number of edges: ");
        int m =sc.nextInt();

        graph g = new graph();

        for (int i=0; i<m; i++){
            int u=sc.nextInt();
            int v=sc.nextInt();

            g.addEdge(u, v, 0);
        }
        g.printAdjList();
        sc.close();
    }
}

