package com.robin3;

public class Pow {
	public double pow(double x, int n) {
		double res = 1;
		double num = x;
		boolean isneg = false;
		if (n < 0) {
			n = -n;
			isneg = true;
		}
		while (n > 0) {
			if (n % 2 == 1)
				res = res * num;
			num = num * num;
			n = n >>1;
		}
		if (isneg && res != 0)
			res = 1 / res;
		return res;
	}

	public static void main(String[] args) {
		Pow p = new Pow();
		double d = p.pow(8.88023, 3);
		System.out.println(d);
	}

}
