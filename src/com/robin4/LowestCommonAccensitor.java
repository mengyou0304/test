package com.robin4;

import cn.jsi.buaa.basic.DataGen;
import cn.jsi.buaa.basic.TreeNode;

import java.util.LinkedList;

/*
 * Created by robinmac on 15-9-7.
 */
public class LowestCommonAccensitor {




    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        LinkedList<TreeNode> list=new LinkedList<TreeNode>();
        LinkedList<TreeNode> list2=new LinkedList<TreeNode>();
        dfs(root, p, list);
        dfs(root, q, list2);
        if(list.size()==0||list2.size()==0)
            return null;

        TreeNode last=null;
        while(true){
            if(list.size()==0||list2.size()==0)
                return last;
            TreeNode p1=list.removeFirst();
            TreeNode p2=list2.removeFirst();
            if(p1.val!=p2.val)
                return last;
            last=p1;
        }
    }

    private boolean dfs(TreeNode root,TreeNode target,LinkedList<TreeNode> tlist) {
        if(root==null)
            return false;
        tlist.addLast(root);
        if(root.val==target.val) {
            return true;
        }
        if(dfs(root.left,target,tlist)||dfs(root.right,target,tlist)){
            return true;
        }
        tlist.removeLast();
        return false;
    }

    public static void main(String[] args) {

        TreeNode tn=DataGen.gentTree2("5,3,6,2,4,#,#,1");
//        tn=DataGen.gentTree2("2,1");
//        DataGen.showTree3(tn);
        LowestCommonAccensitor lc=new LowestCommonAccensitor();
        TreeNode res=lc.lowestCommonAncestor(tn,new TreeNode(1),new TreeNode(4));
        System.out.println("res:"+res.val);
    }
}
