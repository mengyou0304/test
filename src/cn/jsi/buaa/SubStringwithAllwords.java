package cn.jsi.buaa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class SubStringwithAllwords {
	int winlen, baselen;
	ArrayList<Integer> reslist = new ArrayList<Integer>();
	int[] reach;
	String alls;
	HashMap<String, Integer> reachedMap = new HashMap<String, Integer>();

	public void initReach() {
	    Iterator<String> it=reachedMap.keySet().iterator();
	    int i=0;
	    while(it.hasNext()){
	        String ts=it.next();
	        reach[i++]=reachedMap.get(ts);
	    }
	}

	public ArrayList<Integer> findSubstring(String S, String[] L) {
		if (L.length == 0)
			return reslist;
		baselen = L[0].length();
		winlen = baselen * L.length;
		alls = S;
		for (String ts : L) {
		    Integer v=reachedMap.get(ts);
		    if(v==null)
		        v=0;
		    reachedMap.put(ts,v+1);
		}
		int j=reachedMap.keySet().size();
		reach = new int[j];
		initReach();
		int i = 0;
		while (i + winlen <= S.length()) {
			boolean ismatch = tryMatch(i);
			initReach();
			if (ismatch)
				reslist.add(i);
			i++;
		}
		return reslist;
	}

	public boolean tryMatch(int starter) {
	//	System.out.println("try match "+starter);
		int st = starter;
		while (starter < st + winlen) {
			String ts = alls.substring(starter, starter + baselen);
			Integer key = reachedMap.get(ts);
			//System.out.println("key="+key);
			if (key == null)
				return false;
			reach[key]--;
			if (reach[key] < 0)
				return false;
			starter+=baselen;
		}
		for (int i : reach)
			if (i != 0)
				return false;
		return true;
	}

	public static void main(String[] args) {
		SubStringwithAllwords ss = new SubStringwithAllwords();
		ArrayList<Integer> list = ss.findSubstring("lingmindraboofooowingdingbarrwingmonkeypoundcake",
				new String[] { "foo", "bar" });
		System.out.println(list);
	}

}
