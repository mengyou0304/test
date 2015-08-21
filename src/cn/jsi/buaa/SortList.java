package cn.jsi.buaa;

import cn.jsi.buaa.basic.DataGen;
import cn.jsi.buaa.basic.ListNode;

public class SortList {
	public ListNode sortList(ListNode head) {
		ListNode p = head;
		int len = 0;
		while (p != null) {
			len++;
			p = p.next;
		}
		ListNode nnode=sorthelper(head, len);
		return nnode;
	}

	public ListNode sorthelper(ListNode head, int len) {
		if (len <= 1)
			return head;
		int len1 = len / 2;
		int len2 = len - len1;
		//System.out.println("len1="+len1+" len2="+len2);
		ListNode p = head;
		ListNode q=null;
		for (int i = 0; i < len1; i++){
			q=p;
			p = p.next;
		}
		if(q!=null)
			q.next=null;
		ListNode l1 = sorthelper(head, len1);
		ListNode l2 = sorthelper(p, len2);
		return merge(l1,len1, l2,len2);
	}

	public ListNode merge(ListNode h1,int len1, ListNode h2,int len2) {
	//	System.out.println("merging... "+len1+"  "+len2);
	//	DataGen.showList(h1);
	//	DataGen.showList(h2);
		ListNode nhead = new ListNode(-1);
		ListNode p = nhead;
		ListNode p1 = h1;
		ListNode p2 = h2;
		while (true) {
			if (p1 == null && p2 == null)
				break;
			if (p2== null) {
				p.next = p1;
				p1 = p1.next;
				p=p.next;
				continue;
			}
			if (p1 == null) {
				p.next = p2;
				p2 = p2.next;
				p=p.next;
				continue;
			}
			if (p1.val < p2.val) {
				p.next = p1;
				p1 = p1.next;
			} else {
				p.next = p2;
				p2 = p2.next;
			}
			p=p.next;
		}
		//System.out.println("after merging... ");
		//DataGen.showList(nhead);
		return nhead.next;
	}

	public static void main(String[] args) {
		SortList sl=new SortList();
		ListNode node=DataGen.getListNode(new int[]{5,4,3,2,1,7,8,9,0,6});
		ListNode node2=sl.sortList(node);
		System.out.println("Last result:  ");
		DataGen.showList(node2);
	}

}
