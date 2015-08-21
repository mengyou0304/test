package cn.jsi.buaa;

import cn.jsi.buaa.basic.ListNode;

public class RemoventhNode {
	 public ListNode removeNthFromEnd(ListNode head, int n) {
	        ListNode p=head,q=head;
	        for(int i=0;i<n;i++)
	            p=p.next;
	        if(p==null)
	        	return head.next;
	        while(p.next!=null){
	            p=p.next;
	            q=q.next;
	        }
	        if(n==1)
	            q.next=null;
	        else
	            q.next=q.next.next;
	        return head;
	    }
	 public static void main(String[] args) {
		
	}

}
