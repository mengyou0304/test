package com.robin3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.robin3.utility.DataGen2;

public class WordLadder2 {
	class Point{
        public ArrayList<Point> fathterlist=new ArrayList<Point>();
        public String word;
        public Point(String w){
            word=w;
        }
    }
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        HashMap<String,Point> s1=new HashMap<String,Point>();
        HashMap<String,Point> s2=null;
        dict.remove(start);
        Point starter=new Point(start);
        s1.put(start,starter);
        while(s1.size()>0){
            s2=getNextLevel(s1,dict);
            if(s2.containsKey(end)){
                return genRes(s2.get(end),start);
            }
            s1=s2;
        }
        return new ArrayList<List<String>>();
    }
    ArrayList<List<String>> reslist=new ArrayList<List<String>>();
    public List<List<String>> genRes(Point p,String start){
        dp(p,start,new ArrayList<String>());
        return reslist;
    }
    public void dp(Point p,String start,List<String> list){
        if(!p.word.equals(start)){
            list.add(p.word);
            for(Point son:p.fathterlist){
                dp(son,start,list);
            }
            list.remove(list.size()-1);
        }else{
            ArrayList<String> newlist=new ArrayList<String>();
            newlist.add(start);
            for(int i=list.size()-1;i>=0;i--)
                newlist.add(list.get(i));
            reslist.add(newlist);
        }
    }
    public HashMap<String,Point> getNextLevel(HashMap<String,Point> s1,Set<String> dict){
        HashMap<String,Point> s2=new HashMap<String,Point>();
        HashSet<String> removedSet=new HashSet<String>();
        for(String s:s1.keySet()){
        		//System.out.println("finding for "+s);
            Point cp=s1.get(s);
            char[] cc=s.toCharArray();
            for(int i=0;i<cc.length;i++){
                char oc=cc[i];
                for(int j=0;j<26;j++){
                    cc[i]=(char)('a'+j);
                    String ns=new String(cc);
                    if(dict.contains(ns)){
                        removedSet.add(ns);
                        Point newp=new Point(ns);
                        if(s2.containsKey(ns)){
                            newp=s2.get(ns);
                        }else
                        		s2.put(ns,newp);
                        newp.fathterlist.add(cp);
                       // System.out.println("add linke: "+newp.word+" ->"+cp.word);
                    }
                }
                cc[i]=oc;
            }
        }
        for(String removedS:removedSet)
        		dict.remove(removedS);
        return s2;
    }
    public static void main(String[] args) {
    		WordLadder2 wl=new WordLadder2();
    		HashSet<String> dict=new HashSet<String>();
    		String[] ss=new String[]{"hot","cog","dog","tot","hog","hop","pot","dot"};
    		for(String s:ss)
    			dict.add(s);
    		DataGen2.ShowLL(wl.findLadders("hot", "dog", dict));
	}
}
