//package cn.jsi.buaa;
//
//import java.util.Stack;
//
//public class LongestParentness {
//	char[] cc;
//	public int longestValidParentheses(String s) {
//		cc = s.toCharArray();
//		Stack<Integer> st=new Stack<Integer>();
//		boolean isvalid=false;
//		int longest=0;
//		int line;
//		for(char c:cc){
//			if(c=='(')
//				st.add(1);
//			if(c==')'){
//				if(st.size()==0){
//					isvalid=false;
//				}
//				st.pop();
//			}
//		}
//		
//	}
//
//	public static void main(String[] args) {
//		LongestParentness lp = new LongestParentness();
//		int i = lp.longestValidParentheses("()");
//		System.out.println(i);
//	}
//
//}
