package cn.jsi.buaa;

import java.util.ArrayList;
import java.util.Stack;

import cn.jsi.buaa.basic.TreeNode;

public class BSTpreorder {
	
	ArrayList<Integer> re=new ArrayList<Integer>();
	 Stack<TreeNode> st=new Stack<TreeNode>();
	    
    ArrayList<TreeNode> nodelist=new ArrayList<TreeNode>();
    ArrayList<Integer> step=new ArrayList<Integer>();
   
    public void bfs(TreeNode root){
        TreeNode p=null;
        int num=0;
        nodelist.add(root);
        while(num<nodelist.size()){
            p=nodelist.get(num);
            re.add(p.val);
            num++;
            if(p.left!=null)
                nodelist.add(p.left);
            if(p.right!=null)
                nodelist.add(p.right);
        }
        
    }
    public void bfs2(TreeNode root){
        if(root==null)
             return;
        st.push(root);
        ArrayList<Integer> tlist=new ArrayList<Integer>();
        while(st.size()>0){
            root=st.pop();
            if(root==null)
            	continue;
            st.push(root.right);
            st.push(root.left);
            tlist.add(root.val);
        }
        int s=tlist.size();
       for(int i=0;i<s;i++)
        re.add(tlist.get(s-1-i));
        
    }
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        if(root==null)
            return re;
        bfs(root);
        return re;
    }
    public TreeNode getTestData(){
    	TreeNode root=new TreeNode(1);
    	TreeNode a1=new TreeNode(2);
    	TreeNode a2=new TreeNode(3);
    	root.left=a1;
    	a1.right=a2;
    	return root;
    }
    public static void main(String[] args) {
    	BSTpreorder b=new BSTpreorder();
    	b.bfs2(b.getTestData());
    	b.debugList(b.re);
	}
	private void debugList(ArrayList<Integer> list) {
		
	}
}
