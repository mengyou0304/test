package cn.jsi.buaa;

import java.util.Scanner;

public class TPC1 {
	
	public static void main(String[] args) {
		 Scanner cin=new Scanner(System.in);
		 String s=cin.nextLine();
		 String[] ss=s.substring(1, s.length()-1).split(",");
		 int number=ss.length;
		 int[] inputs=new int[50];
		 int j=0;
		 for(String ts:ss){
			 inputs[j++]=Integer.parseInt(ts);
		 }
		 int min1=-1;
		 int length1=0;
		 int min2=-1;
		 int length2=0;
		 int key=0;
		 for(int i=ss.length-1;i>=0;i--){
			 if(inputs[i]>min1&&inputs[i]>min2){
				 if(min1<min2){
					 min2=inputs[i];
					 length2++;
				 }
				 else{
					 min1=inputs[i];
					 length1++;
				 }
				 continue;
			 }
			 if(inputs[i]>min1){
				 min1=inputs[i];
				 length1++;
				 continue;
			 }
			 if(inputs[i]>min2){
				 min2=inputs[i];
				 length2++;
				 continue;
			 }
			 if(length1<=length2){
				 min1=inputs[i];
				 key+=length1;
				 length1++;
			 }
			 else{
				 min2=inputs[i];
				 key+=length2;
				 length2++;
			 }
		}
		 System.out.println(key);
		 
		
		
	}
	

}
