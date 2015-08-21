package cn.jsi.buaa;

public class LengthOfLastWord {
	public int lengthOfLastWord(String s) {
        String[] ss=s.trim().split(" ");
        for(int i=ss.length-1;i>=0;i--){
            if(ss[i].length()==0)
                continue;
            else 
                return ss[i].length();
        }
        return 0;
    }
	public static void main(String[] args) {
		LengthOfLastWord lw=new LengthOfLastWord();
		int i=lw.lengthOfLastWord("hellow world aa");
		System.out.println(i);
	}

}
