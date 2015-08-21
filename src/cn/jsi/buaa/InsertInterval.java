package cn.jsi.buaa;

import java.util.ArrayList;

import cn.jsi.buaa.basic.Interval;

public class InsertInterval {
	ArrayList<Interval> re=new ArrayList<Interval>();
    byte[] co=new byte[65539];
	public void showCo(){
		System.out.println("\n************\n");
		for(int i=0;i<10;i++)
			System.out.print(co[i]+" ");
	}
    public void color(ArrayList<Interval> intervals, Interval newInterval){
        int len=co.length;
        for(Interval i:intervals){
            for(int j=i.start;j<=i.end;j++)
                co[j]=1;
        }
        for(int i=newInterval.start;i<=newInterval.end;i++)
            co[i]=1;
        int isco=0;
        Interval ni=null;
       
        for(int i=0;i<len;i++){
            if(co[i]==1&&isco==0){
                isco=1;
                ni=new Interval();
                ni.start=i;
            }
            if(co[i]==0&&isco==1){
                isco=0;
                ni.end=i-1;
                re.add(ni);
            }
        }
    }
    public boolean inI(int value,Interval i){
        if(value<=i.start&&value>=i.end)
            return true;
        return false;
    }
    public void force(ArrayList<Interval> intervals, Interval newInterval){
        Interval lasti=null;
        Interval n=newInterval;
        Interval ni=new Interval();
        int type=-1;
        int len=intervals.size();
        if(n.start<=intervals.get(0).start)
            type=1;
        if(n.end>=intervals.get(len-1).end)
            type=2;
        boolean cadd=false;
        for(Interval i:intervals){
           if(type==1){
               if(cadd){
                    re.add(i);
                    continue;
               }
               if(n.end<i.start){
                   re.add(n);
                   cadd=true;
               }
               
               if(inI(n.end,i)){
                   n.end=i.end;
                   re.add(n);
                   cadd=true;
               }
           }
           if(type==2){
           //    if()
           }
        }
        
        
    }
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
      
        color(intervals,newInterval);
        return re;
       
    }
    public static void main(String[] args) {
    	InsertInterval i=new InsertInterval();
    	ArrayList<Interval> data=i.getTestedData();
    	data=i.insert(data, new Interval(5,7));
    	System.out.println(data);
    	
	}
	private ArrayList<Interval> getTestedData() {
		ArrayList<Interval> d=new ArrayList<Interval>();
		//d.add(new Interval(0, 1));
		return d;
	}

}
