import java.util.*;
public class a_little_grammer {
    public static void main(String[] args){
        Scanner SC=new Scanner(System.in);
        System.out.println("How many words: ");
        int a=SC.nextInt();
        for (int i=0;i<a;i++){
            System.out.println("Enter the word: ");
            String word=SC.next();
            System.out.println("Enter the parts of speech: ");
            String parts_of_speech = SC.next();
            Word word1=new Word(word, parts_of_speech);
            word1.display();
        }
        SC.close();
    }
}
class Word{
    String parts_of_speech;
    String word;
    public Word(String word, String parts_of_speech ){
        this.word=word;
        this.parts_of_speech=parts_of_speech;
    }
    void display(){
        System.out.println("Parts of speech of the word "+word+" is: "+parts_of_speech);
    }
    
}