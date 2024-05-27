class Solution {
    public int numberOfSubstrings(String s) {
        int res=0;
        int[] lastSeen = {-1,-1,-1};
        for(int i=0;i<s.length();i++){
            lastSeen[s.charAt(i)-'a']=i;
            if(lastSeen[0]!=-1 && lastSeen[1]!=-1 && lastSeen[2]!=-1){
                int lastofABC = Math.min(lastSeen[0] , Math.min(lastSeen[1] ,lastSeen[2]));
                res+=lastofABC+1;
            }
        }
        return res;
    }
}
