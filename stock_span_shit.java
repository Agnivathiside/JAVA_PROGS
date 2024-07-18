//{ Driver Code Starts
    import java.util.*;
    import java.io.*;
    import java.lang.*;
    
    public class stock_span_shit
    {
        public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            
            while(t-- > 0)
            {
                int n =sc.nextInt();
                int a[] = new int[n];
                
                int i = 0;
                for(i = 0; i < n; i++)
                  a[i] = sc.nextInt();
                  
                int[] s = new Solution().calculateSpan(a, n);
                
                for(i = 0; i < n; i++)
                {
                    System.out.print(s[i] + " ");
                }
                
                System.out.println();
            }
        }
        
        
        
    }
    // } Driver Code Ends
    
    
    
    class Solution
    {
        //Function to calculate the span of stockâ€™s price for all n days.
        public static int[] calculateSpan(int price[], int n)
        {
            // Your code here
            int[] lis= new int[price.length];
            Stack<Integer> s= new Stack<>();
                int count=1;
                //int[] pop_lis = new int[price.length];
                List<Integer> pop_lis=new ArrayList<Integer>();  
                for (int i=0;i<price.length;i++){
                    if (s.empty()){
                        lis[i]=1;
                        s.push(price[i]);
                    }else if(!s.empty()){
                        if (price[i]<s.peek()){
                            lis[i]=1;
                            s.push(price[i]);
                        }else{
                            while (!s.isEmpty() && price[i]>s.peek()){
                                pop_lis.add(s.peek());
                                s.pop();
                                count++;
                            } 
                            Collections.reverse(pop_lis);
                            s.addAll(pop_lis);
                            pop_lis.clear();
                            lis[i]=count;
                            count=0;
                            s.push(price[i]);
                        }
    
                    }
                }
                return lis;
        }
        
    }