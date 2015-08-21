package cn.jsi.buaa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class WorldLadder {
	int[][] con;
    ArrayList<String> slist=new ArrayList<String>();
    HashMap<Integer,Integer> checked=new HashMap<Integer,Integer>();
    public boolean canConnect(String s1,String s2){
       char[] c1=s1.toCharArray();
       char[] c2=s2.toCharArray();
       int len=c2.length;
       int dif=0;
       for(int i=0;i<len;i++){
           if(c1[i]!=c2[i])
               dif++;
           if(dif>1)
               return false;
       }
       return true;
   }
   public boolean canGo(int place1,int place2){
       int tmp=-1;
       if(place1>place2){
           tmp=con[place2][place1];
       }
       else tmp=con[place1][place2];
       if(tmp==1)
           return true;
       else 
           return false;
   }
   public int bfs(String s, String e){
       int len=slist.size();
       ArrayList<Integer> plist=new ArrayList<Integer>();
       ArrayList<Integer> step=new ArrayList<Integer>();
       int currentstep=0;
       int currentNumber=0;
       plist.add(0);
       step.add(1);
       while(currentNumber<plist.size()){
           int from=plist.get(currentNumber);
           for(int i=1;i<len;i++){
               if(i==1&&canGo(from,i))
                   return currentstep;
               if(checked.get(i)==null&&canGo(from,i)){
                    plist.add(i);
                    checked.put(i,1);
               }
           }
           currentNumber++;
           if(currentNumber==step.get(currentstep)){
               currentstep++;
               step.add(plist.size());
           }
       }
       return 0;
   }
   public int ladderLength(String start, String end, HashSet<String> dict) {
       int len=dict.size();
   
       con=new int[len+5][len+5];
       slist.add(start);
       slist.add(end);
       Iterator<String> it=dict.iterator();
       while(it.hasNext()){
           slist.add(it.next());
       }
       for(int i=0;i<slist.size();i++)
           for(int j=i+1;j<slist.size();j++)
               if(canConnect(slist.get(i),slist.get(j)))
                   con[i][j]=1;
               else
                   con[i][j]=0;
     //  return 1;
       return bfs(start,end);
   }
	public static void main(String[] args) {
		
		HashSet<String> s=new HashSet<String>();
		s.add("a");
		s.add("b");
		String[] ss=s.toArray(new String[0]);
		System.out.println(ss.length);
		String s1="dog";
		String s2="bog";
		s1.toCharArray();
	//	s.add(e)
		
	}
	
}
