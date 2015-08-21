package cn.jsi.buaa;

public class ContainerWithMostWater {
	public int maxArea(int[] height) {
		int[] h = height;
		int start = 0;
		int end = height.length - 1;
		int maxs = 0;
		while (true) {
			if (h[start] > h[end]){
				maxs = Math.max(h[end] * (end - start), maxs);
				end--;
			}
			else{
				maxs = Math.max(h[start] * (end - start), maxs);
				start++;
			}
			if (start >= end)
				break;
		}
		return maxs;
	}

	public static void main(String[] args) {
		ContainerWithMostWater cw = new ContainerWithMostWater();
		int v=cw.maxArea(new int[]{1,2,3,4,5,6,7,8,7,6,5,4,3,2,1});
		System.out.println(v);
	}

}
