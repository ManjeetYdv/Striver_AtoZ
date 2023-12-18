class Solution {
    public void helper(int i , int j , String s , HashMap<String , Integer> map , List<String> words  , List<String>res){
       if(j==s.length()){
           if(i==j) {
               StringBuilder sb = new StringBuilder();
               for(int k=0 ;k<words.size() ;k++) {
                   if(k== words.size()-1) sb.append(words.get(k));
                   else sb.append(words.get(k)).append(" ");
               }
               res.add(sb.toString());
           }
           return;
       }
       
       if(map.containsKey(s.substring(i , j+1))){
           words.add(s.substring(i,  j+1));
           helper(j+1 , j+1 , s , map , words , res);
           words.remove(words.size()-1);
       }
       
       helper(i , j+1 , s , map  , words , res);
    
    }
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        
        HashMap<String , Integer> map = new HashMap<>();
        for(String str : wordDict) map.put(str , 1);
        
        helper(0 ,0 ,s , map , new ArrayList<>() , res);
        return res;
    }
}
