package cn.jsi.buaa;

public class LongestPrefix {
	public String longestCommonPrefix(String[] strs) {
        if(strs.length==0)
            return "";
        String demo=strs[0];
        int i;
        int j;
        for(i=0;i<demo.length();i++){
            char c=demo.charAt(i);
          //  System.out.println("comparing "+c);
            for(j=1;j<strs.length;j++){
            	 if(strs[j].length()<=i)
                 	break;
                if(c!=strs[j].charAt(i))
                     break;
            }
          //  System.out.println("j="+j);
            if(j!=strs.length)
            	break;
        }
        return demo.substring(0,i);
        
    }
	public static void main(String[] args) {
		LongestPrefix p=new LongestPrefix();
		String s=p.longestCommonPrefix(new String[] {"aa","aaaa"});
		System.out.println(s);
		
	}

}
