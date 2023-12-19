class Solution {
    public static void helper(int i , int []candidates , int target , List<Integer> list , List<List<Integer>> res){
        if(target==0){
            res.add(new ArrayList<>(list));
            return;
        }
        if(i==candidates.length) return;
        
        if(target-candidates[i]>=0){
            list.add(candidates[i]);
            helper(i , candidates , target-candidates[i]  , list , res);
            list.remove(list.size()-1);
        }
        
        helper(i+1 , candidates , target , list , res);
        
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        helper(0 , candidates , target , new ArrayList<>() , res);
        return res;
    }
}
