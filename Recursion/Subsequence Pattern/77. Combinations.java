class Solution {
    public void helper(int index ,int n , int k , List<Integer> list , List<List<Integer>> res){
        if(list.size()==k) {
            res.add(new ArrayList<>(list));
            return;
        }
        if(index==n) return;
        
        //pick
        list.add(index+1);
        helper(index+1 , n , k , list , res);
        list.remove(list.size()-1);
        
        //notpick
        helper(index+1 , n , k,list ,res);
    }
    
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res= new ArrayList<>();
        helper(0 , n , k , new ArrayList<>()  ,res);
        return res;
    }
}
