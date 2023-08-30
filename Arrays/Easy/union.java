import java.util.*;
public class Solution {
    public static List< Integer > sortedArray(int []a, int []b) {
        // Write your code here
        int i=0 ;
        int j=0;
        List<Integer> res = new ArrayList<>();
        res.add(Integer.min(a[i] , b[j]));
        
        while(i!=a.length && j!=b.length){
            if(a[i]>b[j]){
                if(res.get(res.size()-1)!= b[j]) res.add(b[j]);
                j++;
            }
            else if(a[i]<b[j]){
                if(res.get(res.size()-1)!= a[i]) res.add(a[i]);
                i++;
            }
            else {
                if(res.get(res.size()-1)!= a[i]) res.add(a[i]); //a[i] ==b[j]
                i++;
                j++;
            }
        }

        while(i<a.length){
            if(res.get(res.size()-1)!= a[i]) res.add(a[i]);
            i++;
        }
        while(j<b.length){
            if(res.get(res.size()-1)!= b[j]) res.add(b[j]);
            j++;
        }
        return res;
    }
}
