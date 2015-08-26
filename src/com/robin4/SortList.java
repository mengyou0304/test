package com.robin4;

import cn.jsi.buaa.basic.ListNode;

/**
 * Created by robinmac on 15-8-26.
 */
public class SortList {

    //split and merge
    private void s1(ListNode head){
        ListNode node=findMid(head);
        sort(head,node);

    }
    private ListNode findMid(ListNode head){
        ListNode p=head;
        ListNode p2=head;
        while(p2!=null){
            if(p2.next==null)
                return p;
            p2=p2.next.next;
            p=p.next;
        }
        return p;
    }

    private void s2(ListNode dhead){


    }
    public ListNode sortList(ListNode head) {
        ListNode dhead=new ListNode(-1);
        dhead.next=head;


    }
}
