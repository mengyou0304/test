package com.robin4;

import cn.jsi.buaa.basic.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by robinmac on 15-8-22.
 */
public class BSTPreOrderTravel {
    /**
     * go(){
     * show(v)
     * go(left)
     * go(right)
     * }
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        TreeNode p = root;
        Stack<TreeNode> st = new Stack<TreeNode>();
        while (p != null || st.size() > 0) {
            if (p == null)
                p = st.pop();
            list.add(p.val);
            if (p.right != null)
                st.push(p.right);
            p = p.left;
        }
        return list;
    }
}
