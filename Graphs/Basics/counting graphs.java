public class Solution {
    
    public static int countingGraphs(int N) {
        // Write your code here.
        //ans = 2^ (nc2)
        //total nc2 edges and every edge has a choice of being there or not

        int maxEdges = N*(N-1)/2;
        return (int)Math.pow(2 , maxEdges);
    }
}
