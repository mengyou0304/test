package com.robin4;

import cn.jsi.buaa.basic.TreeNode;

/**
 * Created by robinmac on 15-9-5.
 */
public class PathSum1 {
    private boolean dfs(TreeNode root,int sum){
        if(root==null)
            return false;
        int cv=sum-root.val;
        if(cv==0&&root.left==null&&root.right==null)
            return true;
        return (dfs(root.left,cv)||dfs(root.right,cv));
    }
    public boolean hasPathSum(TreeNode root, int sum) {
        return dfs(root,sum);
    }
}
