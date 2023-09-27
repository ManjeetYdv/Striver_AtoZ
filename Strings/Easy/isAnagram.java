public class isAnagram {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;

        int []_s = new int[26];
        int []_t = new int[26];

        for(int i=0 ;i<s.length(); i++){
            _s[s.charAt(i)-'a']++;
            _t[t.charAt(i)-'a']++;
        }

        for(int i=0 ;i<26 ;i++){
            if(_s[i]!=_t[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
