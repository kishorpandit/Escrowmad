package com.info;

import java.util.HashMap;

public class RepetString {
	
 public void checkStrin(String str) {
	
 }

 
 public static void main(String[] args) {
	 String str = "abdde";
	 System.out.println(checkDuplicate(str)); 
}


private static boolean checkDuplicate(String str) {
	boolean flag =true ;
	 String srt1 = str;
	 char[] chrs = srt1.toCharArray();
	 HashMap<Character,Integer> map = new HashMap<Character,Integer>();
	 
	 for (char c : chrs) {
		if(!map.containsKey(c)) {
			map.put(c, 1);
			flag = false;
		}else {
			int value = map.get(c);
			map.put(c, value+1);
			flag = true;
		}
	}
	return flag;
}
}
