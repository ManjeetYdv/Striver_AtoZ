import java.util.* ;
import java.io.*; 
public class Solution {
    public static void help(int left , int right , StringBuilder sb , ArrayList<String> list){
        if(left==0 && right==0){
            list.add(sb.toString());
            return;
        }

        if(left>0){
            help(left-1 , right , sb.append('(') , list);
            sb.setLength(sb.length()-1);
        }
        if(right>left){
            help(left , right-1 , sb.append(')') , list);
            sb.setLength(sb.length()-1);
        }

    }
    public static ArrayList<String> validParenthesis(int n){
       int left=n;
       int right=n;
       StringBuilder sb = new StringBuilder();
       ArrayList<String> list = new ArrayList<>();

       help(left , right , sb , list);
       return list;
    }
}
