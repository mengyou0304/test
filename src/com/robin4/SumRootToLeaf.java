package com.robin4;

import cn.jsi.buaa.basic.TreeNode;

/**
 * Created by robinmac on 15-9-5.
 */
public class SumRootToLeaf {
    int sum=0;
    public int sumNumbers(TreeNode root) {
        dfs(root,0);
        return sum;
    }

    //is a node?
    private boolean dfs(TreeNode root,int value){
        if(root==null)
            return false;
        int cv=value*10+root.val;
        boolean leftisNode=dfs(root.left,cv);
        boolean rightisNode=dfs(root.right,cv);
        if(!leftisNode&&!rightisNode)
            sum+=cv;
        return true;
    }
}
