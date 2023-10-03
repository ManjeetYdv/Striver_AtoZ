class Solution {
    public int beautySum(String s) {
        int res=0;
        for(int i=0 ;i<s.length()-2 ;i++){ // becoz substring with len 1 and 2 will always have beauty 0
            int [] frequency = new int[26];
            
            for(int j=i ; j<s.length() ;j++){
                frequency[s.charAt(j)-'a']++; //updating freq
                res+= beauty(frequency);

            }
        }
        return res;
    }
    private int beauty(int[] freq){
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        
        for(int i : freq){
            if(i>max) max = i;
            if(i!=0 && i<min) min=i;
        }
        return max-min;
    }
}
