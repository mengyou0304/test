package com.robin4;

import cn.jsi.buaa.basic.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by robinmac on 15-8-22.
 */
public class BSTPostOrderTravel {
    /**
     * go(root){
     *     go(root.left)
     *     go(root.right)
     *     visit(root)
     * }
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> list=new ArrayList<Integer>();
        TreeNode p=root;
        Stack<TreeNode> st=new Stack<TreeNode>();
        Stack<TreeNode> lastst=new Stack<TreeNode>();
        while(st.size()>0||p!=null){
            while(p!=null){
                st.push(p);
                p=p.left;
            }
            //p==null
            //chech if has go through its left
            if(st.size()>0&&lastst.size()>0&&st.peek()==lastst.peek()){
                lastst.pop();
                p=st.pop();
                list.add(p.val);
                p=null;
            }
            else {
                p = st.peek();
                lastst.push(p);
                p = p.right;
            }
        }
        return list;
    }
}
