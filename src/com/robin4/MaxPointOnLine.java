package com.robin4;

import com.robin3.utility.Point;

import java.util.HashMap;

/**
 * Created by robinmac on 15-8-27.
 */
public class MaxPointOnLine {


    public int maxPoints(Point[] points) {
        if(points==null||points.length==0)
            return 0;
        int maxnum=0;
        for(int i=0;i<points.length;i++){
            HashMap<Double,Integer> map=new HashMap<Double,Integer>();
            int cmax=0;
            int onlineNum=0;
            int selfsameNum=0;
            for(int j=i+1;j<points.length;j++){
                Double k1=1d*(points[j].y-points[i].y);
                Double k2=1d*(points[j].x-points[i].x);
//                if(k2!=0)
//                    System.out.println("["+i+"]["+j+"]k="+k1/k2);
//                else
//                    System.out.println("["+i+"]["+j+"]0");
                if(k1==0&&k2==0)
                    selfsameNum++;
                else if(Math.abs(k2)==0)
                    onlineNum+=1;
                else{
                    Double k=k1/k2;
                    if(k==-0.0d)
                        k=0d;
                    Integer value=map.get(k);
                    if(value==null) {
                        value = 0;
                    }
                    value+=1;
                    cmax=Math.max(cmax,value);
                    map.put(k,value);
                }
            }
            cmax=Math.max(onlineNum,cmax);
            maxnum=Math.max(maxnum,cmax+selfsameNum);
//            System.out.println("\n maxnum="+maxnum);
        }
        return maxnum+1;
    }

    public static void main(String[] args) {
        MaxPointOnLine ml=new MaxPointOnLine();
        int[] values=new int[]{84,250,0,0,1,0,0,-70,0,-70,1,-1,21,10,42,90,-42,-230};
        Point[] ps=new Point[values.length/2];
        for(int i=0;i<ps.length;i++){
            ps[i]=new Point(values[i*2],values[i*2+1]);
        }
        System.out.println(ml.maxPoints(ps));
    }

}
