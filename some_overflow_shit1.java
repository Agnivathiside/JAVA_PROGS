import java.util.Scanner;
import java.util.Random;
public class some_overflow_shit1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random random = new Random();
    
        String[] answer = new String[6];
        answer[0] = "blabla1";
        answer[1] = "blabla2";
        answer[2] = "blabla3";
        answer[3] = "blabla4";
        answer[4] = "blabla5";
        answer[5] = "blabla6";
        boolean keepGoing = true;
    
    
        System.out.println("Hello, how can I help you?");
        while (keepGoing) {
            String input = in.next();
            int output = random.nextInt(6);
            System.out.println(answer[output]);
    
            if (input.equals("Bye!")){
                keepGoing = false;
                System.out.println("Bye!");
            }
    
        }
        in.close();
    }    
    
}
