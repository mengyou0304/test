package cn.jsi.buaa;

import java.util.ArrayList;
import java.util.Stack;

import cn.jsi.buaa.basic.DataGen;
import cn.jsi.buaa.basic.TreeNode;

public class BSTZigzag {
	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
	ArrayList<Stack<TreeNode>> sts = new ArrayList<Stack<TreeNode>>();
	boolean lTOr = true;

	public int bfs(int level) {
		if (level % 2 == 1)
			lTOr = false;
		else
			lTOr = true;
		Stack<TreeNode> stfather = sts.get(level);
		ArrayList<Integer> list = null;
		Stack<TreeNode> st = null;
		if (sts.size() - 1 < level + 1) {
			st = new Stack<TreeNode>();
			sts.add(st);
			list = new ArrayList<Integer>();
			res.add(list);
		} else {
			st = sts.get(level + 1);
			list = res.get(level + 1);
		}

		while (stfather.size() > 0) {
			TreeNode root = stfather.pop();
			if (lTOr) {
				if (root.left != null) {
					st.push(root.left);
					list.add(root.left.val);
				}
				if (root.right != null) {
					st.push(root.right);
					list.add(root.right.val);
				}
			} else {
				if (root.right != null) {
					st.push(root.right);
					list.add(root.right.val);
				}
				if (root.left != null) {
					st.push(root.left);
					list.add(root.left.val);
				}
			}
		}
		return st.size();

	}

	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
		if (root == null)
			return res;
		Stack<TreeNode> st = new Stack<TreeNode>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		st.push(root);
		list.add(root.val);
		sts.add(st);
		res.add(list);
		int level = 0;
		while (true) {
			int nextlevelSize = bfs(level++);
			if (nextlevelSize == 0)
				break;
		}
		res.remove(res.size()-1);
		return res;
	}

	public static void main(String[] args) {
		BSTZigzag b = new BSTZigzag();
		TreeNode root=DataGen.gentTree("1,2,3,4,5,6,7");
		ArrayList<ArrayList<Integer>> ress = b.zigzagLevelOrder(root);
		for (ArrayList<Integer> is : ress) {
			for (Integer i : is)
				System.out.print(" " + i);
			System.out.println();
		}
	}
}
