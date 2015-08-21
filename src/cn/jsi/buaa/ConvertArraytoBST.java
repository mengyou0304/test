package cn.jsi.buaa;

import cn.jsi.buaa.basic.DataGen;
import cn.jsi.buaa.basic.ListNode;
import cn.jsi.buaa.basic.TreeNode;

public class ConvertArraytoBST {
	int n[];
	boolean usefirst = false;
	boolean uselast = false;
	int ostart;
	int oend;

	public TreeNode shelper(int start, int end) {
		int mid = (start + end) / 2;
		if (mid == start || mid == end) {
			if (mid == ostart) {
				if (usefirst)
					return null;
				usefirst = true;
			} else if (mid == oend) {
				if (uselast)
					return null;
				uselast = true;
			} else {
				return null;
			}
		}
		TreeNode tnode = buildnode(mid);
		TreeNode left = shelper(start, mid);
		TreeNode right = shelper(mid, end);
		tnode.left = left;
		tnode.right = right;
		return tnode;
	}

	public TreeNode buildnode(int num) {
		TreeNode tnode = new TreeNode(n[num]);
		return tnode;
	}

	public TreeNode sortedArrayToBST(int[] num) {
		n = num;
		int len = num.length;
		if(len==0)
			return null;
		ostart = 0;
		oend = len;
		return shelper(ostart, oend);
	}

	public static void main(String[] args) {
		ConvertArraytoBST d = new ConvertArraytoBST();
		int[] n=new int[] {  };
		TreeNode t = d.sortedArrayToBST(n);
		DataGen.showTree2(t);
	}

}
