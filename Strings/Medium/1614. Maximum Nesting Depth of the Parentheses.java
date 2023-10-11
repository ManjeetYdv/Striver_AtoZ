class Solution {
    public int maxDepth(String s) {
        int count=0;
        int res=0;
        for(char ch : s.toCharArray()){
            if(ch=='(') count++;
            else if(ch==')'){
                res = Math.max(res , count);
                count--;
            }
           
        }
        return res;
    }
}
