package cn.jsi.buaa;

import java.util.ArrayList;

import cn.jsi.buaa.basic.TreeNode;

public class MaxDepthofBST {
	public int bfs(TreeNode root) {
		ArrayList<TreeNode> nodelist = new ArrayList<TreeNode>();
		TreeNode node = root;
		int head = 0;
		int tail = 0;
		int step = 0;
		ArrayList<Integer> stageStep = new ArrayList<Integer>();
		if(root==null)
	    	return -1;
		nodelist.add(root);
		stageStep.add(1);
		while (true) {
			if (head == stageStep.get(step)) {
				step++;
				stageStep.add(nodelist.size());
				if(stageStep.get(stageStep.size()-1)==stageStep.get(stageStep.size()-2))
				    return step-1;
				
			}
			if (nodelist.get(head).left != null)
				nodelist.add(nodelist.get(head).left);

			if (nodelist.get(head).right != null)
				nodelist.add(nodelist.get(head).right);
			head++;
			if (head == nodelist.size())
				break;
		}
		return step;

	}

	public int maxDepth(TreeNode root) {
	    int step=bfs(root);
	    return step;
	}

	public int dp(TreeNode root) {
		if(root==null)
			return 0;
		int l=dp(root.left);
		int r=dp(root.right);
		if(l>r)
			return l+1;
		else
			return r+1;
	}

	
	
	public boolean dp2(TreeNode p, TreeNode q){
		if(p==null&&q==null)
			return true;
		if(p==null)
			return false;
		if(q==null)
			return false;
		if(p.val==q.val&&dp2(p.left,q.left)&&dp2(p.right,q.right))
			return true;
		return false;
		
	}
	public boolean isSameTree(TreeNode p, TreeNode q) {
	    return dp2(p,q);    
	}

	public static void main(String[] args) {
		MaxDepthofBST d=new MaxDepthofBST();
		TreeNode t=new TreeNode(1);
		t.left=new TreeNode(2);
		t.left.left=new TreeNode(3);
		t.right=new TreeNode(4);
		int i=d.maxDepth(t);
		System.out.println(i+1);
	}
}
