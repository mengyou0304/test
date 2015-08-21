package cn.jsi.buaa;

public class ValidNumber {
	char[] ss;
	int etimes = 0;

	public boolean ispureNum(int start, int end) {
		if (start > end)
			return false;
		if((ss[start]=='-'||ss[start]=='+')&&((start+1)<=end))
		    start++;
		for (int i = start; i <= end; i++) {
			if (ss[i] < '0' || ss[i] > '9')
				return false;
		}
		return true;
	}

	public boolean isPorPEP(int start, int end, boolean allowEP) {
	//	System.out.println("calling isppep  "+start+"  "+end+"  "+allowEP);
		if (start > end)
			return false;
		boolean fu=false;
		for (int i = start; i <= end; i++) {
			if (ss[i] < '0' || ss[i] > '9')
				if (ss[i] == 'e' || ss[i] == 'E') {
					etimes++;
					if (etimes >= 2)
						return false;
					if (!allowEP && !ispureNum(start, i - 1))
						return false;
					if (!ispureNum(i + 1, end))
						return false;
					break;
				} else
					    return false;
		}
		return true;
	}

	public boolean m1(String s) {
		s = s.trim();
		int len2 = s.length();
		int len3 = s.replaceAll(" ", "").length();
		if (len2 == 0 || len3 < len2)
			return false;

		ss = s.toCharArray();
		int pointTimes = 0;
		int start = 0;
		boolean haveE=false;
		boolean haveP=false;
		if (ss[start] == '-' || ss[start] == '+') {
			start++;
		}
		for (int i = start; i < ss.length; i++) {
		    if(ss[i]=='.'){
		        if(haveP) return false;
    		        haveP=true;
		    }
		    if(ss[i]=='e'||ss[i]=='E'){
		        if(haveE) return false;
		            haveE=true;
		    }
		}
		if(!haveP)
	    	if (isPorPEP(start, len2 - 1, false)){
			    return true;
	    	}else return false;
			   
		for (int i = start; i < ss.length; i++) {

			if (ss[i] < '0' || ss[i] > '9') {
				// null.
				if (ss[i] == '.') {
					pointTimes++;
					if (pointTimes >= 2)
						return false;
					if (i == start) {
						if (!isPorPEP(start + 1, len2 - 1, false))
							return false;
					}
					// P.
					else {
						if (!ispureNum(start, i - 1))
							return false;
						if (i == len2 - 1)
							return true;
						if (!isPorPEP(i + 1, len2 - 1, true))
							return false;
					}
					break;
				}
					else return false;
			}
		}
		return true;
	}
    public boolean m2(String s){
        return false;
    }
	public boolean isNumber(String s) {
		return m1(s);
	}
	public static void main(String[] args) {
		String s="46e+3";
		System.out.println(s);
		ValidNumber v=new ValidNumber();
		boolean b=v.isNumber(s);
		System.out.println(b);
	}
}
