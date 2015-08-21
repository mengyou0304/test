package cn.jsi.buaa;

import java.util.ArrayList;

import cn.jsi.buaa.basic.TreeNode;

public class Treerebuilt {
	  int[] pr;
	    int[] ir;
	    TreeNode father;
	    TreeNode tmp;

	    public void divc(int pst,int ped,int inst,int ined,boolean isleft){
	    	if(pst>ped||inst>ined)
	    		return;
	        int head=pr[pst];
	        TreeNode tfather;
	        for(int i=inst;i<=ined;i++){
	            if(ir[i]==head){
	                int newlen=i-inst;
	                if(isleft){
	                    father.left=new TreeNode(head);
	                    father=father.left;
	                }
	                else{
	                    father.right=new TreeNode(head);
	                    father=father.right;
	                }
	                tfather=father;
	                //build left
	                divc(pst+1,pst+newlen,inst,i-1,true);
	                //get back the oldfather and build right;
	                father=tfather;
	                divc(pst+newlen+1,ped,i+1,ined,false);
	            }
	        }
	        
	    }
	    public TreeNode buildTree(int[] preorder, int[] inorder) {
	        if(preorder==null||inorder==null||preorder.length==0)
	            return null;
	        pr=preorder;
	        ir=inorder;
	        father=new TreeNode(-1);
	        TreeNode oldfather=father;
	        divc(0,pr.length-1,0,ir.length-1,true);
	        return oldfather.left;
	        
	    }
	    public void debugTree(TreeNode node){
	    	ArrayList<TreeNode> tlist=new ArrayList<TreeNode>();
	    	ArrayList<Integer> slist=new ArrayList<Integer>();
	    	while(true){
	    		
	    	}
	    	//System.out.println(node.val);
	   	
	    }
	    public static void main(String[] args) {
	    	Treerebuilt t=new Treerebuilt();
	    	t.buildTree(new int[]{-1}, new int[]{-1});
		}

}
