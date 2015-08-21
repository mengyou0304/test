package cn.jsi.buaa;

import cn.jsi.buaa.basic.ListNode;

public class PartitionList {
	 ListNode small=new ListNode(-1);
     ListNode smallwalker=small;
     ListNode big=new ListNode(-1);
     ListNode bigwalker=big;
     public void showbs(){
    	 ListNode s=small;
    	 System.out.print("small=");
		 while(s!=null){
			 System.out.print(" "+s.val+"->");
			 s=s.next;
		 }
		 s=big;
		 System.out.print("\n big=");
		 while(s!=null){
			 System.out.print(" "+s.val+"->");
			 s=s.next;
		 }
		 System.out.println("\n");
		
	}
	 public ListNode m1(ListNode head, int x){
	        if(head==null||head.next==null)
	            return head;
	        ListNode oldhead=new ListNode(-1);
	        oldhead.next=head;
	        		
	        ListNode headwalker=head;;
	        while(head!=null){
	        	System.out.println("tring..."+head.val);
	        	headwalker=head;
            	head=head.next;
	            if(headwalker.val<x){
	                smallwalker.next=headwalker;
	                smallwalker=smallwalker.next;
	                smallwalker.next=null;
	            }
	            else{
	                bigwalker.next=headwalker;
	                bigwalker=bigwalker.next;
	                bigwalker.next=null;
	            }
	     //       showbs();
	            
	        }
	        smallwalker.next=big.next;
	     //   showbs();
	        return small.next;
	    }
	 public ListNode prepareData(){
		 
		 ListNode head=new ListNode(5);
		 ListNode a2=new ListNode(2);
		 ListNode a3= new ListNode(3);
		 head.next=a2;
		 a2.next=a3;
		 return head;
	 }
	 public static void main(String[] args) {
		 PartitionList l=new PartitionList();
		 ListNode node=l.prepareData();
		 ListNode head= l.m1(node, 4);
		 while(head!=null){
			 System.out.println(head.val);
			 head=head.next;
		 }
		
	}

}
