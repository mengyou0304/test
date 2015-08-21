package com.robin3;

import java.util.ArrayList;
import java.util.List;

public class TextJustify {
	int len=0;
    ArrayList<String> reslist=new ArrayList<String>();
    public List<String> fullJustify(String[] words, int len) {
        this.len=len;
        int baselen=0;
        ArrayList<String> tmplist=new ArrayList<String>();
        for(int i=0;i<words.length;i++){
            if(len-baselen>=words[i].length()){
                tmplist.add(words[i]);
                baselen+=words[i].length()+1;
            }else{
                reslist.add(formLine(tmplist,1+len-baselen));
                tmplist.clear();
                baselen=0;
                i--;
            }
        }
        if(tmplist.size()>0)
        		reslist.add(formLine(tmplist,len-baselen));
        return reslist;
    }
    String formLine(ArrayList<String> list,int freespace){
        //size==1
        if(list.size()==1)
            return list.get(0)+getFreespace(len-list.get(0).length());
        //size>1
        int espace=freespace/(list.size()-1);
        int yuspace=freespace-espace*(list.size()-1);
        String line="";
        for(int i=0;i<list.size();i++){
            line+=list.get(i);
            if(i!=list.size()-1)
                line+=getFreespace(espace+1);
            if(i<=yuspace-1)
                line+=" ";
        }
        return line;
    }
    String getFreespace(int n){
        String s="";
        for(int i=0;i<n;i++)
            s+=" ";
        return s;
    }
    public static void main(String[] args) {
    		TextJustify  tj=new TextJustify();
    		List<String> slist=tj.fullJustify(new String[]{"What","must","be","shall","be."}, 12);
    		for(String s:slist){
    			System.out.println("["+s.length()+"]"+s+"|");
    		}
	}

}
