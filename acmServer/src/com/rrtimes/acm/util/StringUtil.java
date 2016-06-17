/*      						
 * Copyright 2016 Beijing RRTIMES, Inc. All rights reserved.
 * 
 * History:
 * ------------------------------------------------------------------------------
 * Date    			|  		Who  			|  		What  
 * 2016-05-03		| 	    liht 			| 	create the file                       
 */
package com.rrtimes.acm.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * @Title:       StringUtil.java
 * @Package:     com.tstar.charge.util
 * @Description: 系统公共类库
 * 
 * <p>
 * 	系统公共类库
 * </p> 
 * 
 * @author liht
 * 
 */
public class StringUtil {

	/**
	 * 校验当前传递时间和系统当前时间是否为同一天
	 * 
	 * @Return		boolean:	true 同一天	false 不同的天
	 * 
	 * */
	public static boolean checkTimeIsSameDay(Date date)
	{
		boolean flag = true;
		String ckDate = getFormatDate(date);
		String currentDate = getFormatDate(new Date());
		if( ckDate.length() > 10 && currentDate.length() > 10 )
		{
			// 如果年月日不相等则表明不为同一天返回 false
			if( !ckDate.substring(0, 10).equals(currentDate.substring(0, 10)) )
			{
				flag = false;
			}
		}
		else
		{
			flag = false;
		}
		return flag;
	}
	
	/**
	 * 日期信息转换  yyyy-MM-dd hh:mm:ss
	 * 
	 */
	public static String getFormatDate(Date standardDate)
	{  
		String tmp = "";
		try 
		{
			if( standardDate != null )
			{
					DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					tmp = dateFormat.format(standardDate);
			}
		} catch (Exception e){
			e.toString();
			e.printStackTrace();
		}
		return tmp;
	}
	
	/**
	 * 判断字符串是否为空或者空串
	 * @param str
	 * @return
	 */
	public static boolean isEmtryStr(String str){
		if(str==null || str.equals("null") || "".equals(str)){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 判断List是否为空
	 * @param list
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static boolean isListNotNull(List list){
		if(list == null || list.size() < 1){
			return false;
		}else{
			return true;
		}
	}
	
	/**
	 * 将ID数组转换成字符串
	 * @param ids
	 * @return
	 */
	public static String arrayToString(String[] ids){
		StringBuffer strBuff = new StringBuffer();
		try{
			for(int i=0;i<ids.length;i++){
				if(i==ids.length-1){
					strBuff.append(ids[i]);
				}else{
					strBuff.append(ids[i]).append(",");
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return strBuff.toString();
	}
	
	/**
	 * 将数组转换为list
	 * @param ids
	 * @return
	 */
	public static List<Integer> arrayToList(String[] ids){
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<ids.length;i++){
			list.add(Integer.valueOf(ids[i]));
		}
		return list;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("-------------"+checkTimeIsSameDay(new Date()));
	}

}
