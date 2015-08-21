package cn.jsi.buaa;

import java.util.ArrayList;

import cn.jsi.buaa.basic.DataGen;
import cn.jsi.buaa.basic.ListNode;

public class RemoveD2 {
	ArrayList<Integer> list = new ArrayList<Integer>();

	public void debuglist(ListNode head) {
		ListNode p = head;
		int i = 0;
		while (p != null) {
			System.out.println("[" + list.get(i) + "] " + p.val);
			p = p.next;
			i++;
		}
	}

	public ListNode m2(ListNode head) {
		ListNode nh=new ListNode(-9999);
		nh.next=head;
		ListNode p=nh;
		int lv=-9997;
		while(p!=null){
			if(lv!=p.val)
				list.add(0);
			else{
				list.remove(list.size()-1);
				list.add(1);
				list.add(1);
			}
			lv=p.val;
			p=p.next;
		}
		ListNode l=nh;
		p=nh;
		for(int i=1;i<list.size();i++){
			p=p.next;
			if(list.get(i)==0){
				l.next=p;
				l=p;
			}
		}
		l.next=null;
		return nh.next;
		
	}

	public ListNode m1(ListNode head) {
		ListNode nh = new ListNode(-99999);
		nh.next = head;
		ListNode p, t, l;
		p = nh;
		l = p;
		int bv = -999999;
		int v;
		boolean haved = false;
		while (p.next != null) {
			if (p.next.next != null & p.next.val != p.val
					&& p.next.next.val != p.next.val)
				l = p;
			p = p.next;
			v = p.val;
			// judege if have duplicated data
			if (v == bv) {
				haved = true;
			} else {
				// changelink
				if (haved) {
					haved = false;
					l.next = p;
				}
				// init values
				bv = v;
			}
		}
		return nh.next;
	}

	public ListNode deleteDuplicates(ListNode head) {
		return m2(head);
		// return m1(head);

	}

	public static void main(String[] args) {
		RemoveD2 d = new RemoveD2();
		ListNode head = DataGen
				.getListNode(new int[] { 0, 1, 1, 2, 2, 3, 4, 4 ,4});
		head = d.deleteDuplicates(head);
		DataGen.showList(head);
	}
}
