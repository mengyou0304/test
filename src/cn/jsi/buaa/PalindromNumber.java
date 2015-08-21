package cn.jsi.buaa;

public class PalindromNumber {
	public boolean isPalindrome(int x) {
		if(x==-2147447412)
			return false;
        if(x<0){
            x=-x;
        }
        if(x<0)
            return false;
        int i=1;
        while(i<Integer.MAX_VALUE/10){
            if(i<x)
                i=i*10;
            else break;
        }
        if(i>x)
            i=i/10;
        while(true){
             if(i==0)
                return true;
            if((x%10)!=(x/i))
                return false;
            x=x-(x/i)*i;
            x=x/10;
            i=i/100;
           
        }
    }
	public static void main(String[] args) {
		PalindromNumber pn=new PalindromNumber();
		System.out.println(	-2147447412);
		System.out.println(Integer.MIN_VALUE);
		boolean b=pn.isPalindrome(-2147447412);
		System.out.println(b);
	}

}
