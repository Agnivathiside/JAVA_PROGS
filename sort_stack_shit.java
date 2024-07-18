//{ Driver Code Starts
    import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
    import java.util.Stack;
    class SortedStack{
        public static void main(String[] args){
            Scanner sc=new Scanner(System.in);
            int t=sc.nextInt();
            while(t-->0){
                Stack<Integer> s=new Stack<>();
                int n=sc.nextInt();
                while(n-->0)
                s.push(sc.nextInt());
                GfG g=new GfG();
                Stack<Integer> a=g.sort(s);
                while(!a.empty()){
                    System.out.print(a.peek()+" ");
                    a.pop();
                }
                System.out.println();
            }
        }
    }
    // } Driver Code Ends
    
    
    /*Complete the function below*/
    class GfG{
        public Stack<Integer> sort(Stack<Integer> s)
        {
            //add code here.
            //11 2 32 3 41
            int arr[]=new int[s.size()],i=0;
            while (!s.isEmpty()){
                arr[i]=s.peek();
                s.pop();
                i++;
            }
            Arrays.sort(arr);
            for (int x=0;x<arr.length;x++){
                s.push(arr[x]);
            }
            return s;
        }
    }