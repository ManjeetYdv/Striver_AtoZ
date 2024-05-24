class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i=0;
        int j=0;
        int n=s.length();
        int result=0;
        HashMap<Character,Integer> map = new HashMap<>();
        while(j<n){
            char curr = s.charAt(j);
            if(map.containsKey(curr)){
                if(map.get(curr)>=i) i= map.get(curr)+1;
            }
            map.put(curr , j);
            result=Math.max(result ,j-i+1);
            j++;
        }
        return result;
    }
}
