class Solution {
    public void helper(int index , String digits , StringBuilder sb , List<String> res , HashMap<Integer , List<Character>> map){
        if(index==digits.length()) {
            res.add(sb.toString());
            return;
        }
        
        int digit = digits.charAt(index)-'0';
        for(char ch : map.get(digit)){
            sb.append(ch);
            helper(index+1 , digits , sb , res , map);
            sb.setLength(sb.length()-1);
        }
    }
    public List<String> letterCombinations(String digits) {
        HashMap<Integer , List<Character> > map = new HashMap<>();
        List<String> res = new ArrayList<>();
        if(digits.length()==0) return res;

        char ch='a';
        for(int i=2 ;i<=9 ;i++){
            
            int terms=0;
            if(i==7 || i==9)terms=4;
            else terms=3;
            
            List<Character> chars = new ArrayList<>();
            for(int j=0 ;j<terms ;j++) chars.add(ch++);
            map.put(i , chars);
            
        }
        
        helper(0 , digits , new StringBuilder() ,res , map);
        return res;
        

    }
}
