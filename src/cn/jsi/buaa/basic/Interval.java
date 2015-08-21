package cn.jsi.buaa.basic;

public class Interval {
	public Integer start;
	public Integer end;

	public Interval() {
	}

	public Interval(int s, int e) {
		start = s;
		end = e;
	}
	@Override
	public String toString() {
		return ""+start+","+end;
	}

}
