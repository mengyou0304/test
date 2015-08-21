package cn.jsi.buaa;

import cn.jsi.buaa.basic.TreeNode;

public class ConstrctBSTfromPostIn {
	int [] in;
    int [] po;
    public void build(int post,int poed,int inst,int ined,boolean isleft,TreeNode father){
        if(post>poed||inst>ined)
            return;
        int headv=po[poed];
        TreeNode son=new TreeNode(headv);
        if(isleft)
        	father.left=son;
        else
            father.right=son;
        for(int i=inst;i<=ined;i++){
            if(in[i]==headv){
                int leftlen=i-inst-1;
                build(post,post+leftlen,inst,i-1,true,son);
                build(post+leftlen+1,poed-1,i+1,ined,false,son);
            }
        }
        
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        in=inorder;
        po=postorder;
        TreeNode father=new TreeNode(-1);
        build(0,po.length-1,0,in.length-1,true,father);
        return father.left;
        
    }

}
