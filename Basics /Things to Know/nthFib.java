
import java.util.Scanner;
public class Solution {

	public static int fib(int n){
		int n1=1;
		int n2=1;

		for(int i=3; i<=n ;i++){
			int temp = n2;
			n2 = n2+n1;
			n1 = temp;
		}
		return n2;

		// if(n<=2) return 1;  using recurssion
		// return fib(n-1) + fib(n-2);
	}

	public static void main(String[] args) {
		
		/* Your class should be named Solution.
	 	* Read input as specified in the question.
	 	* Print output as specified in the question.
		*/
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		System.out.print(fib(n));
		
	}

}
