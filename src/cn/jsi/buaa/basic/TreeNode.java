package cn.jsi.buaa.basic;

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode(int x) {
		val = x;
	}
	public TreeNode(String s) {
		val = Integer.parseInt(s);
	}
	@Override
	public String toString() {
		return String.valueOf(val);
	}
}
