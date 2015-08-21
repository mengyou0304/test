package cn.jsi.buaa;

import java.util.ArrayList;

import cn.jsi.buaa.basic.DataGen;
import cn.jsi.buaa.basic.TreeNode;

public class BTTravel {
//  ArrayList<ArrayList<Integer>> res=ArrayList<ArrayList<Integer>> ();
    ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> steps=new ArrayList<Integer>();
    ArrayList<TreeNode> nodelist=new  ArrayList<TreeNode> ();
    
    public void m1(TreeNode root){
        nodelist.add(root);
        steps.add(1);
        int num=0;
        int currentstep=0;
        TreeNode tnode=null;
        ArrayList<Integer> lis=new ArrayList<Integer>();
        while(num<nodelist.size()){
            tnode=nodelist.get(num);
            lis.add(tnode.val);
          //  System.out.println("list.add"+tnode.val);
            if(tnode.left!=null)
                nodelist.add(tnode.left);
            if(tnode.right!=null)
                nodelist.add(tnode.right);
            num++;
         //   System.out.println("num="+num+"  steps.get(currentstep)="+steps.get(currentstep));
            if(num==steps.get(currentstep)){
                currentstep++;
                steps.add(nodelist.size());
                res.add(lis);
                lis=new ArrayList<Integer>();
           //     System.out.println("after new"+res.get(0).size());
            }
        }
    }
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        if(root==null)
            return res;
        m1(root);
        return res;
    }
    
    public void dfs(int level, TreeNode node){
        if(node==null)
            return;
      //  System.out.println("level="+level+"  value:"+node.val+"   size:"+res.size());
        if(res.size()<=level){
            ArrayList<Integer> t=new ArrayList<Integer>();
            t.add(node.val);
            res.add(t);
        }
        else{
             ArrayList<Integer> t=res.get(level);
             t.add(node.val);
        }
        dfs(level+1,node.left);
        dfs(level+1,node.right);
        
    }
    
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        dfs(0,root);
        ArrayList<ArrayList<Integer>> res2=new ArrayList<ArrayList<Integer>>();
        for( int i=res.size()-1;i>=0;i--){
           res2.add(res.get(i));
        }
        return res2;
        
    }
    public static void main(String[] args) {
    	BTTravel bt=new BTTravel();
    	TreeNode root=DataGen.gentTree("1,2,3,4,5,6,7");
    	System.out.println("===============");
    	ArrayList<ArrayList<Integer>> list=bt.levelOrderBottom(root);
    	System.out.println(list.size());
    //	DataGen.showTree(root, 4);
    	for(ArrayList<Integer> li:list){
    		for(Integer i:li){
    			System.out.print(i+" ");
    		}
    		System.out.println();
    	}
	}

}
