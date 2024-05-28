class Solution {
//     class Solution {
//     public boolean checkValidString(String s) {
//         Stack<Integer>open=new Stack<>();
//         Stack<Integer>asstrick=new Stack<>();
//         int idx=0;
//         for(char ch: s.toCharArray()){
//             if(ch=='(') open.push(idx);
//             else if(ch==')'){
//                 if(!open.isEmpty()) open.pop();
//                 else if(!asstrick.isEmpty()) asstrick.pop();
//                 else return false;
//             }
//             else asstrick.push(idx);
//             idx++;
//         }
//         if(open.isEmpty()) return true;
//         if(open.size()>asstrick.size()) return false;
//         while(!open.isEmpty()){
//             if(open.pop()>asstrick.pop()) return false;
//         }
//         return true;
//     }
// }
    public boolean checkValidString(String s) {
        int open=0;
        int close=0;
        int n=s.length();
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='(' || s.charAt(i)=='*') open++;
            else open--;

            if(s.charAt(n-1-i)==')' || s.charAt(n-1-i)=='*') close++;
            else close--;
            
            if(open<0 || close<0) return false;
        }
        return true;
    }
}
