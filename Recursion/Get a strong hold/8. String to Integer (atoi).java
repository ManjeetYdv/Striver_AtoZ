class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        if(s.length()==0) return 0;
        boolean neg = false;
        if(s.charAt(0)=='-') neg = true;
        int index=0;
        int res=0;
        if(s.charAt(0)=='-' || s.charAt(0)=='+') index++;
        
        while(index<s.length() && Character.isDigit(s.charAt(index))){
            int d = s.charAt(index) -'0';
            
            if( res > (Integer.MAX_VALUE-d)/10){
                if(neg) return Integer.MIN_VALUE;
                else return Integer.MAX_VALUE;
            }
            
            res = res*10+d;
            index++;
        }
        return neg==true? res*-1 : res;
    }
}
