/*      						
 * Copyright 2016 Beijing RRTIMES, Inc. All rights reserved.
 * 
 * History:
 * ------------------------------------------------------------------------------
 * Date    			|  		Who  			|  		What  
 * 2016-05-03		| 	    lil 			| 	create the file                       
 */
package com.rrtimes.acm.serviceI;

import java.util.List;

import com.rrtimes.acm.domain.AcmSysOrg;
import com.rrtimes.acm.domain.PageObject;

/**
 * @Title:       AcmSysOrgService.java
 * @Package:     com.rrtimes.acm.service
 * @Description: 类文件概述
 * 
 * <p>
 * 	类文件详细描述
 * </p> 
 * 
 * @author lil
 * 
 */
public interface AcmSysOrgService {
    //组织机构分页
	public List<AcmSysOrg> queryOrg(AcmSysOrg aso, PageObject page);
	
	//新增组织机构
	public int addOrg(AcmSysOrg aso);
	
	//修改组织机构
	public int updateOrg(AcmSysOrg aso);
	
	//删除组织机构
	public int deleteOrg(int id);
	
	//通过id查询组织机构
	public AcmSysOrg queryOrgById(int id);
	
	//通过id查询当前组织机构的下级部门
	public List<AcmSysOrg> queryOrgByOid(int oid);
	
	//通过代账公司code查询当前代账公司的组织机构（不用分页）
	public List<AcmSysOrg> queryAll(String cpCode);
	
}
