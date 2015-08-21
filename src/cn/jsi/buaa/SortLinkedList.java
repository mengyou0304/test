package cn.jsi.buaa;

import cn.jsi.buaa.basic.DataGen;
import cn.jsi.buaa.basic.ListNode;

public class SortLinkedList {
public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        ListNode head=new ListNode(-1);
        ListNode b=head;
        ListNode p=head;
        
        while(true){
        	//System.out.println("l1="+l1+" l2="+l2);
            if(l1==null&&l2==null)
                break;
            if(l1==null&&l2!=null){
                p=l2;
                l2=l2.next;
                b.next=p;
                b=p;
            }
            if(l2==null&&l1!=null){
                p=l1;
                l1=l1.next;
                b.next=p;
                b=p;
            }
            if(l2!=null&&l1!=null&&l1.val<l2.val){
                p=l1;
                l1=l1.next;
                b.next=p;
                b=p;
            }
             if(l2!=null&&l1!=null&&l1.val>=l2.val){
                p=l2;
                l2=l2.next;
                b.next=p;
                b=p;
            }
        }
        return head.next;
    }
	public static void main(String[] args) {
		SortLinkedList sl=new SortLinkedList();
		ListNode l1= DataGen.getListNode(new int[]{-30,-28,-27,-23,-22,-19,-18,-17,-9,-7,-7,-6,-1,1,2,2,2,3,4,4,5,5,7,8,9,12,14,15,17,20,23,24,25,27});
		ListNode l2=DataGen.getListNode(new int[]{});
		sl.mergeTwoLists(l1, l2);
	}

}
