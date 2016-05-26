/*      						
 * Copyright 2016 Beijing RRTIMES, Inc. All rights reserved.
 * 
 * History:
 * ------------------------------------------------------------------------------
 * Date    			|  		Who  			|  		What  
 * 2016-05-03		| 	    liht 			| 	create the file                       
 */

package com.rrtimes.acm.constant;

/**
 * @Title:       Constant.java
 * @Package:     com.tstar.charge.constant
 * @Description: 系统常量枚举类
 * 
 * <p>
 * 	系统常量枚举
 * </p> 
 * 
 * @author liht
 * 
 */
public class Const {
	
	/**
	 *  系统日志类型常量
	 * */
	// 正常
	public static final int SYSTEM_LOG_TYPE_RIGHT = 0;
	
	// 错误(指操作失败未成功的操作记录)
	public static final int SYSTEM_LOG_TYPE_WRONG = 1;
	
	
	/**
	 * 系统日志模块常量
	 * */
	// 系统登录
	public static final String SYSTEM_LOG_MODULE_LOGIN = "系统登录";
	
	// 话单分拣
	public static final String SYSTEM_LOG_MODULE_CDR_SORT = "话单分拣";
	
	// 计费管理
	public static final String SYSTEM_LOG_MODULE_CHARGE_MAG = "计费管理";
	
	// 费率管理
	public static final String SYSTEM_LOG_MODULE_RATE_MAG = "费率管理";
	
	// 账务管理
	public static final String SYSTEM_LOG_MODULE_BILL_MAG = "账务管理";
	
	// 系统管理
	public static final String SYSTEM_LOG_MODULE_SYSTEM_MAG = "系统管理";
	
	// 其它
	public static final String SYSTEM_LOG_MODULE_OTHER = "其它";
	
	
	

}
