package cn.jsi.buaa;

import java.util.HashMap;

import cn.jsi.buaa.basic.RandomListNode;

public class CopyListWithRandom {

	HashMap<Integer, RandomListNode> map = new HashMap<Integer, RandomListNode>();

	public RandomListNode copyRandomList(RandomListNode head) {
		RandomListNode n = head;
		RandomListNode nhead = new RandomListNode(-1);
		RandomListNode np = nhead;
		RandomListNode tnode;
		while (n != null) {
			RandomListNode node1 = map.get(n.label);
			if (node1 == null) {
				node1 = new RandomListNode(n.label);
				map.put(n.label, node1);
			}
			np.next = node1;
			np = node1;
			if (n.random != null) {
				tnode = map.get(n.random.label);
				if (tnode == null) {
					tnode = new RandomListNode(n.random.label);
					map.put(n.random.label, tnode);
				}
				np.random = tnode;
			}
			n = n.next;
		}
		return nhead.next;
	}

	public static void main(String[] args) {
		CopyListWithRandom r = new CopyListWithRandom();
		RandomListNode n1 = new RandomListNode(1);
		RandomListNode n2 = new RandomListNode(2);
		RandomListNode n3 = new RandomListNode(3);
		n1.next = n2;
		n2.next = n3;
		r.copyRandomList(n1);
	}
}
