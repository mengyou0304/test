package cn.jsi.buaa.basic;

import java.util.ArrayList;

public class DataGen {
	// public static ListNode gentList(ArrayList<Integer> values){
	//
	// }

	public static ListNode getListNode(int[] values) {
		ListNode head = new ListNode(-1);
		ListNode p = head;
		for (Integer i : values) {
			ListNode node = new ListNode(i);
			p.next = node;
			p = node;
			node.next = null;
		}
		return head.next;
	}

	public static TreeNode gentTree(String s) {
		if (s.length() == 0)
			return null;
		String[] ss = s.split(",");
		TreeNode[] ts = new TreeNode[ss.length + 1];
		// TreeNode head=new TreeNode(ss[0]);
		for (int i = 0; i < ss.length; i++) {
			if (ss[i].equals("#"))
				ts[i + 1] = null;
			else
				ts[i + 1] = new TreeNode(ss[i]);
		}
		int len = ss.length;
		for (int i = 1; i <= ss.length; i++) {
			System.out.println("i=" + i);
			if (ts[i] == null)
				continue;
			if (2 * i <= len) {
				ts[i].left = ts[2 * i];
				if (ts[2 * i] == null)
					System.out.println(ts[i].val + "  l-> null");
				else
					System.out.println(ts[i].val + "  l->" + ts[2 * i].val);
			}
			if (2 * i + 1 <= len) {
				ts[i].right = ts[2 * i + 1];
				if (ts[2 * i + 1] == null)
					System.out.println(ts[i].val + "  l-> null");
				else
					System.out.println(ts[i].val + "  r->" + ts[2 * i + 1].val);
			}
		}
		return ts[1];
	}

	public static void main(String[] args) {
		DataGen d = new DataGen();
		TreeNode t = null;
		 t=d.gentTree("3,4,5,6,7,#,#,1,2");
//		t = d.gentTree("1,2,3,#,#,4,#,#,5");
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		TreeNode t6 = new TreeNode(6);
		TreeNode t7 = new TreeNode(7);
		TreeNode t8 = new TreeNode(8);
		// TreeNode t9=new TreeNode(9);

		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t2.right = t5;
		t3.left = t6;
		t3.right = t7;
		t4.left = t7;
		t4.right = t8;
		d.showTree(t, 8);
//		d.showTree(t1,8);
	}

	public static void showTree2(TreeNode t) {
		if (t == null)
			return;
		if (t.left != null)
			System.out.println( t.left.val+ " <- " +t.val);
		if (t.right != null)
			System.out.println(t.val + " -> " + t.right.val);
		if (t.left != null)
			showTree2(t.left);
		if (t.right != null)
			showTree2(t.right);

	}

	public static void showTree(TreeNode t, int num) {
		ArrayList<TreeNode> tlist = new ArrayList<TreeNode>();
		ArrayList<Integer> steps = new ArrayList<Integer>();
		tlist.add(t);
		steps.add(1);
		int custep = 0;
		int p = 0;
		TreeNode tnode = null;
		Double d = Math.log(num) / Math.log(2);
		// int level=d.intValue()+1;
		Double tm1 = Math.pow(2d, d.intValue());
		int alllen = tm1.intValue() * 4;
		// System.out.println("alllen="+alllen);

		int spacenum = num * 2;
		// System.out.println("current spacenum="+spacenum);
		boolean isfirst = true;
		while (p < tlist.size()) {
			tnode = tlist.get(p);

			// System.out.println("spacenum="+spacenum);
			if (isfirst)
				isfirst = false;
			else
				System.out.printf("" + getSpace(spacenum));
			System.out.printf("" + getSpace(spacenum) + tnode.val);
			if (tnode.left != null)
				tlist.add(tnode.left);
			if (tnode.right != null)
				tlist.add(tnode.right);
			p++;
			// System.out.println("p="+p);
			if (p == steps.get(custep)) {
				steps.add(tlist.size());
				// level--;
				custep++;
				spacenum = spacenum / 2;
				// System.out.println("\ncurrent spacenum="+spacenum);
				isfirst = true;
				System.out.println();

			}
			if (p > 10)
				break;
		}
	}

	public static String getSpace(int number) {
		String s = "";
		for (int i = 0; i < number; i++)
			s += " ";
		return s;
	}

	public static void showList(ListNode head) {
		while (head != null) {
			System.out.print(head.val + "  ");
			head = head.next;
		}
		System.out.println();

	}
}
