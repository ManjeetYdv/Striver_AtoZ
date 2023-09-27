class Solution {
    public String longestCommonPrefix(String[] strs) {
        // StringBuilder sb = new StringBuilder();
        // int minLen = Integer.MAX_VALUE;
        // int n = strs.length;

        // for(String str : strs) {
        //     minLen = Math.min(minLen , str.length());
        // }

        // for(int i=0 ;i<minLen ;i++){
        //     char curr = strs[0].charAt(i);
        //     for(int j=0 ;j<n ;j++){
        //         if(strs[j].charAt(i)!=curr) return sb.toString();
        //     }
            // sb.append(curr);
        // }
        
       // return sb.toString();// StringBuilder sb = new StringBuilder();
        // int minLen = Integer.MAX_VALUE;

        // for(String str : strs) {
        //     minLen = Math.min(minLen , str.length());
        // }

        // for(int i=0 ;i<minLen ;i++){
        //     char curr = strs[0].charAt(i);
        //     for(String str : strs){
        //         if(str.charAt(i)!=curr) return sb.toString();
        //     }
        //     sb.append(curr);
        // }
        // return sb.toString();
        
        Arrays.sort(strs);
        String smallest = strs[0];
        String longest = strs[strs.length-1];
        
        StringBuilder sb = new StringBuilder();
        for(int i=0 ;i<smallest.length() ;i++){
            if(smallest.charAt(i)==longest.charAt(i)){
                sb.append(smallest.charAt(i));
            }
            else break;
        }
        return sb.toString();
     
    }
}
