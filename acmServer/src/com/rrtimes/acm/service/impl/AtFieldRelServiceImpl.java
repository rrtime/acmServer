/*      						
 * Copyright 2016 Beijing RRTIMES, Inc. All rights reserved.
 * 
 * History:
 * ------------------------------------------------------------------------------
 * Date    			|  		Who  			|  		What  
 * 2016-05-03		| 	    yanxb 			| 	create the file                       
 */
package com.rrtimes.acm.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;


import com.rrtimes.acm.domain.AtFieldDict;
import com.rrtimes.acm.domain.AtFieldRel;
import com.rrtimes.acm.domain.AtHoldFunction;
import com.rrtimes.acm.domain.AtModelFunction;
import com.rrtimes.acm.domain.AtSysModel;
import com.rrtimes.acm.domain.PageObject;
import com.rrtimes.acm.persistence.AtFieldRelMapper;
import com.rrtimes.acm.persistence.AtHoldFunctionMapper;
import com.rrtimes.acm.serviceI.AtFieldRelService;
import com.rrtimes.acm.util.JsonUtil;
import com.rrtimes.acm.util.StringUtil;

/**
 * @Title:       AtFieldDictServiceImpl.java
 * @Package:     com.rrtimes.acm.service.impl
 * @Description: 用户字段权限关系 Service 接口实现类
 * 
 * <p>
 * 	用户字段权限关系 Service 接口实现类
 * </p> 
 * 
 * @author yanxbAtFieldDict
 * 
 */
public class AtFieldRelServiceImpl implements AtFieldRelService {

	@Resource
	private AtFieldRelMapper atFieldRelMapper;

	/**
	 * 根据用户或用户组ID查询字段权限关系
	 * @return
	 */
	@Override
	public List<AtFieldRel> getAtFieldRelListByUid(int uid) {
		return atFieldRelMapper.getAtFieldRelListByUid(uid);
	}

	/**
	 * 根据角色ID删除字段权限关系
	 * @return
	 */
	@Override
	public int delAllByActorId(int uid) {
		return atFieldRelMapper.delAllByActorId(uid);
	}
	
	/**
	 * 用户字段权限修改
	 * @param funIds 功能字典ID数组
	 * @param actorId 所要授权的用户或用户组
	 * @param operator 操作员ID
	 */
	@Override
	public int modifyFieldRel(String[] fieldIds,int actorId,int operator) throws Exception {
		int result = 0;
		//首先删除该用户或者组已有功能操作权限
		this.delAllByActorId(actorId);
		if(null != fieldIds && fieldIds.length > 0){
			//根据fieldIds查询系统权限字段字典
			List<AtFieldDict> FieldDictList = atFieldRelMapper.getFieldDictByIdArray(fieldIds);
			//再重新插入
			if(StringUtil.isListNotNull(FieldDictList)){
				int insertResult = 0;
				AtFieldRel fieldRel = new AtFieldRel();
				for(int i=0;i<FieldDictList.size();i++){
					//封装对象
					fieldRel.setMenuCode(FieldDictList.get(i).getMenuCode());
					fieldRel.setRname(FieldDictList.get(i).getFname());
					fieldRel.setPrivilegeType(1);
					fieldRel.setFid(FieldDictList.get(i).getId());
					fieldRel.setUid(actorId);
					fieldRel.setIsUserGroup(1);
					fieldRel.setOperator(String.valueOf(operator));
					fieldRel.setUpdateTime(new Date());
					fieldRel.setRemark("");
					//插入
					insertResult = atFieldRelMapper.insert(fieldRel);
					if(insertResult <= 0){//插入失败
						result = 1;
						break;
					}
				}
			}
		}
		return result;
	}


}
