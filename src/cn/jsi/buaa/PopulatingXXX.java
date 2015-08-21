package cn.jsi.buaa;

import java.util.ArrayList;

import cn.jsi.buaa.basic.TreeLinkNode;

public class PopulatingXXX {
	public static void main(String[] args) {
		PopulatingXXX p=new PopulatingXXX();
		p.connect(null);
	}
	ArrayList<TreeLinkNode> ts1=new ArrayList<TreeLinkNode>();
    ArrayList<TreeLinkNode> ts2=new ArrayList<TreeLinkNode>();
    public void bfs(TreeLinkNode root){
        ts1.add(root);
        TreeLinkNode father=null;
        TreeLinkNode node=null;
        while(true){
            int i=0;
            while(i<ts1.size()){
            	node=ts1.get(i);
            	
                if(father!=null)
                    father.next=node;
                father=node;
                if(node.left!=null)
                    ts2.add(node.left);
                if(node.right!=null)
                    ts2.add(node.right);
                i++;
            }
            if(father!=null)
                 father.next=null;
            father=null;
            if(ts2.size()==0)
                break;
            ts1.clear();
            ts1=ts2;
            ts2=new ArrayList<TreeLinkNode>();
        }
        
    }
    public void connect(TreeLinkNode root) {
        bfs(root);
    }

}
