package com.robin4;

import cn.jsi.buaa.basic.DataGen;
import cn.jsi.buaa.basic.TreeNode;

/**
 * Created by robinmac on 15-8-26.
 */
public class BinaryTreeMaxSumPath {
    int maxv=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxHand(root);
        return maxv;
    }
    //return the value adding the root
    public int maxHand(TreeNode root){
        if(root==null)
            return 0;
        int lv=Math.max(maxHand(root.left),0);
        int lr=Math.max(maxHand(root.right),0);
        maxv=Math.max(maxv,lv+lr+root.val);
        return root.val+Math.max(lv,lr);
    }

    public static void main(String[] args) {
        BinaryTreeMaxSumPath btms=new BinaryTreeMaxSumPath();
        TreeNode t=DataGen.gentTree2("1,2,3,#,#,4,#,#,5");
        DataGen.showTree(t, 10);
        int k=btms.maxPathSum(t);
        System.out.println("max value:"+k);

    }
}
