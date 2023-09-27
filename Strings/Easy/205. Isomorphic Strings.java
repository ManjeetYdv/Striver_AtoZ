class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character , Character> map1 = new HashMap<>(); //to link char from s to t
        HashMap<Character , Character> map2 = new HashMap<>(); //to link char from t ot s , since its a one to one mapping

        for(int i=0 ;i<s.length() ;i++){
            char s_char =  s.charAt(i);
            char t_char = t.charAt(i);

            if(!map1.containsKey(s_char)) { //current element was not mapped before
                if(!map2.containsKey(t_char)){
                    map1.put(s_char , t_char);
                    map2.put(t_char , s_char);
                }
                else return false;
            }
            else{
                //element was mapped before
                char mapped_to = map1.get(s_char);
                if(t_char !=mapped_to) return false;
            }

        }

        return true;
    }
}
