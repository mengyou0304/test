package cn.jsi.buaa;

import java.util.ArrayList;
import java.util.List;

import cn.jsi.buaa.basic.DataGen;
import cn.jsi.buaa.basic.TreeNode;

public class RecoverBST {

	List<TreeNode> candts = new ArrayList<TreeNode>();

	public void validate(TreeNode root, int min, int max, TreeNode father) {
		if (root == null)
			return;
		int leftmax = root.val;
		int rightmin = root.val;
		if (root.val <= min || root.val >= max) {
			candts.add(root);
			candts.add(father);
			leftmax = max;
			rightmin = min;
		}
		validate(root.left, min, leftmax, root);
		validate(root.right, rightmin, max, root);
	}

	public boolean swap(TreeNode p1, TreeNode p2) {
		if (p1 == null || p2 == null)
			return false;
		int tmp = p1.val;
		p1.val = p2.val;
		p2.val = tmp;
		return true;

	}

	public void recoverTree(TreeNode root) {
		validate(root, Integer.MIN_VALUE, Integer.MAX_VALUE, null);
		TreeNode p1 = candts.get(0);
		TreeNode p2 = candts.get(1);
		TreeNode p3 = null;
		TreeNode p4 = candts.get(candts.size() - 1);
		if (candts.size() > 2)
			p3 = candts.get(2);
	//	System.out.println("size="+candts.size());

		candts.clear();
		swap(p1, p4);
		validate(root, Integer.MIN_VALUE, Integer.MAX_VALUE, null);
		if (candts.size() > 0) {
			swap(p1, p4);
			swap(p1,p3);
		}else return;
		
		candts.clear();
		validate(root, Integer.MIN_VALUE, Integer.MAX_VALUE, null);
		if (candts.size() > 0) {
			swap(p1, p3);
			swap(p2,p4);
		}else return;
		
		candts.clear();
		validate(root, Integer.MIN_VALUE, Integer.MAX_VALUE, null);
		if (candts.size() > 0) {
			swap(p2, p4);
			swap(p2,p3);
		}
	}
	public TreeNode genTree(){
		TreeNode root=new TreeNode(2);
		TreeNode r1=new TreeNode(3);
		TreeNode r2=new TreeNode(1);
		TreeNode r3=new TreeNode(2);
		root.right=r1;
		r1.left=r2;
		return root;
	}

	public static void main(String[] args) {
		RecoverBST b = new RecoverBST();
		TreeNode root = b.genTree();
		DataGen.showTree2(root);
		System.out.println("********");
		b.recoverTree(root);
		System.out.println("size=" + b.candts.size());
		DataGen.showTree2(root);
	}
}
