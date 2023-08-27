import java.util.Scanner;
public class Main {
	
	 static int numOfDigits(int n){
        int count=0;
        while(n>0){
            n/=10;
            count++;
        }
        return count;
    }
    static boolean check(int n ){
        int num=n;
        int ArmSum=0;
        int digits = numOfDigits(n);
        
        while(num>0){
            ArmSum += (int)Math.pow(num%10 ,digits );
            num/=10;
        }
        
        return ArmSum==n;
    }
	public static void main(String[] args) {
		// Write your code here
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(check(n));

	}
}
