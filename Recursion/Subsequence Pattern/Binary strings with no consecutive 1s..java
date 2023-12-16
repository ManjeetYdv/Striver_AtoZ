import java.util.*;

public class Solution {
    public static void help(int index ,int n , StringBuilder sb  , List<String> res){
        if(index==n){
            res.add(sb.toString());
            return;
        }
        
        help(index+1 , n , sb.append('0') ,res);
        sb.setLength(sb.length()-1);
       
        if(index==0 || sb.charAt(sb.length()-1)=='0'){
            help(index+1 , n , sb.append('1') ,res);
            sb.setLength(sb.length()-1);
        }
    }
    public static List< String > generateString(int N) {
        // Write your code here.
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        help(0 , N , sb , res);
        return res;
        
    }
}
