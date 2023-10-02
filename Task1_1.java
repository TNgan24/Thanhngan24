
package lab2;

public class Task1_1 {
	public static int getSn1(int n) {
		if (n == 1)
			return 1;
		else
			return getSn1(n - 1) + (int) Math.pow(-1, n + 1) * n;

	}

	public static int giaiThua(int n) {
		if (n == 1)
			return 1;
		else
			return n * giaiThua(n - 1);

	}

	public static int getSn2(int n) {
		if (n == 1)
			return 1;
		else
			return getSn2(n - 1) + giaiThua(n);

	}

	public static int getSn3(int n) {
		if (n == 1)

			return 1;
		else
			return (int) Math.pow(n, 2) + getSn3(n - 1);

	}
	public static int get (int m) {
		if (m<=1)
			return 1;
		else {
			return m * get (m-1);
		}
	}
	public static double getSn4 (int n) {
		if (n==1)
			return 1.0;
		else
			return 1.0/get (2*n)+getSn4 (n-1);
		
		
	}

	public static void main(String[] args) {
		int re = getSn1(5);
		System.out.println(re);

		int re2 = getSn2(3);
		System.out.println(re2);

		int re3 = getSn3(2);
		System.out.println(re3);
		
		double re4 = getSn4 (3);
		System.out.println(re4);
				

	}
}
