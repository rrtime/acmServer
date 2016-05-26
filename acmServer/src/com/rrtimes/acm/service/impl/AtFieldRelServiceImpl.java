/*      						
 * Copyright 2016 Beijing RRTIMES, Inc. All rights reserved.
 * 
 * History:
 * ------------------------------------------------------------------------------
 * Date    			|  		Who  			|  		What  
 * 2016-05-03		| 	    yanxb 			| 	create the file                       
 */
package com.rrtimes.acm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.rrtimes.acm.domain.AtFieldRel;
import com.rrtimes.acm.domain.PageObject;
import com.rrtimes.acm.persistence.AtFieldRelMapper;
import com.rrtimes.acm.service.AtFieldRelService;
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
	
	@Override
	public int addAtFieldRel(List<AtFieldRel> atFieldRelList) {
		int result = 0;
		try{
			if(StringUtil.isListNotNull(atFieldRelList)){
				for(int i=0;i<atFieldRelList.size();i++){
					int insertResult = atFieldRelMapper.insert(atFieldRelList.get(i));
					if(insertResult <= 0){//插入失败
						result = 1;
						break;
					}
				}
			}
		}catch(Exception e){
			result = 1;
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int modAtFieldRel(List<AtFieldRel> atFieldRelList,int uid,int treeId) {
		int result = 0;
		try{
			//首先查询该用户或者组是否已有功能操作权限
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("uid", uid);
			map.put("treeId", treeId);
			List<Map<String,Object>> fieldRelList = atFieldRelMapper.findAtFieldRelByUidAndTreeId(map);
			//如果有，则先删除
			if(StringUtil.isListNotNull(fieldRelList)){
				atFieldRelMapper.delAtFieldRelByUidAndTreeId(map);
			}
			//再重新插入
			if(StringUtil.isListNotNull(atFieldRelList)){
				for(int i=0;i<atFieldRelList.size();i++){
					int insertResult = atFieldRelMapper.insert(atFieldRelList.get(i));
					if(insertResult <= 0){//插入失败
						result = 1;
						break;
					}
				}
			}
		}catch(Exception e){
			result = 1;
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int delAtFieldRel(int id) {
		return atFieldRelMapper.delete(id)>0?0:1;
	}

	@Override
	public AtFieldRel queryDetailInfo(int id) {
		return atFieldRelMapper.findById(id);
	}

	@Override
	public List<AtFieldRel> queryListByPage(AtFieldRel atFieldRel, PageObject page) {
		Map<String, Object> map = new HashMap<String, Object>();
		//参数
		if(!StringUtil.isEmtryStr(atFieldRel.getMenuCode())){
			map.put("menuCode", atFieldRel.getMenuCode());
		}
		if(!StringUtil.isEmtryStr(atFieldRel.getRname())){
			map.put("rname", "%" + atFieldRel.getRname() + "%");
		}
		if(atFieldRel.getPrivilegeType() >= 0){
			map.put("privilegeType", atFieldRel.getPrivilegeType());
		}
		if(atFieldRel.getFid() >= 0){
			map.put("fid", atFieldRel.getFid());
		}
		if(atFieldRel.getUid() >= 0){
			map.put("uid", atFieldRel.getUid());
		}
		if(!StringUtil.isEmtryStr(atFieldRel.getRemark())){
			map.put("remark", "%" + atFieldRel.getRemark() + "%");
		}
		// 数据总量查询
		page.setSumCloum(atFieldRelMapper.findByCount(map));
		map.put("page", page);
		// 分页查询结果
		return atFieldRelMapper.findByPage(map);
	}

	@Override
	public List<AtFieldRel> findAtFieldRelByUidAndMenuCode(int uid,String menuCode) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("uid", uid);
		map.put("menuCode", menuCode);
		return atFieldRelMapper.findAtFieldRelByUidAndMenuCode(map);
	}

	@Override
	public int delAtFieldRelByUidAndTreeId(int uid, int treeId) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("uid", uid);
		map.put("treeId", treeId);
		return atFieldRelMapper.delAtFieldRelByUidAndTreeId(map)>0?0:1;
	}

	@Override
	public List<AtFieldRel> findAll() {
		return atFieldRelMapper.findAll();
	}

	@Override
	public List<Map<String,Object>> findAtFieldRelByUidAndTreeId(int uid, int treeId) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("uid", uid);
		map.put("treeId", treeId);
		return atFieldRelMapper.findAtFieldRelByUidAndTreeId(map);
	}


}
