package com.robin4;

import cn.jsi.buaa.basic.DataGen;
import cn.jsi.buaa.basic.ListNode;

/**
 * Created by robinmac on 15-9-8.
 */
public class MergKSortedList {
    class HListNode{
        ListNode node=null;
        Integer index=null;
        public HListNode(ListNode node,Integer index){
            this.index=index;
            this.node=node;
        }
    }
    public void showHeap(){
//        for(int i=0;i<heap.length;i++)
//            System.out.print(heap[i].node.val + "\t");
//        System.out.println();
    }
    HListNode[] heap;
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0)
            return null;
        heap=new HListNode[lists.length];
        for(int i=0;i<lists.length;i++){
            heap[i]=new HListNode(lists[i],i);
            if(lists[i]!=null)
                lists[i]=lists[i].next;
        }
        for(int i=heap.length/2+1;i>=0;i--){
            maintennce(i, heap);
        }
        ListNode dhead=new ListNode(-1);
        ListNode p=dhead;
        while(true) {
            p.next = heap[0].node;
            if (p.next == null)
                break;
            p = p.next;
            int index = heap[0].index;
            heap[0]=new HListNode(lists[index],index);
            if(lists[index]!=null)
                lists[index]=lists[index].next;
            maintennce(0,heap);
        }
        return dhead.next;
    }

    private void maintennce(int i, HListNode[] heap) {
//        System.out.println("Mainten "+i);
        showHeap();
        int left=i*2+1;
        int right=i*2+2;
        HListNode minNode=heap[i];
        int smallone=i;
        if(left<heap.length&&smallThan( heap[left],minNode)) {
            minNode = heap[left];
            smallone=left;
        }
        if(right<heap.length&&smallThan( heap[right],minNode)) {
            minNode = heap[right];
            smallone=right;
        }
        if(smallone!=i){
            HListNode tmp=heap[i];
            heap[i]=heap[smallone];
            heap[smallone]=tmp;
            maintennce(smallone,heap);
        }
//        System.out.println("After Mainten "+i);
        showHeap();
    }

    private boolean smallThan(HListNode a, HListNode b) {
        if(a.node==null)
            return false;
        if(b.node==null)
            return true;
        return a.node.val<b.node.val;
    }

    public static void main(String[] args) {
        MergKSortedList ml=new MergKSortedList();
        ListNode node1=DataGen.getListNode(new int[]{1,2,3,4,5,6});
        ListNode node2=DataGen.getListNode(new int[]{11,12,13,14,15,16});
        ListNode node3=DataGen.getListNode(new int[]{21,22,23,24,25,26});
        ListNode[] ns=new ListNode[0];
//        ns[0]=node1;
//        ns[1]=node2;
//        ns[2]=node3;
        DataGen.showList(ml.mergeKLists(ns));
    }
}
