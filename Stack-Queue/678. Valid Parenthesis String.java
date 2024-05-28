class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer>open=new Stack<>();
        Stack<Integer>asstrick=new Stack<>();
        int idx=0;
        for(char ch: s.toCharArray()){
            if(ch=='(') open.push(idx);
            else if(ch==')'){
                if(!open.isEmpty()) open.pop();
                else if(!asstrick.isEmpty()) asstrick.pop();
                else return false;
            }
            else asstrick.push(idx);
            idx++;
        }
        if(open.isEmpty()) return true;
        if(open.size()>asstrick.size()) return false;
        while(!open.isEmpty()){
            if(open.pop()>asstrick.pop()) return false;
        }
        return true;
    }
}
