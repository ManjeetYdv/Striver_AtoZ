class Solution {
    public String largestOddNumber(String num) {
        for(int i=num.length()-1 ;i>=0 ;i--){
            int curr = num.charAt(i)-'0';
            if(curr%2!=0){
                return num.substring(0 , i+1);
            }
        }
        return "";
    }
}
