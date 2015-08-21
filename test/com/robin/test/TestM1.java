package com.robin.test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

public class TestM1 {
	public static void main(String[] args) {
		LinkedList<Integer> list=new LinkedList<Integer>();
		for(int i=0;i<10;i++){
			list.add(i);
		}
		System.out.println(list.get(2));
		list.remove(2);
		System.out.println(list.get(2));
		list.remove(2);
		System.out.println(list.get(2));
		list.remove(2);
		

		
	}
	

}
