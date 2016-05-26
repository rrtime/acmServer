/*      						
 * Copyright 2016 Beijing RRTIMES, Inc. All rights reserved.
 * 
 * History:
 * ------------------------------------------------------------------------------
 * Date    			|  		Who  			|  		What  
 * 2016-05-03		| 	    liht 			| 	create the file                       
 */

package com.rrtimes.acm.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IdentifyingCodeAction extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public IdentifyingCodeAction() {
		super();
	}


	public void destroy() {
		super.destroy(); 
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String valicode = request.getParameter("valicode");
		String sessionValicode = request.getSession().getAttribute(
		"valicode").toString();
		if (!(sessionValicode.equals(valicode))) {
			response.getWriter().print("<?xml version=\"1.0\" encoding=\"UTF-8\"?><row>1</row>");
		}else{
			response.getWriter().print("<?xml version=\"1.0\" encoding=\"UTF-8\"?><row>0</row>");
		}

		/*HttpServletResponse resp = ServletActionContext.getResponse();
		response.setContentType("textml; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		out.println(str);
		out.flush();
		out.close();
*/




	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		this.doGet(request, response);
//		response.setContentType("text/html");
//		PrintWriter out = response.getWriter();
//		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
//		out.println("<HTML>");
//		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
//		out.println("  <BODY>");
//		out.print("    This is ");
//		out.print(this.getClass());
//		out.println(", using the POST method");
//		out.println("  </BODY>");
//		out.println("</HTML>");
//		out.flush();
//		out.close();
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
