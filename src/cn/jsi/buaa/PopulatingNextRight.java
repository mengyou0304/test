package cn.jsi.buaa;

import java.util.LinkedList;
import java.util.Queue;

import cn.jsi.buaa.basic.TreeLinkNode;

public class PopulatingNextRight {
	public void bfs(TreeLinkNode root){
        Queue<TreeLinkNode> st1=new LinkedList<TreeLinkNode>();
        Queue<TreeLinkNode> st2=new LinkedList<TreeLinkNode>();
        st1.add(root);
        TreeLinkNode tmp=null;
        while(st1.size()!=0){
            while(st1.size()!=0){
                TreeLinkNode node=st1.poll();
                if(tmp!=null)
                    tmp.next=node;
                tmp=node;
                if(node.left!=null)
                    st2.add(node.left);
                if(node.right!=null)
                    st2.add(node.right);
            }
            tmp.next=null;
            tmp=null;
            st1.clear();
            st1=st2;
            st2=new LinkedList<TreeLinkNode>();
        }
        
    }
    public void connect(TreeLinkNode root) {
        bfs(root);
    }
}
