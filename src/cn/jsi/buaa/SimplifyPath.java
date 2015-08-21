package cn.jsi.buaa;

import java.util.Stack;

public class SimplifyPath {
	public static void main(String[] args) {
		SimplifyPath sp=new SimplifyPath();
		String t=sp.simplifyPath("/a/./b///../c/../././../d/..//../e/./f/./g/././//.//h///././/..///");
		System.out.println(t);
	}
	public String simplifyPath(String path) {
        String[] ss=path.split("/");
        Stack<String> pathst=new Stack<String>();
        for(String ts:ss){
            if(ts.equals(".")||ts.length()==0)
                continue;
            if(ts.equals("..")){
                if(pathst.size()>0)
                    pathst.pop();
            }
            else
                pathst.push(ts);
        }
        String res="";
        while(pathst.size()>0){
            String ts=pathst.pop();
            res="/"+ts+res;
        }
        res=res.replaceAll("//","/");
        if(res.length()==0)
            return "/";
        return res;
        
    }

}
