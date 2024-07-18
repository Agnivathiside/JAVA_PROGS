import java.util.*;;
public class two_D_plane {
    public static void main(String[] args){
        Scanner SC=new Scanner(System.in);
        System.out.print("Enter the ordinate: ");
        int a=SC.nextInt();
        System.out.print("Enter the abcissa: ");
        int b=SC.nextInt();
        Point p1 = new Point(a, b);
        System.out.println(p1.distance(a, b));
        System.out.println(p1.on_x_axis(a, b));
        System.out.println(p1.on_y_axis(a, b));
        System.out.println(p1.quadrants(a, b));
        SC.close();

    }
}
class Point{
    int x;
    int y;
    public Point(int x, int y){
        this.x=x;
        this.y=y;
    }
    float distance(int x, int y){
        return (float) Math.pow(Math.pow(x, 2)+Math.pow(y, 2), 0.5);
    }
    boolean is_origin(int x, int y){
        if(x==0 && y==0){
            return true;
        }
        return false;
    }
    boolean on_x_axis(int x, int y){
        if (x!=0 && y==0){
            return true;
        }
        return false;
    }
    boolean on_y_axis(int x, int y){
        if (y!=0 && x==0){
            return true;
        }
        return false;
    }
    String quadrants(int x, int y){
        if (x>0 && y>0){
            return "FIRST QUADRANT";
        }else if(x>0 && y<0){
            return "SECOND QUADRANT";
        }else if(x<0 && y<0){
            return "THIRD QUADRANT";
        }
        return "FOURTH QUADRANT";
    }
}
