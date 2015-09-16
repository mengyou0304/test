package com.robin3.utility;

import cn.jsi.buaa.basic.TreeNode;

import java.util.List;

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
	public static void showBit(Integer v){
		StringBuffer sb=new StringBuffer();
		boolean leadingZ=false;
		for(int i=31;i>=0;i--) {
			if((v&(1<<i))>0) {
				sb.append(1);
				leadingZ=false;
			}
			else
				sb.append(leadingZ ? "" : 0);
		}
		System.out.println(sb.toString());
	}
	public static void ShowL(List<Integer> spiralOrder) {
		for(Integer i:spiralOrder){
			System.out.print(i);
		}
		System.out.println();
		
	}


}
