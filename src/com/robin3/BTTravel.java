package com.robin3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import cn.jsi.buaa.basic.DataGen;
import cn.jsi.buaa.basic.TreeNode;

public class BTTravel {
	List<List<Integer>> reslist=new ArrayList<List<Integer>>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        bfs1Q(root);
        //bfs2Q(root);
        return reslist;
    }
    public void bfs1Q(TreeNode root){
        LinkedList<TreeNode> queue=new LinkedList<TreeNode>();
        queue.push(root);
        int currentlen=1;
        ArrayList<Integer> clist=new ArrayList<Integer>();
        while(queue.size()>0){
            TreeNode node=queue.pollLast();
            clist.add(node.val);
            currentlen--;
            if(node.left!=null)
                queue.push(node.left);
            if(node.right!=null)
                queue.push(node.right);
            if(currentlen==0){
                reslist.add(clist);
                clist=new ArrayList<Integer>();
                currentlen=queue.size();
            }
        }
    }
    public void bfs2Q(TreeNode root){
        ArrayList<TreeNode> l1=new ArrayList<TreeNode>();
        ArrayList<TreeNode> l2=new ArrayList<TreeNode>();
        ArrayList<Integer> rlist=new ArrayList<Integer>();
        int cr=0;
        while(l1.size()>0){
            while(cr<l1.size()){
                TreeNode node=l1.get(cr);
                if(node.left!=null)
                    l2.add(node.left);
                if(node.right!=null)
                    l2.add(node.right);
                rlist.add(node.val);
                cr++;
            }
            l1=l2;
            cr=0;
            reslist.add(rlist);
            l2=new ArrayList<TreeNode>();
        }
    }
    public static void main(String[] args) {
    	BTTravel bt=new BTTravel();
    	bt.bfs1Q(DataGen.gentTree("1,2,3,4"));
	}

}
