/*      						
 * Copyright 2016 Beijing RRTIMES, Inc. All rights reserved.
 * 
 * History:
 * ------------------------------------------------------------------------------
 * Date    			|  		Who  			|  		What  
 * 2016-05-03		| 	    liht 			| 	create the file                       
 */

package com.rrtimes.acm.action;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.rrtimes.acm.domain.AtUser;
import com.xinwei.system.action.util.WebUtil;

/**
 * 
 * 系统非法登录拦截
 * 
 * <p>
 * 	系统非法登录拦截
 * </p> 
 * 
 * @author lihaitao
 * 
 */

public class AuthenticationInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 3019935162193639755L;

	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		ActionContext actionContext = invocation.getInvocationContext();
		HttpServletRequest request = ServletActionContext.getRequest();
		AtUser atUser = (AtUser)request.getSession().getAttribute("atUser");
		if( atUser == null )
		{
			//获取访问路径
			actionContext.put("requestURL", WebUtil.getRequestURLWithParams());
			//未登录,跳转到系统登录界面
			return "sys_login";
		}
		else
		{
			System.out.println("yhqljxx."+new Date());
		}
		//用户已认证
		return invocation.invoke();
	}

}
