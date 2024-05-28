class Solution {
    public String minWindow(String s, String t) {
        int res_i=0;
        int res_j=-1;
        int minLen=s.length()+1;
        int i=0;
        int j=0;
       
        int[]f = new  int[128];
        for(char ch : t.toCharArray()){
            f[(int)ch]++;
        }
        int counter=0;
        while(j<s.length()) {
            f[(int) s.charAt(j)]--;
            if (f[(int) s.charAt(j)] >= 0) counter++;

            while (i <= j && counter == t.length()) {
                if (j - i + 1 < minLen) {
                    minLen = j - i + 1;
                    res_i = i;
                    res_j = j;
                }
                f[(int) s.charAt(i)]++;
                if (f[(int) s.charAt(i)] > 0) counter--;
                i++;
            }
            j++;
        }
        return s.substring(res_i , res_j+1) ;
    }
}
