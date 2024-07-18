//SOME PROB WITH THIS CODE, WILL CHECK LATER !
import java.util.*;
public class good_old_turtle_shit {
    public static void main(String[] args){
        Scanner SC=new Scanner(System.in);
        System.out.println("Enter MOVE: ");
        String move=SC.next();
        int x=0;
        int y=0;
        while (move!="STOP"){
            if (move=="UP"){
                System.out.println("GO UP");
                y+=1;
            }else if(move=="DOWN"){
                System.out.println("GO DOWN");
                y-=1;
            }else if(move=="RIGHT"){
                System.out.println("GO RIGHT");
                x+=1;
            }else if(move=="LEFT"){
                System.out.println("GO LEFT");
                x-=1;
            }else if(move=="START"){
                System.out.println("AT ORIGIN");
                x=0;
                y=0;
            }
            move=SC.next();
        }
        System.out.println("Here is your MANHATTAN distance" + (Math.abs(x)+Math.abs(y)));
        SC.close();
    }
}
