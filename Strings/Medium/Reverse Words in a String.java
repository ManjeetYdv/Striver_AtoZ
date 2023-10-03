class Solution {
    public String reverseWords(String s) {

        
        // StringBuilder sb = new StringBuilder();
        // StringBuilder temp = new StringBuilder();
        
        // for(int i=0 ; i<s.length() ;i++){
        //     char ch = s.charAt(i);
        //     if(ch!=' ') temp.append(ch);
        //     if(i==s.length()-1 || ch==' '){
        //         if(temp.length()!=0){
        //             sb.insert(0 , temp.toString()+' ');
        //             temp.setLength(0);
        //         }
        //     }
        // }
        // return sb.toString().substring(0 , sb.length()-1);

        StringBuilder sb = new StringBuilder();
        int i=0;
        int n = s.length();
        
        while(i<n){
            
            //neglecting early spaces
            while(i<n && s.charAt(i)==' ') i++;
            if(i>=n) break;
            
            int j=i;
            while(i<n && s.charAt(i)!=' ') i++;
            
            String word = s.substring(j , i);
            sb.insert(0 , word+' ');
        }
        
        return sb.toString().substring(0 , sb.length()-1);
    }
}
