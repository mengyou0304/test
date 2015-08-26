package com.robin4;

import cn.jsi.buaa.basic.DataGen;
import cn.jsi.buaa.basic.ListNode;

/**
 * Created by robinmac on 15-8-25.
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        ListNode dhead=new ListNode(Integer.MIN_VALUE);
        ListNode p=head,np=dhead,next=null,father=dhead;
        while(p!=null){
            boolean setted=false;
            next=p.next;
            father=dhead;
            np=dhead.next;
            while(np!=null){
                if(p.val>np.val){
                    father=np;
                    np=np.next;
                }
                else{
                    p.next=np;
                    father.next=p;
                    setted=true;
                    break;
                }
            }
            if(!setted){
                father.next=p;
                p.next=null;
            }
            p=next;
        }
        return dhead.next;
    }

    public static void main(String[] args) {
        InsertionSortList is=new InsertionSortList();
        DataGen.showList(is.insertionSortList(DataGen.getListNode(new int[]{Integer.MIN_VALUE,Integer.MIN_VALUE})));


    }
}
