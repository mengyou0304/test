package cn.jsi.buaa;

import java.util.HashMap;

public class TwoSu {
HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
    
    public int[] hash(int[] numbers, int target){
        int len=numbers.length;
        int[] res=new int[2];
        for(int i=0;i<len;i++){
            Integer j=map.get(target-numbers[i]);
    //        System.out.println("Tring value="+(target-numbers[i])+"  i="+i+" j="+j);
            if(j!=null&&i!=j){
                if(i<j){
                 res[0]=i+1;
                 res[1]=j+1;
                }
                else{
                    res[0]=j+1;
                    res[1]=i+1;
                }
                return res;
            }
            map.put(numbers[i],i);
       //     System.out.println("put key="+numbers[i]+" vlaue="+i);
        }
        return res;
    }
    public int[] twoSum(int[] numbers, int target) {
        return hash(numbers,target);
    }
    public int[] getTestedData(){
    	int[] data=new int[]{0,1,2,3,9,0};
    	return data;
    }
    public static void main(String[] args) {
    	TwoSu s=new TwoSu();
    	int[] rs=s.twoSum(s.getTestedData(),0);
    	for(int i:rs)
    		System.out.println(i);
	}

}
