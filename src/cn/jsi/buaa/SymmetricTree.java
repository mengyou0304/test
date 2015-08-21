package cn.jsi.buaa;

import java.util.ArrayList;

import cn.jsi.buaa.basic.ListNode;
import cn.jsi.buaa.basic.TreeNode;

public class SymmetricTree {
	ArrayList<TreeNode> nodelist = new ArrayList<TreeNode>();
	ArrayList<Integer> step = new ArrayList<Integer>();

	boolean isMirror(TreeNode l, TreeNode r) {
		if (l == null && r == null)
			return true;
		if (l == null || r == null)
			return false;
		if (l.val == r.val && isMirror(l.left, r.right)
				&& isMirror(l.right, r.left))
			return true;
		return false;

	}

	boolean isSame(TreeNode t1, TreeNode t2) {
		if (t1 == null && t2 == null)
			return true;
		if(t1==null||t2==null)
			return false;
		return t1.val == t2.val;
	}

	boolean verifyStep(int cstep) {
		if(cstep==0)
			return true;
		int head = step.get(cstep - 1);
		int tail = step.get(cstep) - 1;
		while (head <= tail) {
			if (!isSame(nodelist.get(head), nodelist.get(tail)))
				return false;
			head++;
			tail--;
		}
		return true;
	}

	boolean seril(TreeNode root) {
		int head = 0;
		int currentstep = 0;
		TreeNode tnode = null;
		nodelist.add(root);
		step.add(nodelist.size());
		while (head < nodelist.size()) {
			tnode = nodelist.get(head);

			if (tnode != null) {
				nodelist.add(tnode.left);
				nodelist.add(tnode.right);
			}
			head++;
			if (head == step.get(currentstep)) {
				step.add(nodelist.size());
				boolean isM = verifyStep(currentstep);
				if (!isM)
					return false;
				currentstep++;
			}

		}
		return true;
	}

	public boolean isSymmetric(TreeNode root) {
		if (root == null)
			return true;
		// return isMirror(root.left,root.right);
		return seril(root);
	}
	public TreeNode getTestData(){
		TreeNode head=new TreeNode(0);
		TreeNode l1=new TreeNode(1);
		TreeNode l2=new TreeNode(1);
		TreeNode l3=new TreeNode(3);
		head.left=l1;
		head.right=l2;
		l1.left=null;
		l2.right=null;
		l1.right=l3;
		l2.left=null;
		return head;
		
		
	}
	public static void main(String[] args) {
		SymmetricTree t=new SymmetricTree();
		TreeNode root=t.getTestData();
		System.out.println(t.isSymmetric(root));

	}
}
