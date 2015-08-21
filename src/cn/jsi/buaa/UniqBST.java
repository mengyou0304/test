package cn.jsi.buaa;

public class UniqBST {
	int[] ns;
    public int numTrees(int n) {
        if(n<=2)
            return n;
        ns=new int[n+1];
        ns[0]=1;
        ns[1]=1;
        ns[2]=2;
        for(int l=3;l<=n;l++){
            int sum=0;
            for(int i=0;i<l;i++){
                sum+=ns[i]*ns[l-1-i];
            }
            ns[l]=sum;
        }
        return ns[n];
        
    }
    public static void main(String[] args) {
    	UniqBST bst=new UniqBST();
    	int l=bst.numTrees(3);
    	System.out.println(l);
	}

}
