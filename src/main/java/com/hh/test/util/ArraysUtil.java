package com.hh.test.util;

public class ArraysUtil {

	public static String Array2String(String[] arrays) {
		String result = "";
		if(arrays.length!=0){
			for (String string : arrays) {
				result += string + "、";
			}
			result=result.substring(0, result.lastIndexOf('、'));
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		String[] arrays={"a","b","c"};
		System.out.println(ArraysUtil.Array2String(arrays));
	}
	
}
