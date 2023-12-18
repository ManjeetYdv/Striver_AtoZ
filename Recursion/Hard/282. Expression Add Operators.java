class Solution {
    public void helper(int index , String num , int target ,String str , long total  , long prevNum , List<String> res){
        if(index==num.length()){
            if(total == target) res.add(str);
            return;
        }
        
        long operand=0;
        String op ="";
        for(int i=index ;i<num.length() ;i++){
            if(i>index && num.charAt(index)=='0') break;

            operand = operand*10 + (num.charAt(i)-'0');
            op+=num.charAt(i)-'0';

            if(index==0){
                helper(i+1 , num , target , op  , operand , operand , res);
            }
            else{
                helper(i+1 , num , target , str+"+"+op , total+operand , operand , res) ;
                helper(i+1 , num , target , str+"-"+op , total-operand , -operand , res);
                helper(i+1 , num , target , str+"*"+op , total-prevNum + (prevNum*operand) , prevNum*operand , res);
            }
        }


    }
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        helper(0 , num , target , "" , 0 , 0 , res);
        return res;
    }
}
