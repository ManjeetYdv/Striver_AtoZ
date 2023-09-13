class Solution {
    public String removeOuterParentheses(String s) {

        //Way-1
        // int count=0;
        // StringBuilder sb = new StringBuilder();
        
        // for(char ch : s.toCharArray()){
        //     if(ch=='(') count++;
        //     else if(ch==')') count--;
            
        //     if(ch=='(' && count>1) sb.append(ch);
        //     if(ch==')' && count>0) sb.append(ch);
            
        // }
        
        // return sb.toString();

        //way-2
        Stack<Character>stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(char ch : s.toCharArray()){
            if(ch=='('){
                if(stack.size()>0) sb.append(ch);
                stack.push(ch);
            }
            else { //ch =')'
                stack.pop();
                if(stack.size()>0) sb.append(ch);
            }
        }
        
        return sb.toString();
    }
}
