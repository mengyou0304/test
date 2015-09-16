package com.robin4;

import cn.jsi.buaa.basic.TreeNode;

/**
 * Created by robinmac on 15-9-7.
 */
public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null&&q==null)
            return true;
        if(p==null&&q!=null)
            return false;
        if(p!=null&&q==null)
            return false;
        if(p.val!=q.val)
            return false;
        boolean leftsame=isSameTree(p.left,q.left);
        boolean rightsame=isSameTree(p.right,q.right);
        if(leftsame&&rightsame)
            return true;
        return false;
    }
}
