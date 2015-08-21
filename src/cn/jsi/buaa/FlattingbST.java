package cn.jsi.buaa;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import cn.jsi.buaa.basic.TreeNode;

public class FlattingbST {
	Stack<TreeNode> st=new  Stack<TreeNode>();
    TreeNode nhead=new TreeNode(-1);
    TreeNode p;
    public void preorder(TreeNode node){
        if(node!=null){
            if(node.right!=null)
                st.push(node.right);
            p.right=node;
            p.left=null;
            p=node;
            preorder(p.left);
        }else{
            if(st.size()<=0)
                return;
            TreeNode q=st.pop();
            p.right=q;
            p.left=null;
            p=q;
            preorder(p.left);
        }
    }
    public void flatten(TreeNode root) {
        p=nhead;
        preorder(root);
    }
    public static void main(String[] args) {
    	FlattingbST f=new FlattingbST();
    	TreeNode h=new TreeNode(-1);
    	TreeNode l1=new TreeNode(1);
    	TreeNode l2=new TreeNode(2);
    	TreeNode l3=new TreeNode(3);
    	h.left=l1;
    	h.right=l2;
    	l2.left=l3;
    	f.flatten(h);
    	System.out.println("left "+h.left);
    	System.out.println("right "+h.right);
    	System.out.println("right.left: "+h.right.left);
    	System.out.println("right.right: "+h.right.right);
    	System.out.println("right.right.left: "+h.right.right.left);
    	System.out.println("right.right.right: "+h.right.right.right);
	}

}
