package cn.jsi.buaa;

public class BestTimeStock {
	int buyprice;
	int candiprice;
	int lastmax = -1;
	int profit = 0;
	boolean debug=false;
	boolean goingup = false;
	boolean havestock = false;

	public void buy() {
		havestock = true;
		buyprice = candiprice;
		if(debug)
		System.out.println("buy @"+candiprice);
	}

	public void sell() {
		havestock = false;
		profit += lastmax - buyprice;
		if(debug)
		System.out.println("sell :"+lastmax+" ->"+buyprice);
	}

	public int maxProfit(int[] p) {
		if (p.length == 0)
			return 0;
		int value = 0;
		candiprice = p[0];
		lastmax=p[0];
		for (int i = 1; i < p.length; i++) {
			if(debug)
			System.out.println(p[i]+"\t  havestock:"+havestock+"  goingup:"+goingup+"  candiprice:"+candiprice+"   lastmax:"+lastmax);
			value = p[i];
			if (value >= lastmax) {
				if (havestock== false)
					buy();
				goingup = true;
				lastmax = value;
			} else {
				if (havestock)
					sell();
				lastmax=value;
				candiprice=value;
				goingup = false;
			}
		}
		if (havestock)
			sell();
		return profit;

	}

	public static void main(String[] args) {
		BestTimeStock bs=new BestTimeStock();
		int profit=bs.maxProfit(new int[]{1,4,0,8,9,9,10,6,1,2,5});
		System.out.println("P:"+profit);
	}

}
