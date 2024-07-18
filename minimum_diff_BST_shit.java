import java.util.*;

public class minimum_diff_BST_shit {
    public static void main(String[] args){
        ArrayList<Integer> arl = new ArrayList<>();

        arl.add(4);
        arl.add(2);
        arl.add(6);
        arl.add(1);
        arl.add(3);

        Collections.sort(arl);
        // arl --> 0 1 12 13 49
        int p1=0, p2=1;
        int mini=Integer.MAX_VALUE;
        while (p2<arl.size()){
            mini=Math.min(arl.get(p2)-arl.get(p1), mini);
            // System.out.println("MINI now "+mini);
            p1++;
            p2++;
        }
        System.out.println("Minimum value is "+mini);

    } 
}
