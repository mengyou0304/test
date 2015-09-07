package com.robin4;

import cn.jsi.buaa.basic.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by robinmac on 15-9-5.
 */
public class PathSum {
    List<List<Integer>> reslist=new ArrayList<List<Integer>>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root,sum,new ArrayList<Integer>());
        return reslist;
    }
    //is a node?
    private boolean dfs(TreeNode root,int sum, ArrayList<Integer> tlist){
        if(root==null)
            return false;
        int cv=sum-root.val;
        tlist.add(root.val);
        boolean leftIsNode=dfs(root.left,cv,tlist);
        boolean rightIsNode=dfs(root.right,cv,tlist);
        if(cv==0&&!leftIsNode&&!rightIsNode){
            ArrayList<Integer> clist=new ArrayList<Integer>();
            for(Integer i:tlist)
                clist.add(i);
            reslist.add(clist);
        }
        tlist.remove(tlist.size() - 1);
        return true;
    }
    public static void main(String[] args) {
        PathSum bt=new PathSum();
        TreeNode t1=new TreeNode(1);
        TreeNode t2=new TreeNode(2);
        TreeNode t3=new TreeNode(3);
        t1.left=t2;
        t1.right=t3;
        System.out.println(bt.pathSum(t1,3));
    }
}
