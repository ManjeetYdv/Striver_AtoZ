class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        StringBuilder res = new StringBuilder();

        for(int i=0 ;i<s.length();i++){
            char ch  = s.charAt(i);
            if(ch!=' ') sb.append(ch);

            if(ch==' ' || i==s.length()-1){
                if(!sb.isEmpty()) res.insert(0 , sb.toString()+' ');
                sb.setLength(0);
            }
        }
        return res.substring(0 , res.length()-1);
    }
}
