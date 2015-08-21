package cn.jsi.buaa;

import cn.jsi.buaa.basic.DataGen;
import cn.jsi.buaa.basic.ListNode;
import cn.jsi.buaa.basic.TreeNode;

public class ConverlisttoBST {
	  ListNode cur;
	    public TreeNode buildLeft(int usednum){
	    	//System.out.printf("building left level: %d  used number:[%d]   \n",tolevel,usednum);
	        if(usednum==0)
	            return null;
	        if(usednum==1){
	            TreeNode tnode=buildNode();
	            cur=cur.next;
	            return tnode;
	        }
	        int	allow2=usednum/2;
	        int	allow1=usednum-allow2-1;
	        TreeNode tnode=buildLeft(allow2);
	        TreeNode chead=buildNode();
	        if(cur!=null)
	        	cur=cur.next;
	        TreeNode t2node=buildLeft(allow1);
	        chead.left=tnode;
	        chead.right=t2node;
	        return chead;
	    }
	    public TreeNode buildNode(){
	    	if(cur==null)
	    		return null;
	        TreeNode t=new TreeNode(cur.val);
	        return t;
	    }
	    public TreeNode sortedListToBST(ListNode head) {
	        int n=0;
	        cur=head;
	        while(head!=null){
	            head=head.next;
	            n++;
	        }
	      return  buildLeft(n);
	    }
	public static void main(String[] args) {
		ConverlisttoBST d=new ConverlisttoBST();
		ListNode n=DataGen.getListNode(new int[]{0,1,2,3,4,5,6,7});
		TreeNode t=d.sortedListToBST(n);
		DataGen.showTree2(t);		
	}

}
