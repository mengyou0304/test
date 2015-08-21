package cn.jsi.buaa;

import java.util.ArrayList;
import java.util.List;

import cn.jsi.buaa.basic.DataGen;
import cn.jsi.buaa.basic.TreeNode;

public class UniqBST2 {
	ArrayList<TreeNode> reslist=new ArrayList<TreeNode>();
    int tn;
    public ArrayList<TreeNode> buildTree(List<Integer> list){
        ArrayList<TreeNode> clist=new ArrayList<TreeNode>();
        if(list==null||list.size()==0)
            return clist;
        for(int i=0;i<list.size();i++){
            List<Integer> l1=list.subList(0,i);
            List<Integer> l2=list.subList(i+1,list.size());
            ArrayList<TreeNode> tl1=buildTree(l1);
            if(tl1.size()==0)tl1.add(null);
            ArrayList<TreeNode> tl2=buildTree(l2);
            if(tl2.size()==0)tl2.add(null);
            for(TreeNode t1:tl1)
                for(TreeNode t2:tl2){
                     TreeNode thead=new TreeNode(list.get(i));
                     thead.left=t1;
                     thead.right=t2;
                     clist.add(thead);
                }
        }
        return clist;
    }
    public ArrayList<TreeNode> generateTrees(int n) {
        ArrayList<Integer> nums=new ArrayList<Integer>();
        tn=n;
        for(int i=1;i<=n;i++)
            nums.add(i);
        return buildTree(nums);
    }
    public static void main(String[] args) {
    	UniqBST2 b2=new UniqBST2();
    	ArrayList<TreeNode> reslist=b2.generateTrees(1);
    	System.out.println(reslist.size());
    	for(TreeNode t:reslist)
    		DataGen.showTree2(t);
	}

}
