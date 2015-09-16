package com.robin4;

import cn.jsi.buaa.basic.DataGen;
import cn.jsi.buaa.basic.TreeNode;

import java.util.Stack;

/**
 * Created by robinmac on 15-9-8.
 */
public class BSTIterator {

    Stack<TreeNode> st = new Stack<TreeNode>();
    Stack<Boolean> killLeftst = new Stack<Boolean>();

    public BSTIterator(TreeNode root) {
        st.push(root);
        killLeftst.push(false);
    }

    TreeNode tmp = null;

    /**
     * getNext smallest value
     *
     * @return smallest node
     */
    private TreeNode realGet() {
        //travel(left)
        //visit(root)
        //travel(right)
        if (st.size() == 0)
            return null;
        TreeNode p = st.pop();
        boolean killLeft = killLeftst.pop();
        if (!killLeft)
            while (p.left != null) {
                st.push(p);
                killLeftst.push(true);
                p = p.left;
            }
        if (p.right != null) {
            st.push(p.right);
            killLeftst.push(false);
        }
//        System.out.println(st);
        return p;
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        if (tmp != null)
            return true;
        tmp = realGet();
        if (tmp == null)
            return false;
        return true;
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        if (tmp != null) {
            Integer v = tmp.val;
            tmp = null;
            return v;
        }
        if (!hasNext())
            return -1;
        return next();
    }

    public static void main(String[] args) {
        TreeNode root = DataGen.gentTree2("5,2,7,1,3,6,8");
        BSTIterator biterator = new BSTIterator(root);
        System.out.println(biterator.hasNext());
        System.out.println(biterator.hasNext());
        System.out.println(biterator.next());
        System.out.println(biterator.next());
        System.out.println(biterator.next());
        for (int i = 0; i < 5; i++)
            System.out.println(biterator.realGet());
        System.out.println(biterator.hasNext());
        System.out.println(biterator.hasNext());
        System.out.println(biterator.next());
        System.out.println(biterator.next());
        System.out.println(biterator.next());
    }
}
