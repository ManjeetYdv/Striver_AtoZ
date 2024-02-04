class Solution {
    public int helper(int level , int idx ,List<List<Integer>> triangle , List<List<Integer>> dp){
        if(level==triangle.size()- 1) return triangle.get(level).get(idx);
        if(dp.get(level).get(idx)!=-1) return dp.get(level).get(idx);
        int l1 = helper(level+1 , idx , triangle ,dp);
        int l2 = helper(level+1 , idx+1 , triangle ,dp);
        Integer min = Math.min(l1 ,l2)+ triangle.get(level).get(idx);
        dp.get(level).set(idx , min );
        return min;
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        List<List<Integer>> dp = new ArrayList<>();
        for(int i=0 ;i<triangle.size() ;i++){
            dp.add(new ArrayList<>());
            for(int j=0 ;j<triangle.get(i).size();j++)  dp.get(i).add(-1);
        }
        return helper(0 ,0 , triangle , dp);
    }
}
