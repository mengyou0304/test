package cn.jsi.buaa;

import java.util.ArrayList;

import cn.jsi.buaa.basic.DataGen;
import cn.jsi.buaa.basic.ListNode;

public class MergeKSortedArray {

	public static void main(String[] args) {
		MergeKSortedArray mk = new MergeKSortedArray();
		ArrayList<ListNode> in = new ArrayList<ListNode>();
		for (int i = 1; i<=6; i++) {
			ListNode node = DataGen.getListNode(new int[] { i,  7*i, 11*i,13*i, });
			in.add(node);
		}
		ListNode head=mk.mergeKLists(in);
		DataGen.showList(head);
	}

	public ListNode mhelper(ArrayList<ListNode> lists) {
		int n = lists.size();
		if (n == 1)
			return lists.get(0);
		int k = (n + 1) / 2;
		ArrayList<ListNode> list1 = new ArrayList<ListNode>();
		ArrayList<ListNode> list2 = new ArrayList<ListNode>();
		ArrayList<ListNode> tlist;
		tlist = list1;
		for (int i = 0; i < n; i++) {
			if (i >= k)
				tlist = list2;
			tlist.add(lists.get(i));
		}
		ListNode l1 = mhelper(list1);
		ListNode l2 = mhelper(list2);
		ListNode tl = mergSort(l1, l2);
		return tl;
	}

	private ListNode mergSort(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(-1);
		ListNode p = head;
		while (true) {
			if (l1 == null && l2 == null)
				break;
			if (l1 == null) {
				p.next = l2;
				p = p.next;
				l2 = l2.next;
				continue;
			}
			if (l2 == null) {
				p.next = l1;
				p = p.next;
				l1 = l1.next;
				continue;
			}
			if (l1.val < l2.val) {
				p.next = l1;
				l1 = l1.next;
				p = p.next;
			} else {
				p.next = l2;
				l2 = l2.next;
				p = p.next;
			}
		}
		return head.next;
	}

	public ListNode mergeKLists(ArrayList<ListNode> lists) {
		ListNode head = mhelper(lists);
		return head;
	}

}
