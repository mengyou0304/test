package com.robin4;

import cn.jsi.buaa.basic.DataGen;
import cn.jsi.buaa.basic.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by robinmac on 15-8-21.
 */
public class KthSmallestInBST {
    class NTreeNode {
        Integer size = 0;

        public NTreeNode() {
        }

        public int val = 0;
        public NTreeNode left;
        public NTreeNode right;
    }

    public int kthSmallest(TreeNode root, int k) {
        return -1;
    }

    public NTreeNode dfsCopy(TreeNode root) {
        if (root == null)
            return null;
        NTreeNode node = new NTreeNode();
        node.left = dfsCopy(root.left);
        node.right = dfsCopy(root.right);
        if (node.left != null)
            node.size += node.left.size;
        if (node.right != null)
            node.size += node.right.size;
        node.size += 1;
        return node;
    }

    /**
     * Solution 2
     */
    public static ArrayList<Integer> list = new ArrayList<Integer>();

    public int kthSmallest2(TreeNode root, int k) {
//        midTravel(root);
        midTravelWithoutRecursion(root);
        return list.get(k);
    }

    private void midTravel(TreeNode root) {
        if (root == null)
            return;
        midTravel(root.left);
        list.add(root.val);
        midTravel(root.right);
    }
    // go(node){
    //    go(node.left);
    //    list node
    //    go(node.right);
    // }
    //
    private void midTravelWithoutRecursion(TreeNode root) {
        TreeNode p = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (stack.size()>0||p != null) {
            if(p==null)
                p= stack.pop();
            if (p.left != null) {
                stack.push(p);
                p = p.left;
            } else {
                //p.left==null
                list.add(p.val);
                if (p.right != null)
                    p = p.right;
                else {
                    if (stack.size() == 0)
                        break;
                    p = stack.pop();
                    list.add(p.val);
                    p = p.right;
                }
            }
        }
    }

    //go(){
    //  visit(node)
    //  go(left)
    //  go(right)
    //}
    private void leftTravel(TreeNode root) {
        TreeNode p = root;
        Stack<TreeNode> st = new Stack<TreeNode>();
        while (st.size() > 0 || p != null) {
            if (p == null)
                p = st.pop();
            list.add(p.val);
            if (p.right != null)
                st.push(p.right);
            p = p.left;
        }
    }

    //go(){
    //  go(left)
    //  stauts?
    //  go(right)
    //  visit(node)
    //}
    private void rightTravel(TreeNode root) {
        TreeNode p = root;
        TreeNode lastnode=null;
        Stack<TreeNode> st = new Stack<TreeNode>();
        while (st.size() > 0 || p != null) {
            while (p != null) {
                st.push(p);
                p = p.left;
            }
            p = st.peek();
            //p.left ==null
            if (p.right == null||p.right.equals(lastnode)) {
                list.add(p.val);
                lastnode=p;
                st.pop();
                p = null;
            }else{
                //p.right!=null
                p=p.right;
            }
        }
    }

    public static void main(String[] args) {
        KthSmallestInBST bst = new KthSmallestInBST();
        TreeNode t = null;
        t = DataGen.gentTree("3,4,5,6,7,#,#,1,2");
        DataGen.showTree(t, 8);
        TreeNode t1=new TreeNode(1);
        TreeNode t2=new TreeNode(1);
        TreeNode t3=new TreeNode(1);
        t1.left=t2;
        t2.left=t3;
        bst.midTravelWithoutRecursion(t1);
        System.out.println(KthSmallestInBST.list);

    }

}
