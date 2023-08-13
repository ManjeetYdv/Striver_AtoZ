import java.util.Scanner;
public class Solution {
    
    public static void main(String[] args) {
        // Write your code here

        Scanner sc = new Scanner(System.in);
         
        char ch = sc.next().charAt(0);   //input char
        if(ch>='a' && ch<='z') System.out.println(0);
        else if(ch>='A' &&ch<='Z') System.out.println(1);
        else System.out.println(-1);
    }
}
