//import java.time.Month;
import java.util.*;
public class calender_shit {
    public static void main(String args[])
    {
        Calendar c = Calendar.getInstance();
        System.out.println("Here is your current calender: " + c);
        System.out.println("Here is your current time: " + c.getTime());
        System.out.println("Here is the current month: " + (c.get(Calendar.MONTH)+1));
    }
}
