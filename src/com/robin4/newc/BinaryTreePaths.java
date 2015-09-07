package com.robin4.newc;

import cn.jsi.buaa.basic.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by robinmac on 15-9-5.
 */
public class BinaryTreePaths {
    List<String> reslist=new ArrayList<String>();

    public List<String> binaryTreePaths(TreeNode root) {
        if(root==null)
            return reslist;
        dfs(root,"");
        return reslist;
    }

    // is  node?
    private boolean dfs(TreeNode root,String father){
        if(root==null)
            return false;
        String selfString=father+"->"+root.val;
        boolean leftisNode=dfs(root.left,selfString);
        boolean rightisNode=dfs(root.right,selfString);
        if(!leftisNode&&!rightisNode)
            reslist.add(selfString.substring(2));
        return true;
    }

    public static void main(String[] args) {
        BinaryTreePaths bt=new BinaryTreePaths();
        TreeNode t1=new TreeNode(1);
        TreeNode t2=new TreeNode(2);
        TreeNode t3=new TreeNode(3);
        t1.left=t2;
        t1.right=t3;
        System.out.println(bt.binaryTreePaths(t1));
    }
}
