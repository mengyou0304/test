package com.robin3;

import java.util.ArrayList;

public class ValidNumber {
	char[] cc;

	public boolean isNumber(String s) {
		boolean coma = false;
		boolean sci = false;
		cc = s.toCharArray();
		int stpo = 0;
		int endpo = cc.length - 1;
		int comapo = -5;
		int scipo = -5;

		boolean end = true;
		for (int i = cc.length - 1; i >= 0; i--) {
			if (end) {
				if (cc[i] == ' ')
					continue;
				else {
					end = false;
					endpo = i;
				}
			}
		}
		boolean start = true;
		for (int i = 0; i <= endpo; i++) {
			if (start) {
				if (cc[i] == ' ')
					continue;
				else {
					start = false;
					stpo = i;
				}
			}
			if (cc[i] > '9' || cc[i] < '0') {
				if (cc[i] == '.') {
					if (coma)
						return false;
					coma = true;
					comapo = i;
					if (scipo!=-5&&scipo < comapo)
						return false;
				} else if (cc[i] == 'e' || cc[i] == 'E') {
					if (sci)
						return false;
					sci = true;
					scipo = i;
					
				} else
					return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		ValidNumber v=new ValidNumber();
		ArrayList<String> tlist=new ArrayList<String>();
		tlist.add("  123  ");
		tlist.add("  1.1 e23  ");
		tlist.add("  1.1e2.3  ");
		tlist.add("  1e12.3  ");
		for(String s:tlist)
			System.out.println(v.isNumber(s));
	}
	

}
