package cn.jsi.buaa;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class LRUCacheS2 {
	boolean debug=false;
	class Lnode {
		Lnode next;
		Lnode pre;
		Integer value;
		Integer key;
		
		public Lnode(int value2,int key2) {
			value = value2;
			key=key2;
		}
		@Override
		public boolean equals(Object obj) {
			Lnode o=(Lnode)obj;
			if(o.value==this.value&&o.key==this.key)
				return true;
			else
				return false;
		}
		@Override
		public String toString() {
			String s=key+"["+value+"]";
			return s;
		}
	}

	int n;
	HashMap<Integer, Lnode> valuemap = new HashMap<Integer, Lnode>();
	Lnode head;
	Lnode tail;
	public LRUCacheS2(int capacity) {
		this.n = capacity;
		head = new Lnode(-1,-1);
		tail = head;
	}

	// make a node to the head->next=node;
	public void makefirst(Lnode node) {
		if (node == null||head.next.equals(node))
			return;
		if(tail.equals(node))
			tail=node.pre;
		node.pre.next = node.next;
		if(node.next!=null)
			node.next.pre=node.pre;
		node.next = head.next;
		head.next.pre = node;
		head.next = node;
		node.pre = head;
	}
	public Lnode genfirst(Integer value,Integer key){
		Lnode tnode=new Lnode(value,key);
		tnode.pre=head;
		tnode.next=head.next;
		if(head.next!=null)
			head.next.pre=tnode;
		else{
			if(debug)System.out.println("updating  tail  "+tnode);
			tail=tnode;
		}
		head.next=tnode;
		return tnode;
	}

	public Lnode removeLast() {
		Lnode oldtail=tail;
		tail=tail.pre;
		return oldtail;
	}

	public int get(int key) {
		if (valuemap.containsKey(key)) {
			Lnode node = valuemap.get(key);
			makefirst(node);
			return node.value;
		} else {
			return -1;
		}
	}

	public void set(int key, int value) {
		if(valuemap.containsKey(key)){
			Lnode node = valuemap.get(key);
			makefirst(node);
			node.value=value;
		}else{
			//not contain key
			Lnode nnode=genfirst(value,key);
			if(debug)System.out.println("adding "+nnode);
			valuemap.put(key, nnode);
			//System.out.println("size="+valuemap.size());
			if(valuemap.size()>n){
				Lnode tailnode=removeLast();
				if(debug)System.out.println("removing..."+tailnode);
				valuemap.remove(tailnode.key);
			}
		}
	}
	public static void main(String[] args) {
		LRUCacheS2 lu = new LRUCacheS2(2);
		lu.set(2,1);
		lu.set(1,1);
		System.out.println(lu.get(2));
		lu.debuglist();
		lu.set(4,1);
		lu.debuglist();
		System.out.println(lu.get(1));
		lu.debuglist();
		System.out.println(lu.get(2));
	}
	public void debuglist(){
		Lnode p=head;
		System.out.print("[");
		while(p.next!=null){
			System.out.print(p.next.key+",");
			p=p.next;
		}
		System.out.print("]+\t\t");
		System.out.print(valuemap+"\t");
		System.out.println("tail="+tail);
	}

}
