/*      						
 * Copyright 2016 Beijing RRTIMES, Inc. All rights reserved.
 * 
 * History:
 * ------------------------------------------------------------------------------
 * Date    			|  		Who  			|  		What  
 * 2016-05-03		| 	    lil 			| 	create the file                       
 */
package com.rrtimes.acm.domain;

import java.sql.Timestamp;
import java.util.Date;

import com.rrtimes.acm.iinterface.ISerializable;

/**
 * @Title:       AtCstReportDict.java
 * @Package:     com.rrtimes.acm.domain
 * @Description: 类文件概述
 * 
 * <p>
 * 	类文件详细描述
 * </p> 
 * 
 * @author lil
 * 
 */
public class AtCstReportDict implements ISerializable{
        /**
	 * 
	 */
	private static final long serialVersionUID = 2393989750439113813L;
		private int id;                   //主键id
        private String reportName;        //财务报表名
        private String reportDesc;        //财务报表描述
        private String operator;          //操作员
        private Timestamp createTime;     //创建时间
        private Date updateTime;          //修改时间
        private String remark;            //备注
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getReportName() {
			return reportName;
		}
		public void setReportName(String reportName) {
			this.reportName = reportName;
		}
		public String getReportDesc() {
			return reportDesc;
		}
		public void setReportDesc(String reportDesc) {
			this.reportDesc = reportDesc;
		}
		public String getOperator() {
			return operator;
		}
		public void setOperator(String operator) {
			this.operator = operator;
		}
		public Timestamp getCreateTime() {
			return createTime;
		}
		public void setCreateTime(Timestamp createTime) {
			this.createTime = createTime;
		}
		public Date getUpdateTime() {
			return updateTime;
		}
		public void setUpdateTime(Date updateTime) {
			this.updateTime = updateTime;
		}
		public String getRemark() {
			return remark;
		}
		public void setRemark(String remark) {
			this.remark = remark;
		}
}
