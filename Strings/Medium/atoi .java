class Solution {
    public int myAtoi(String s) {
       int max = Integer.MAX_VALUE;
       int min = Integer.MIN_VALUE;
       
       s = s.trim();
       if(s.length()==0) return 0;
       int res =0;

       int idx=0;
       boolean neg = false;
       if(s.charAt(idx)=='-') {
           neg = true;
           idx++;
       }
       else if(s.charAt(idx)=='+') idx++;

       while(idx <s.length() &&  Character.isDigit(s.charAt(idx))){
           int val = s.charAt(idx) -'0';
           
           if((max-val)/10 < res) { // its same as res*10 + val > Integer.max , but since res is integer and if res*10 +val is greater than Int_max , we cant store it into Int and cant compare it to int_max , so we did this
               if(neg) return min;
               else return max;
           }
           
           res = res*10 + val;
           idx++;
       }

       if(neg) return -1*res;
       return res;
    }
}
