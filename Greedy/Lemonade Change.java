class Solution {
    public boolean giveChange(int[]change , int toGive){
        if(toGive==15 && change[1]!=0){
            toGive=5;
            change[1]--;
        }
        //toGive == 10 or 5
        int notesNeeded=toGive/5;
        if(change[0]>=notesNeeded){ //5 rupay notes needed
            change[0]-=notesNeeded;
            return true;
        }
        else return false;
    }
    public boolean lemonadeChange(int[] bills) {
        int[]change = {0 ,0};
        for(int i=0;i<bills.length;i++){
            if(bills[i]==5) change[0]++;
            else if(bills[i]==10) change[1]++;

            if(bills[i]==5)continue;
            else if(!giveChange(change , bills[i]-5)) return false;
        }
        return true;
    }
}
