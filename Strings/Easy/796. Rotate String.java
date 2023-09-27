class Solution {
    public boolean rotateString(String s, String goal) {
        // if(s.length()!=goal.length()) return false;
        // s = s+s;
        // if(s.indexOf(goal)==-1) return false;
        // return true;

        if(s.length()!=goal.length()) return false;
        int n= s.length();
        StringBuilder sb = new StringBuilder(s);
        while(n>1){
            if(sb.toString().equals(goal)) return true;
            char ch = sb.charAt(s.length()-1);
            sb.deleteCharAt(s.length()-1);
            sb.insert(0 , ch);
            n--;
        }
        return false;
    }
}
