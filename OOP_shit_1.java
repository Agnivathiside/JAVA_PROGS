//import java.util.*;
public class OOP_shit_1 {
    public static void main(String[] args){
        //Person p1 = new Person();
        Person p1 = new Person("Samy", 20);
        System.out.println(p1.name +" "+ p1.age+" "+"OBJECT NO--> "+Person.count);
        // Person p2 = new Person(); --> if i create a constructor then can't i use defaault values
        // System.out.println(p2.name+" "+p2.age);
        Person p2 = new Person("Bokachoda", 108);
        System.out.println(p2.name+" "+p2.age+" OBJECT NO--> "+Person.count);
        p1.watching_porn();
        p2.musterbation();

        Person p3 = new Person("Again samy", 20);
        System.out.println("OBJECT NO--> "+Person.count);
        p3.musterbation(2);

        Person p4 = new Person("Agniva", 20);
        System.out.println(p4.name+" "+p4.age+" OBJECT NO--> "+Person.count);
        System.out.println(p4.name + " is created in a modern way !! while they were musterbating");
    }
}
class Person{
    String name;
    int age;//Default values
    static int count=0;
    //let's count the number of students created, using count 
    public Person(){
        count++;
        System.out.println("An object is created !");
    }

    public Person(String name, int age){
        this();
        this.name = name;
        this.age=age;
        //Lets_count();
    }

    void watching_porn(){
        System.out.println(name + " is watching porn !!");
    }
    void musterbation(){
        System.out.println(name + " is musterbating !! :)");
    }
    void musterbation(int time){
        System.out.println(name +" is musterbating for "+time+" hours ");
    }
}