package lab2;

public class Task1_2 {
	public static int getFibonacci(int n ) {
		if (n<=1)
		return n;
		else 
		return getFibonacci(n-1) + getFibonacci(n-2);
		
		
	}
	public static void main(String[] args) {
		int re = getFibonacci(3);
		System.out.println(re);
	}

}
