class Solution {
    public int[] asteroidCollision(int[] asteroids) {
       Stack<Integer> stack = new Stack<>();
       int n=asteroids.length;
       List<Integer> list = new ArrayList<>();
       for(int i=n-1 ;i>=0 ;i--){
          if(asteroids[i]<0) stack.push(-1*asteroids[i]);
          else{
            while(!stack.isEmpty() && asteroids[i]>stack.peek()) stack.pop();

            if(stack.isEmpty()) list.add(asteroids[i]); //bchgya current
            else if(asteroids[i]==astack.peek()) stack.pop(); //dono asteroid gye!
            //else //gya current
           }
       }

       int residual=list.size()+stack.size();
       int[] result = new int[residual];
       int idx=0;
       for(int i=stack.size() ;i<residual ;i++){
         result[i]=list.get(list.size()-1-idx++);
       }    

       idx=0;
       while(!stack.isEmpty()){
          result[idx++]=-1*stack.pop();
       }
       return result;
    }
}
