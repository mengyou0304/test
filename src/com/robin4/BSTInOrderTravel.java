package com.robin4;

import cn.jsi.buaa.basic.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by robinmac on 15-8-22.
 */
public class BSTInOrderTravel {
    /**
     * go(TreeNode root){
     *     go(root.left)
     *     visit(root)
     *     go(root.right)
     * }
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list=new ArrayList<Integer>();
        Stack<TreeNode> st=new Stack<TreeNode>();
        TreeNode p=root;
        while(p!=null||st.size()>0){
            while(p!=null) {
                st.push(p);
                p=p.left;
            }
            //p==null
            p=st.pop();
            list.add(p.val);
            p=p.right;
        }
        return list;
    }
}
