package com.robin3;

import cn.jsi.buaa.basic.DataGen;
import cn.jsi.buaa.basic.ListNode;

public class RemoveDuplica {
	public ListNode deleteDuplicates(ListNode head) {
		ListNode dhead = new ListNode(-1);
		dhead.next = head;
		ListNode p = head;
		ListNode last = dhead;
		ListNode starter = dhead;
		Integer v = Integer.MAX_VALUE;
		boolean haveSame = false;
		while (p != null) {
			if (p.val == 
					v) {
				last = p;
				p = p.next;
				haveSame = true;
			} else {
				if (haveSame) {
					starter.next = last;
					haveSame = false;
				}
				v = p.val;
				starter = last;
				last = p;
				p = p.next;
			}
		}
		return dhead.next;
	}
	public static void main(String[] args) {
		RemoveDuplica rd=new RemoveDuplica();
		rd.deleteDuplicates(DataGen.getListNode(new int[]{1}));
	}
}
