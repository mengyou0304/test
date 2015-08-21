package cn.jsi.buaa;

import java.util.ArrayList;

import cn.jsi.buaa.basic.TreeNode;

public class PathSum {
	 ArrayList<ArrayList<Integer>> relist=new ArrayList<ArrayList<Integer>>();
	    
	    public void genRes(ArrayList<Integer> res){
	        ArrayList<Integer> nres=new ArrayList<Integer>();
	        for(Integer i:res)
	            nres.add(i);
	        relist.add(nres);
	    }
	    public void dp( TreeNode root, int sum, ArrayList<Integer> res){
	        if(root==null&&sum==0){
	            genRes(res);
	            return;
	        }
	        if(root==null)
	            return;
	        res.add(root.val);
	        
	        dp(root.left,sum-root.val,res);
	        
	       
	        dp(root.right,sum-root.val,res);
	         
	        res.remove(res.size()-1);
	        
	    }
	    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
	        ArrayList<Integer> tlist=new ArrayList<Integer>();
	        dp(root,sum,tlist);
	        return relist;
	    }
	    public TreeNode builTestedData(){
	    	TreeNode node=new TreeNode(1);
	    	return node;
	    	
	    }
	    public static void main(String[] args) {
	    	PathSum p=new PathSum();
	    	TreeNode node=p.builTestedData();
	    	p.pathSum(node, 1);
		}
}
