public class Solution {
    public static boolean check(int idx , int len , String str){
        if(idx>=len/2) return true;
        if(str.charAt(idx)!=str.charAt(len-1-idx)) return false;
        return check(idx+1 , len , str);
    }
    public static boolean isPalindrome(String str) {
        // Write your code here.
        return check(0 , str.length() , str);
        
    }
}
