
class Solution {
    public static int totalFruits(int N, int[] fruits) {
        HashMap<Integer , Integer> map = new HashMap<>();
        int i=0;
        int j=0;
        int n=fruits.length;
        int result=0;
        while(j<n){
            map.put(fruits[j] , map.getOrDefault(fruits[j],0)+1);
            while(i<=j && map.size()>2){
                map.put(fruits[i] , map.get(fruits[i])-1);
                if(map.get(fruits[i])==0) map.remove(fruits[i]);
                i++;
            }
            result=Math.max(result , j-i+1);
            j++;
        }
        return result;
    }
}
