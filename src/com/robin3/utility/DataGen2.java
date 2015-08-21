package com.robin3.utility;

import java.util.List;

import cn.jsi.buaa.basic.TreeNode;

public class DataGen2 {
	public TreeNode genTree(String s){
		char[] cc=s.toCharArray();
		TreeNode droot=new TreeNode(-1);
		TreeNode p=droot;
		for(char c:cc){
			
		}
		return droot.right;
	}
	public String serilizeTree(TreeNode root){
		return "";
	}
	private void bfsSerilization(TreeNode root){
		
	}
	public static void ShowLL(List<List<String>> list){
		if(list.size()==0)
			System.out.println("list's size ==0");
		for(List<String> tl:list){
			for(String s:tl)
				System.out.print(s+",");
			System.out.println();
		}
	}
	public static void ShowLL2(List<List<Integer>> list){
		if(list.size()==0)
			System.out.println("list's size ==0");
		for(List<Integer> tl:list){
			for(Integer s:tl)
				System.out.print(s+",");
			System.out.println();
		}
	}
	public static void ShowL(List<Integer> spiralOrder) {
		for(Integer i:spiralOrder){
			System.out.print(i);
		}
		System.out.println();
		
	}


}
