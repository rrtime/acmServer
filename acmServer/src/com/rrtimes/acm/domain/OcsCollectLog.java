/*      						
 * Copyright 2015 Beijing T-Star, Inc. All rights reserved.
 * 
 * History:
 * ------------------------------------------------------------------------------
 * Date    			|  		Who  			|  		What  
 * 2015-01-21		| 	    liht 			| 	create the file                       
 */
package com.rrtimes.acm.domain;

import java.util.Date;

/**
 * @Title:       OcsCollectLog.java
 * @Package:     com.tstar.charge.domain
 * @Description: 话单分拣记录表实体类
 * 
 * <p>
 *  话单分拣记录表实体
 * </p> 
 * 
 * @author liht
 * 
 */
public class OcsCollectLog {
	
	private String id;
	
	private String host;
	
	private String fileName;
	
	private String archiveDirectory;
	
	private String sourceDirectory;
	
	private String cachedDirectory;
	
	private String fileType;
	
	private int flag = -1;
	
	private int recordCount;
	
	private int abnormalCount;
	
	private Date createTime;
	
	private Date updateTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getArchiveDirectory() {
		return archiveDirectory;
	}

	public void setArchiveDirectory(String archiveDirectory) {
		this.archiveDirectory = archiveDirectory;
	}

	public String getSourceDirectory() {
		return sourceDirectory;
	}

	public void setSourceDirectory(String sourceDirectory) {
		this.sourceDirectory = sourceDirectory;
	}

	public String getCachedDirectory() {
		return cachedDirectory;
	}

	public void setCachedDirectory(String cachedDirectory) {
		this.cachedDirectory = cachedDirectory;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public int getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}

	public int getAbnormalCount() {
		return abnormalCount;
	}

	public void setAbnormalCount(int abnormalCount) {
		this.abnormalCount = abnormalCount;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}
