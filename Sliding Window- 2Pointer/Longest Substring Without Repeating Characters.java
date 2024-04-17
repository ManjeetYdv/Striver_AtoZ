class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i=0;
        int j=0;
        int n =s.length();
        int res=0;
        HashMap<Character , Integer> map = new HashMap<>();
        while(j<n){
            if(map.containsKey(s.charAt(j))){
                if(map.get(s.charAt(j))>=i) i=map.get(s.charAt(j))+1;
            }
            map.put(s.charAt(j) ,j);
            res=Math.max(j-i+1 , res);
            j++;
        }
        return res;   
    }
}
