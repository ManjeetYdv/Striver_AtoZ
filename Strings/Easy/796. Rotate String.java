class Solution {
   public boolean rotateString(String s, String goal) {
//        if(s.length()!=goal.length()) return false;
//        s = s+s;
//        if(s.indexOf(goal)==-1) return false;
//        return true;


        if(s.length()!=goal.length()) return false;
        int len = s.length();

        for(int i=0 ;i<len ;i++){ //i for rotations
            if(check(s , goal , i , len)) return true;
        }
        return false;
    }
    public boolean check(String s , String goal , int rotations , int len){
        for(int i=0 ;i<len ;i++){
            char _s =s.charAt(i);
            char _goals = goal.charAt((i+rotations)%len);
            if(_s!=_goals) return false;
        }
        return true;
    }
}
