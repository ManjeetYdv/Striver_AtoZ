class Solution {
    //index representing 1 to 9
    public void helper(int index , int k , int n , List<Integer> list , List<List<Integer>> res ){
        if(list.size()==k){
            if(n==0) res.add(new ArrayList<>(list));
            return;
        }
        if(index==10) return;
        
        if(n-index>=0){
            list.add(index);
            helper(index+1 , k ,n-index , list , res);
            list.remove(list.size()-1);
        }
        
        helper(index+1 , k , n, list , res);

    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        helper(1 , k , n, new ArrayList<>() , res);
        return res;
    }
}
