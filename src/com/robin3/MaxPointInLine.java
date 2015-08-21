package com.robin3;

import java.util.HashMap;

import com.robin3.utility.Point;

public class MaxPointInLine {
	public int maxPoints(Point[] p) {
		if (p.length == 0)
			return 0;
		int max = 1;
		for (int i = 0; i < p.length; i++) {
			HashMap<Double, Integer> map = new HashMap<Double, Integer>();
			int inline = 1;
			int base = 0;
			int imax = 1;
			for (int j = i + 1; j < p.length; j++) {
				if (p[i].x == p[j].x && p[i].y == p[j].y) {
					base++;
					continue;
				}
				if (p[i].x == p[j].x) {
					inline++;
					continue;
				}
				Double k = 1d * (p[i].y - p[j].y) / (p[i].x - p[j].x);
				if(k==0d)
					k=0d;
				System.out.println("k="+k);
				Integer value = map.get(k);
				if (value == null)
					value = 1;
				map.put(k, value + 1);
				imax = Math.max(imax, value + 1);
			}
			imax = Math.max(imax, inline);
			max = Math.max(max, imax + base);
		}
		return max;
	}
	public static void main(String[] args) {
		MaxPointInLine mp=new MaxPointInLine();
		Point[] ps=new Point[3];
		ps[0]=new Point(2,3);
		ps[1]=new Point(3,3);
		ps[2]=new Point(-5,3);
		int v=mp.maxPoints(ps);
		System.out.println(v);
	}

}
