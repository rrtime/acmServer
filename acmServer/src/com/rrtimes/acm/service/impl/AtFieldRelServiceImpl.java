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
	
	@Resource
	private AtHoldFunctionMapper atHoldFunctionMapper;
	
	/**
	 * 新增、修改用户字段权限关系
	 * @param dictIds
	 * @param priTypes
	 * @param uid
	 * @param operator
	 * @return
	 * @throws Exception
	 */
	public int grantDictToUserOrRole(String[] dictIds,String[] priTypes,int uid,int operator) throws Exception {
		int result = 0;
		//首先删除该用户或者组已有字段权限
		this.delFieldRelByDictIdsAndUid(dictIds, uid);
		//根据dictIds查询系统权限字段字典
		List<AtFieldDict> fieldDictList = atFieldRelMapper.getFieldDictListByIdArray(dictIds);
		if(StringUtil.isListNotNull(fieldDictList)){//字段字典不为空时，再去插入，否则不做操作
			int insertResult = 0;
			AtFieldRel atFieldRel = new AtFieldRel();
			for(int i=0;i<fieldDictList.size();i++){//循环插入
				//封装对象
				atFieldRel.setMenuCode(fieldDictList.get(i).getMenuCode());
				atFieldRel.setRname(fieldDictList.get(i).getFname());
				atFieldRel.setPrivilegeType(Integer.valueOf(priTypes[i]));
				atFieldRel.setFid(fieldDictList.get(i).getId());
				atFieldRel.setUid(uid);
				atFieldRel.setIsUserGroup(1);
				atFieldRel.setOperator(String.valueOf(operator));
				atFieldRel.setUpdateTime(new Date());
				atFieldRel.setRemark("");
				//插入
				insertResult = atFieldRelMapper.insert(atFieldRel);
				if(insertResult <= 0){//插入失败
					result = 1;
					break;
				}
			}
		}
		return result;
	}
	
	/**
	 * 系统功能操作权限授权
	 * @param funIds 功能字典ID数组
	 * @param actorId 所要授权的用户或用户组
	 * @param operator 操作员ID
	 */
	public int grantHoldFunction(String[] funIds,int actorId,int operator) throws Exception {
		int result = 0;
		//首先删除该用户或者组已有功能操作权限
		this.delHoldFunctionByFunIdsAndActorId(funIds, actorId);
		//根据funId查询功能详细操作字典
		List<AtModelFunction> modelFunctionList = atHoldFunctionMapper.getModelFunctionListByIdArray(funIds);
		//再重新插入
		if(StringUtil.isListNotNull(modelFunctionList)){//功能详细操作字典不为空时，再去插入，否则不做操作
			int insertResult = 0;
			AtHoldFunction atHoldFunction = new AtHoldFunction();
			for(int i=0;i<modelFunctionList.size();i++){//循环插入
				//封装对象
				atHoldFunction.setMenuCode(modelFunctionList.get(i).getMenuCode());
				atHoldFunction.setFunName(modelFunctionList.get(i).getFname());
				atHoldFunction.setFunId(modelFunctionList.get(i).getId());
				atHoldFunction.setActorId(actorId);
				atHoldFunction.setOperator(String.valueOf(operator));
				atHoldFunction.setUpdateTime(new Date());
				atHoldFunction.setRemark("");
				//插入
				insertResult = atHoldFunctionMapper.insert(atHoldFunction);
				//插入结果
				if(insertResult <= 0){//插入失败
					result = 1;
					break;
				}
			}
		}
		return result;
	}
	
	/**
	 * 根据功能详细操作字典IDS删除字体功能操作权限
	 * @param funIds
	 * @return
	 */
	public int delHoldFunctionByFunIdsAndActorId(String[] funIds,int actorId) throws Exception {
		//根据ID查询属于哪一个菜单树
		Map<String,Object> map = new HashMap<String,Object>();
		int result = 0;
		List<AtSysModel> treeIdList = atHoldFunctionMapper.getTreeIdByFunIdArray(funIds);
		//循环将所属菜单树的权限删除
		for(int i=0;i<treeIdList.size();i++){
			map.put("actorId", actorId);
			map.put("treeId", treeIdList.get(i).getTreeId());
			result = atHoldFunctionMapper.delHoldFunctionByActorIdAndTreeId(map);
		}
		return result;
	}

	/**
	 * 删除该用户或者组已有字段权限关系
	 * @param dictIds
	 * @param uid
	 */
	@Override
	public int delFieldRelByDictIdsAndUid(String[] dictIds, int uid) throws Exception {
		Map<String,Object> map = new HashMap<String,Object>();
		int result = 0;
		if(dictIds != null){
			//根据ID查询属于哪一个菜单树
			List<AtSysModel> treeIdList = atFieldRelMapper.getTreeIdByDictIdArray(dictIds);
			for(int i=0;i<treeIdList.size();i++){//循环删除所属菜单树的字段权限
				map.put("uid", uid);
				map.put("treeId", treeIdList.get(i).getTreeId());
				result = atFieldRelMapper.delAtFieldRelByUidAndTreeId(map);
			}
		}
		return result;
	}

	/**
	 * 根据ID删除用户字段权限关系
	 */
	@Override
	public int delAtFieldRel(int id) throws Exception {
		return atFieldRelMapper.delete(id)>0?0:1;
	}

	/**
	 * 查询用户字段权限关系详情
	 * 
	 * */
	@Override
	public AtFieldRel queryDetailInfo(int id) throws Exception {
		return atFieldRelMapper.findById(id);
	}

	/**
	 * 查询用户字段权限关系列表(分页)
	 * 
	 * */
	@Override
	public List<AtFieldRel> queryListByPage(AtFieldRel atFieldRel, PageObject page) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		//参数
		if(!StringUtil.isEmtryStr(atFieldRel.getMenuCode())){//功能编码
			map.put("menuCode", atFieldRel.getMenuCode());
		}
		if(!StringUtil.isEmtryStr(atFieldRel.getRname())){//名称
			map.put("rname", atFieldRel.getRname());
		}
		if(atFieldRel.getPrivilegeType() > 0){//权限码
			map.put("privilegeType", atFieldRel.getPrivilegeType());
		}
		if(atFieldRel.getFid() > 0){//字典ID
			map.put("fid", atFieldRel.getFid());
		}
		if(atFieldRel.getUid() > 0){//用户或用户组ID
			map.put("uid", atFieldRel.getUid());
		}
		if(!StringUtil.isEmtryStr(atFieldRel.getRemark())){//备注
			map.put("remark", atFieldRel.getRemark());
		}
		// 查询条件下的数据总量查询
		page.setSumCloum(atFieldRelMapper.findByCount(map));
		map.put("page", page);
		// 分页查询结果
		return atFieldRelMapper.findByPage(map);
	}

	/**
	 * 根据用户或组ID和menuCode查询用户字段权限关系
	 * @param uid
	 * @param menuCode
	 * @return
	 */
	@Override
	public List<AtFieldRel> findAtFieldRelByUidAndMenuCode(int uid,String menuCode) throws Exception {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("uid", uid);
		map.put("menuCode", menuCode);
		return atFieldRelMapper.findAtFieldRelByUidAndMenuCode(map);
	}

	/**
	 * 根据用户或用户组ID和菜单树ID删除用户字段权限关系
	 * 
	 * */
	@Override
	public int delAtFieldRelByUidAndTreeId(int uid, int treeId) throws Exception {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("uid", uid);
		map.put("treeId", treeId);
		return atFieldRelMapper.delAtFieldRelByUidAndTreeId(map)>0?0:1;
	}

	/**
	 * 查询所有数据
	 */
	@Override
	public List<AtFieldRel> findAll() throws Exception {
		return atFieldRelMapper.findAll();
	}

	/**
	 * 根据用户或组ID和treeId查询用户字段权限关系
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String,Object>> findAtFieldRelByUidAndTreeId(int uid, int treeId) throws Exception {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("uid", uid);
		map.put("treeId", treeId);
		return atFieldRelMapper.findAtFieldRelByUidAndTreeId(map);
	}

	/**
     * 将Json对象转换成List
     * 
     * @param jsonObject
     *            json对象
     * @return list对象
	 * @throws Exception 
     */
	@SuppressWarnings("unchecked")
	@Override
    public int grantToUserOrRole(String jsonStr,int uid,int operator) throws Exception {
		//将json解析为list
		List<Map<String,Object>> jsonList = (List<Map<String, Object>>) JsonUtil.jsonParse(jsonStr);
		int result = 0;
		StringBuffer sbFunIds = new StringBuffer();//功能操作ID串
		StringBuffer sbDictIds = new StringBuffer();//字段字典ID串
		StringBuffer sbPriTypes = new StringBuffer();//字段权限ID串
		for(int i=0;i<jsonList.size();i++){//将所有的ID拼接成字符串
			//1、拼接功能操作ID串
			List<Map<String,Object>> funIdList = (List<Map<String, Object>>) jsonList.get(i).get("funId");
			if(StringUtil.isListNotNull(funIdList)){//funId不为空的时候
				for(int m=0;m<funIdList.size();m++){//获取每一个funId
					String funId = (String) funIdList.get(m).get("id");
					if(m==funIdList.size()-1){//当为最后一个ID时，不需要最后的“,”
						if(i==jsonList.size()-1){
							sbFunIds.append(funId);
						}else{
							sbFunIds.append(funId).append(",");
						}
					}else{
						sbFunIds.append(funId).append(",");
					}
				}
			}
			//2、拼接字段字典ID串
			List<Map<String,Object>> dictIdList = (List<Map<String, Object>>) jsonList.get(i).get("dictId");
			if(StringUtil.isListNotNull(dictIdList)){//dictId不为空时
				for(int m=0;m<dictIdList.size();m++){//获取每一个dictId以及对应的权限码
					String dictId = (String) dictIdList.get(m).get("id");//字段ID
					String privilegeType = (String) dictIdList.get(m).get("privilegeType");//权限码
					if(m==dictIdList.size()-1){//当为最后一个ID时，不需要最后的“,”
						if(i==jsonList.size()-1){
							sbDictIds.append(dictId);
							sbPriTypes.append(privilegeType);
						}else{
							sbDictIds.append(dictId).append(",");
							sbPriTypes.append(privilegeType).append(",");
						}
					}else{
						sbDictIds.append(dictId).append(",");
						sbPriTypes.append(privilegeType).append(",");
					}
				}
			}
		}
		if(!StringUtil.isEmtryStr(sbFunIds.toString())){//funId不为空
			//将字符串转换成数组
			String[] funIds = sbFunIds.toString().split(",");
			//调用插入方法
			result = this.grantHoldFunction(funIds, uid, operator);
		}
		if(!StringUtil.isEmtryStr(sbDictIds.toString())){//dictId不为空
			//将字符串转换成数组
			String[] dictIds = sbDictIds.toString().split(",");
			String[] priTypes = sbPriTypes.toString().split(",");
			//调用插入方法
			result = this.grantDictToUserOrRole(dictIds, priTypes, uid, operator);
		}
		return result;
    }

	/**
	 * 根据用户或用户组ID查询字段权限关系
	 * @return
	 */
	@Override
	public List<AtFieldRel> getAtFieldRelListByUid(int uid) {
		return atFieldRelMapper.getAtFieldRelListByUid(uid);
	}

}
