class Solution {
    public int[][] merge(int[][] intervals) {
       Arrays.sort(intervals , (a , b)->a[0]-b[0]);
       List<int[] > list = new ArrayList<>();

       for(int i=0 ;i<intervals.length ;i++){
           if(i==0 || intervals[i][0] > list.get(list.size()-1)[1]) {
               list.add(intervals[i]);
           }
           else{
              int endOfLast = list.get(list.size()-1)[1];
              int maxEnd = Math.max(intervals[i][1] , endOfLast);
              list.get(list.size()-1)[1] = maxEnd;

           }
       }
       return list.toArray(new int[0][]);
    }
}
