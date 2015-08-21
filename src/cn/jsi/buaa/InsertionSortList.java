package cn.jsi.buaa;

import cn.jsi.buaa.basic.ListNode;

public class InsertionSortList {
	 ListNode nh=new ListNode(-1);
     ListNode nhw=null;
     ListNode tmp=null;
    public void insert(ListNode node){
         nhw=nh;
        if(nhw.next==null){
            nhw.next=node;
            nhw=node;
            nhw.next=null;
            return;
        }
        int x=node.val;
        while(nhw!=null){
            tmp=nhw;
            nhw=nhw.next;
            if(nhw==null){
            	tmp.next=node;
            	node.next=null;
            	return;
            }
            if(nhw.val<x)
                 continue;
            tmp.next=node;
            node.next=nhw;
            return;
         }
    }
    public ListNode m1(ListNode head){
        ListNode wl=head;
        ListNode tl=head;
        while(wl!=null){
            tl=wl;
            wl=wl.next;
            insert(tl);
        }
        return nh.next;
    }
    public ListNode insertionSortList(ListNode head) {
        nhw=nh;
        if(head==null||head.next==null)
          return head;
         return m1(head);
    }
    public ListNode getTestData() {
		ListNode head = new ListNode(3);
		ListNode l1 = new ListNode(2);
		ListNode l2 = new ListNode(4);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		head.next = l1;
		l1.next =l2;
		l2.next = null;
		l3.next = l4;
		l4.next = null;
		// return null;
		return head;

	}
    public static void main(String[] args) {
    	InsertionSortList i=new InsertionSortList();
    	ListNode node=	i.getTestData();
    	i.insertionSortList(node);
	}
}
