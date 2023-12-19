class Solution {
     public void helper(int index ,int []nums , List<Integer> list , List<List<Integer>> res){
        res.add(new ArrayList<>(list));
        
        for(int i=index ;i<nums.length ;i++){
            if(i==index || nums[i]!=nums[i-1]){
                list.add(nums[i]);
                helper(i+1 , nums , list , res);
                list.remove(list.size()-1);
            }
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        helper(0 , nums , new ArrayList<>() , res);
        return res;
        
        
    }
}
