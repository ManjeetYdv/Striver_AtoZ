class Solution {
    public int helper(int i , int j , String s , HashMap<String , Integer> map, int [][]dp ){
        if(j==s.length()){
            if(i==j) return 1;
            else return 0;
        }
        //memoization
        if(dp[i][j]!=-1) return dp[i][j];

        //starting new segement
        if(map.containsKey(s.substring(i , j+1))){
           if(helper(j+1 , j+1 , s , map , dp)==1){
              return dp[i][j]=1;
           }
        }

        //continuing previous segment
        return dp[i][j] =helper(i , j+1 , s , map ,dp);
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        int[][]dp = new int[s.length()+1][s.length()+1];
        for(int[]row : dp) Arrays.fill(row ,-1);

        HashMap<String , Integer> map = new HashMap<>();
        for(String word : wordDict) map.put(word ,1);
        
        return helper(0 ,0 ,s , map , dp )==1;
    }
}
