import java.util.* ;
import java.io.*; 
public class Solution
{
	public static ArrayList<Integer> findArrayIntersection(ArrayList<Integer> arr1, int n, ArrayList<Integer> arr2, int m)
	{
		// Write Your Code Here
		int i=0;
        int j=0;
        ArrayList<Integer> res = new ArrayList<>();
        
        while(i!=n && j!=m){
            int a = arr1.get(i);
            int b = arr2.get(j);
            
            if(a>b) j++;
            else if(b>a) i++;
            else {
                res.add(a);
                i++;
                j++;
            }
        }
        return res;
	}

}
