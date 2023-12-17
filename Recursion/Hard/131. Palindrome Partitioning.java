class Solution {
    List<List<String>> paritions = new ArrayList<>();
    public void helper(int index , String s , List<String> list){
        if(index==s.length()){
            paritions.add(new ArrayList<>(list));
            return;
        }

        for(int i=index; i<s.length() ;i++){
            if(isPalindrome(index , i , s)) {
                list.add(s.substring(index , i+1));
                helper(i+1   , s , list);
                list.remove(list.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        helper(0 , s, new ArrayList<>());
        return paritions;
    }

    public boolean isPalindrome(int i ,int j ,String s){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++ ;
            j--;
        }
        return true;
    }
}

