package com.robin4.newc;

import cn.jsi.buaa.basic.DataGen;
import cn.jsi.buaa.basic.TreeNode;

/**
 * Created by robinmac on 15-9-13.
 */
public class CountUniValue {
    int sum=0;
    public int countUnivalSubtrees(TreeNode root) {
        getSameSub(root);
        return sum;
    }
    //null: no node
    //-1: not same
    // value: all the value
    private Integer getSameSub(TreeNode root){
        if(root==null)
            return null;
        System.out.println(root.val);
        Integer v1=getSameSub(root.left);
        Integer v2=getSameSub(root.right);
        if((v1==null||v1==root.val)&&(v2==null||v2==root.val)){
            sum++;
            return root.val;
        }
        return -1;
    }

    public static void main(String[] args) {
        CountUniValue cu=new CountUniValue();
        int res=cu.countUnivalSubtrees(DataGen.gentTree2("5,1,5,5,5,#,5"));
        System.out.println(res);
    }
}
