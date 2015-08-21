package com.robin3;

public class SearchInRo2 {
	public boolean search(int[] a, int target) {
        if(a.length==0)
            return false;
        int i=findEnd(a);
        System.out.println("find end as:"+i);
        if(target==a[0])
            return true;
        if(target<a[0])
            return search(a,target,i+1,a.length-1);
        else
            return search(a,target,0,i);
    }
    private int findEnd(int[] a) {
    		Integer cv=null;
    		for(int i=0;i<a.length;i++){
    			if(cv!=null&&cv>a[i])
    				return i-1;
    			cv=a[i];
    		}
    		return a.length-1;
	}
	public boolean search(int[] a,int t,int start,int end){
        int st=start;
        int ed=end;
        if(st>ed)
        		return false;
        while(ed-st>1&&a[st]!=a[ed]){
            int mid=(st+ed)/2;
            if(a[mid]==t)
                return true;
            if(a[mid]<t)
                st=mid;
            else
                ed=mid;
        }
        if(t==a[st]||t==a[ed])
            return true;
        return false;
    }
	public static void main(String[] args) {
		SearchInRo2 si=new SearchInRo2();
		boolean b1=si.search(new int[]{1},0);
		//b1=si.search(new int[]{5,6,7,8,1,5,5,5,5,5},2);
		System.out.println(b1);
		
		
	}
	

}
