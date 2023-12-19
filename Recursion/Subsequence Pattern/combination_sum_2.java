class Solution {
    public void helper(int idx , int []candidates , int target , List<Integer> list ,List<List<Integer>> res){
        if(target==0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i =idx ;i<candidates.length ;i++){
            if(i==idx || candidates[i]!=candidates[i-1]){
                if(target-candidates[i]>=0) {
                    list.add(candidates[i]);
                    helper(i+1 , candidates , target-candidates[i] , list , res);
                    list.remove(list.size()-1);
                }
            }
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        helper(0 , candidates , target , new ArrayList<>() , res);
        return res;
    }
        
    
}s
  
