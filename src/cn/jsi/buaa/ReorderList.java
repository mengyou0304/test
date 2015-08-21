package cn.jsi.buaa;

import cn.jsi.buaa.basic.DataGen;
import cn.jsi.buaa.basic.ListNode;

public class ReorderList {
	public static void main(String[] args) {
		ReorderList r=new ReorderList();
		ListNode h1=DataGen.getListNode(new int[]{1,2,3,4,5,6});
		ListNode h2=DataGen.getListNode(new int[]{1,2,3,4,5});
		ListNode h3=DataGen.getListNode(new int[]{1});
		
		ListNode th=h2;
		DataGen.showList(th);
		ListNode res=r.reorderList(th);
		System.out.println();
		DataGen.showList(res);
	}
	 public ListNode reorderList(ListNode head) {
		 if(head==null||head.next==null||head.next.next==null)
			 return head;
	        ListNode p=head;
	        ListNode t,l;
	     //   ListNode nh=head,nt;
	        int num=1;
	        int part=0;
	        while(p.next!=null){
	            t=p;
	            p=p.next;
	            num++;
	        }
	        part=num/2;
	        int i=0;
	        p=head;
	        num=0;
	        while(p.next!=null){
	            p=p.next;
	            num++;
	            if(num>=part)
	            	break;
	            
	        }
	    //    System.out.println("part="+part+" num="+ num+" middle is"+p.val);
	        t=p.next;
	        p.next=null;
	        while(t.next!=null){
	            l=t.next;
	            t.next=p;
	            p=t;
	            t=l;
	        }
	        t.next=p;
	        int m=0;
	        ListNode oh=new ListNode(-1);
	        ListNode th;
	        p=oh;
	        while(true){
	        	if(m++%2==0&&head!=null){
	        		th=head;
	        		head=head.next;
	        	}
	        	else{
	        		th=t;
	        		t=t.next;
	        	}
	        	p.next=th;
	        	p=th;
	     //   	System.out.println("th="+th.val+" th.next"+th.next);
	        	if(th.next==null)
	        		break;
	     
	        }
	        return oh.next;
	    }
}
