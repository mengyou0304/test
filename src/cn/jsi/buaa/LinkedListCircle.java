package cn.jsi.buaa;

import cn.jsi.buaa.basic.ListNode;

public class LinkedListCircle {
	public boolean hasCycle(ListNode head) {
		if (head == null)
			return false;
		ListNode circleNode = new ListNode(9999);
		circleNode.next = null;
		ListNode tmpNode = head;
		ListNode backnode = null;
		while (tmpNode != null) {
			if (tmpNode.equals(circleNode))
				return true;
			backnode = tmpNode;
			tmpNode = tmpNode.next;
			backnode.next = circleNode;
		}
		return false;
	}

	public ListNode detectCycle(ListNode head) {
		ListNode endnote = new ListNode(-9999);
		ListNode end2 = new ListNode(-9998);
		endnote.next = end2;
		end2.next = null;
		ListNode tmp = head;

		ListNode last = null, last2 = null;

		while (tmp != null) {
			if (tmp.val == -9999)
				return last;
			last2 = last;
			last = tmp;
			tmp = tmp.next;
			last.next = endnote;
		}
		return null;

	}

	public ListNode method1(ListNode head) {
		if (head == null)
			return null;
		if (head.next.equals(head))
			return head;
		ListNode a = head;
		ListNode b = head;
		while (a != null) {
			a = a.next;
			if (a == null || a.next == null)
				return null;
			b = head;
			// System.out.println("\n\na goes as "+a.val);
			while (true) {
				// System.out.println("a="+a.val+"  b="+b.val+"  b.equals(a.next)="+b.equals(a.next));
				if (b.equals(a.next))
					return b;
				else
					b = b.next;
				// System.out.println("after go next a="+a.val+"  b="+b.val+"  b.equals(a.next)="+b.equals(a.next));
				// System.out.println("b.equals(a)="+b.equals(a)+"   a.next.equals(a)="+a.next.equals(a));
				if (b.equals(a)) {
					if (a.next.equals(a))
						return a;
					else
						break;
				}
			}
		}
		return null;
	}

	public ListNode method2(ListNode head){
		 ListNode a=head;
	     ListNode b=head;
	     ListNode c=head;
	        while(true){
	            if(a==null||a.next==null)
	                return null;
	            a=a.next.next;
	            b=b.next;
	            if(b.equals(a)){
	            	while(true){
	            		if(c.equals(b))
	            			return c;
	            		c=c.next;
	            		b=b.next;
	            		
	            	}
	                
	            }
	        }
	}

	public ListNode getTestData() {
		ListNode head = new ListNode(0);
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		head.next = l1;
		l1.next =l2;
		l2.next = l3;
		l3.next = head;
		l4.next = l4;
		// return null;
		return head;

	}

	public static void main(String[] args) {
		LinkedListCircle c = new LinkedListCircle();
		ListNode node = c.method2(c.getTestData());
		if (node == null)
			System.out.println("NULL");
		else
			System.out.println(node.val);
	}

}
