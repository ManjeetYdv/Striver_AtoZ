import java.util.Scanner;

public class Main {
	
	public static void evenOdd(int n ){
		int even=0;
		int odd=0;

		while(n>0){
			int l = n%10;
			n/=10;
		
			if(l%2==0) even+=l;
			else odd+=l;
		}
		System.out.println(even+  " "+odd);
	}
	public static void main(String[] args) {
		// Write your code here
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		evenOdd(n);
	}
}
