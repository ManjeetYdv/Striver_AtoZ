import java.util.ArrayList;
import java.util.List;


public class Solution{
    public static List< Integer > printDivisors(int n) {
        // Write your code here

        // BruteForce
        // List<Integer> res = new ArrayList<>();
        
        // for(int i=1 ;i<=n ;i++){
        //     if(n%i==0) res.add(i);
        // }
        // return res;

         //little more optimal
        List<Integer> res = new ArrayList<>();
        for(int i=1 ;i<=(int)Math.sqrt(n) ;i++){
           if(n%i==0){
                res.add(i);
               if(i*i!=n) res.add(n/i);
            }
        }
        res.sort((a ,b)->a-b);
        return res;



    }
}
