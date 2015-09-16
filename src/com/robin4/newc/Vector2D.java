package com.robin4.newc;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by robinmac on 15-9-8.
 */
public class Vector2D {

    public Vector2D(List<List<Integer>> vec2d) {
        this.vec=vec2d;
    }

    List<List<Integer>> vec;
    int y=0;
    int x=0;
    Integer buff=null;

    public Integer realNext(){
        if(y>=vec.size())
            return -1;
        if(vec.get(y)==null||x>=vec.get(y).size()){
            y++;
            x=0;
            return realNext();
        }
        return vec.get(y).get(x);
    }

    public int next() {
        if(buff!=null){
            int v=buff;
            buff=null;
            return v;
        }
        if(!hasNext())
            return -1;
        return buff;
    }

    public boolean hasNext() {
        if(buff!=null)
            return true;
        buff=realNext();
        if(buff!=null)
            return true;
        return false;
    }

    public static void main(String[] args) {
        List<List<Integer>> list=new ArrayList<List<Integer>>();
        Vector2D v2=new Vector2D(list);
        v2.hasNext();
        v2.hasNext();
        v2.next();
        v2.next();
    }
}
