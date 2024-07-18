import java.util.*;
public class class_student {
    public static void main(String[] args){
        Scanner SC=new Scanner(System.in);
        System.out.println("How many students: ");
        int a=SC.nextInt();
        // System.out.println("Enter the name: ");
        // String name=SC.next();
        // System.out.println("Enter the marks: ");
        // int marks=SC.nextInt();
        for (int i=0;i<a;i++){
            System.out.println("Enter the name: ");
            String name=SC.next();
            System.out.println("Enter the marks: ");
            int marks=SC.nextInt();
            Student s=new Student(name, marks);
            s.display();
        }
        SC.close();

    }
}
class Student{
    String name;
    int marks;
    public Student(String name, int marks){
        this.name=name;
        this.marks=marks;
    }
    void display(){
        System.out.println(name + ":"+ marks);
    }
}
