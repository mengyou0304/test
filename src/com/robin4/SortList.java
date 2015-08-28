package com.robin4;

import cn.jsi.buaa.basic.DataGen;
import cn.jsi.buaa.basic.ListNode;

/**
 * Created by robinmac on 15-8-26.
 */
public class SortList {

    //split and merge
    private ListNode s1(ListNode head) {
        if (head.next == null)
            return head;
        ListNode node = findMid(head);
        ListNode n1 = s1(head);
        ListNode n2 = s1(node);
        return merge(n1, n2);
    }

    public ListNode merge(ListNode n1, ListNode n2) {
        ListNode dhead = new ListNode(-1);
        ListNode p1 = n1, p2 = n2, p = dhead;
        while (p1 != null || p2 != null) {
            if (p1 == null || (p1 != null && p2 != null && p2.val < p1.val)) {
                p.next = p2;
                p2 = p2.next;
                p = p.next;
                continue;
            }
            p.next = p1;
            p1 = p1.next;
            p = p.next;
        }
        return dhead.next;
    }

    private ListNode findMid(ListNode head) {
        ListNode p = head;
        ListNode p2 = head;
        ListNode last = head;
        while (p2 != null) {
            if (p2.next == null) {
                last.next = null;
                return p;
            }
            p2 = p2.next.next;
            last = p;
            p = p.next;
        }
        last.next = null;
        return p;
    }

    private void s2(ListNode dhead) {


    }

    public ListNode sortList(ListNode head) {
        return s1(head);
    }

    public static void main(String[] args) {
        SortList sl = new SortList();
        ListNode head = DataGen.getListNode(new int[]{3, 2, 4, 6, 8, 0, 1});
        ListNode head1 = DataGen.getListNode(new int[]{1, 4, 5, 76, 89});
        ListNode head2 = DataGen.getListNode(new int[]{2, 4, 6, 8});


//        DataGen.showList(head);
//        DataGen.showList(sl.merge(head1, head2));
        DataGen.showList(sl.sortList(head));
    }
}
