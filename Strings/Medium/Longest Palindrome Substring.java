class Solution {
     public String longestPalindrome(String s) {
        int res=0;
        int start=0;
        int end=0;
        for(int i=0 ;i<s.length() ;i++){
            int l1 = expandFromCenter(s , i , i);
            int l2 = expandFromCenter(s , i , i+1);

            int bigger = Math.max(l1 , l2);
            if(bigger>res){
                res =bigger;
                start = i -(bigger-1)/2;
                end = i+bigger/2;
            }
        }
        return s.substring(start , end+1);
    }
    public int expandFromCenter(String s  , int start , int end){
        while(start>=0 && end<s.length()){
            if(s.charAt(start)==s.charAt(end)){
                start--;
                end++;
            }
            else break;
        }
        return end-start-1;
    }
}
