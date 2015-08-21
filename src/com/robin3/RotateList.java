package com.robin3;

import cn.jsi.buaa.basic.ListNode;

public class RotateList {
	public ListNode rotateRight(ListNode head, int n) {
        if(n==0)
            return head;
        ListNode dhead=new ListNode(-1);
        dhead.next=head;
        ListNode p=dhead;
        int num=0;
        while(p.next!=null){
            num++;
            p=p.next;
        }
        if(n>=num)
            return head;
        ListNode last=p;
        int v=num-n;
        num=0;
        p=dhead;
        while(p!=null){
            num++;
            p=p.next;
            if(num==v)
                break;
        }
        last.next=head;
        last=p.next;
        p.next=null;
        return last;
    }

}
