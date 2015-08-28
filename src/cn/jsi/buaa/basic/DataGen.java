package cn.jsi.buaa.basic;

import java.util.ArrayList;
import java.util.LinkedList;

public class DataGen {
    // public static ListNode gentList(ArrayList<Integer> values){
    //
    // }

    public static ListNode getListNode(int[] values) {
        ListNode head = new ListNode(-1);
        ListNode p = head;
        for (Integer i : values) {
            ListNode node = new ListNode(i);
            p.next = node;
            p = node;
            node.next = null;
        }
        return head.next;
    }

    public static TreeNode gentTree2(String s) {
        //finish parsing
        ArrayList<Integer> list = new ArrayList<Integer>();
        String[] ss = s.split(",");
        for (String ts : ss) {
            if ("#".equals(ts))
                list.add(null);
            else
                list.add(Integer.parseInt(ts));
        }
        System.out.println(list);
        //build Tree by level order
        LinkedList<TreeNode> l1 = new LinkedList<TreeNode>();
        LinkedList<TreeNode> l2 = new LinkedList<TreeNode>();
        LinkedList<TreeNode> nl1 = new LinkedList<TreeNode>();

        int indexer = 0;
        TreeNode head = new TreeNode(list.get(indexer++));
        l1.add(head);
        TreeNode p = head;
        while (indexer < list.size()&&l1.size()>0) {
            //add to l2
            int num = l1.size() * 2;
            for (int i = 0; i < num; i++) {
                Integer v = null;
                if (indexer == list.size())
                    break;
                if ((v = list.get(indexer++)) == null) {
                    l2.add(null);
                } else {
                    TreeNode nn = new TreeNode(v);
                    l2.add(nn);
                }
            }

            //link l1->l2
            while (l1.size() != 0) {
                TreeNode n = l1.pollFirst();
                n.left = l2.pollFirst();
                n.right = l2.pollFirst();
                if (n.left != null)
                    System.out.println(" " + n.left.val + " <- " + n.val);
                else
                    System.out.println(" " + "null" + " <- " + n.val);
                if (n.right != null)
                    System.out.println(" " + n.val + " ->" + n.right.val);
                else
                    System.out.println(" " + n.val + " ->" + n.right);
                if (n.left != null)
                    nl1.add(n.left);
                if (n.right != null)
                    nl1.add(n.right);

            }
            l1 = nl1;
            nl1=new LinkedList<TreeNode>();
            l2.clear();
        }
        return head;
    }
    public static void showTree3(TreeNode root){
        LinkedList<TreeNode> l1=new LinkedList<TreeNode>();
        LinkedList<TreeNode> l2=new LinkedList<TreeNode>();
        l1.add(root);
        int level=getLevel(root);
        TreeNode p=null;
        while(l1.size()>0){

        }



    }

    private static int getLevel(TreeNode root) {
        if(root==null)
            return 0;
        int l1=getLevel(root.left);
        int l2=getLevel(root.right);
        return 1+Math.max(l1,l2);
    }


    public static void main(String[] args) {
        DataGen d = new DataGen();
        TreeNode t = null;
        t = d.gentTree2("3,4,5,6,7,#,#,1,2");
//		t = d.gentTree("1,2,3,#,#,4,#,#,5");
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(8);
        // TreeNode t9=new TreeNode(9);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        t4.left = t7;
        t4.right = t8;
        d.showTree(t, 8);
//		d.showTree(t1,8);
    }

    public static void showTree2(TreeNode t) {
        if (t == null)
            return;
        if (t.left != null)
            System.out.println(t.left.val + " <- " + t.val);
        if (t.right != null)
            System.out.println(t.val + " -> " + t.right.val);
        if (t.left != null)
            showTree2(t.left);
        if (t.right != null)
            showTree2(t.right);

    }

    public static void showTree(TreeNode t, int num) {
        ArrayList<TreeNode> tlist = new ArrayList<TreeNode>();
        ArrayList<Integer> steps = new ArrayList<Integer>();
        tlist.add(t);
        steps.add(1);
        int custep = 0;
        int p = 0;
        TreeNode tnode = null;
        Double d = Math.log(num) / Math.log(2);
        // int level=d.intValue()+1;
        Double tm1 = Math.pow(2d, d.intValue());
        int alllen = tm1.intValue() * 4;
        // System.out.println("alllen="+alllen);

        int spacenum = num * 2;
        // System.out.println("current spacenum="+spacenum);
        boolean isfirst = true;
        while (p < tlist.size()) {
            tnode = tlist.get(p);

            // System.out.println("spacenum="+spacenum);
            if (isfirst)
                isfirst = false;
            else
                System.out.printf("" + getSpace(spacenum));
            System.out.printf("" + getSpace(spacenum) + tnode.val);
            if (tnode.left != null)
                tlist.add(tnode.left);
            if (tnode.right != null)
                tlist.add(tnode.right);
            p++;
            // System.out.println("p="+p);
            if (p == steps.get(custep)) {
                steps.add(tlist.size());
                // level--;
                custep++;
                spacenum = spacenum / 2;
                // System.out.println("\ncurrent spacenum="+spacenum);
                isfirst = true;
                System.out.println();

            }
            if (p > 10)
                break;
        }
    }

    public static String getSpace(int number) {
        String s = "";
        for (int i = 0; i < number; i++)
            s += " ";
        return s;
    }

    public static void showList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "  ");
            head = head.next;
        }
        System.out.println();

    }

    public static void showArray(int[] y) {
        String s = "";
        for (int i : y)
            s += i + " ";
        System.out.println(s);
    }

    public static TreeNode gentTree(String s) {
        return gentTree2(s);
    }
}
