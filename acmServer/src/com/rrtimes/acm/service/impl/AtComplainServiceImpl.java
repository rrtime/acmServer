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

import com.rrtimes.acm.domain.AtComplain;
import com.rrtimes.acm.domain.PageObject;
import com.rrtimes.acm.persistence.AtComplainMapper;
import com.rrtimes.acm.service.AtComplainService;
import com.rrtimes.acm.util.StringUtil;

/**
 * @Title:       AtComplainServiceImpl.java
 * @Package:     com.rrtimes.acm.service.impl
 * @Description: 客户投诉信息 Service 接口实现
 * 
 * <p>
 * 	客户投诉信息 Service 接口实现
 * </p> 
 * 
 * @author yanxb
 * 
 */
public class AtComplainServiceImpl implements AtComplainService {

	@Resource
	private AtComplainMapper atComplainMapper;
	
	@Override
	public int addAtComplain(AtComplain atComplain) {
		return atComplainMapper.insert(atComplain)>0?0:1;
	}

	@Override
	public int modAtComplain(AtComplain atComplain) {
		return atComplainMapper.update(atComplain);
	}

	@Override
	public int delAtComplain(int id) {
		return atComplainMapper.delete(id)>0?0:1;
	}

	@Override
	public AtComplain queryDetailInfo(int id) {
		return atComplainMapper.findById(id);
	}

	@Override
	public List<AtComplain> queryListByPage(AtComplain atComplain, PageObject page) {
		Map<String, Object> map = new HashMap<String, Object>();
		//参数
		if(!StringUtil.isEmtryStr(atComplain.getCpCode())){
			map.put("cpCode", atComplain.getCpCode());
		}
		if(!StringUtil.isEmtryStr(atComplain.getCsrIdentifer())){
			map.put("csrIdentifer", atComplain.getCsrIdentifer());
		}
		if(atComplain.getCnFrom() >= 0){
			map.put("cnFrom", atComplain.getCnFrom());
		}
		if(atComplain.getCnType() >= 0){
			map.put("cnType", atComplain.getCnType());
		}
		if(!StringUtil.isEmtryStr(atComplain.getCnTheme())){
			map.put("cnTheme", "%" + atComplain.getCnTheme() + "%");
		}
		if(!StringUtil.isEmtryStr(atComplain.getCnPrincipal())){
			map.put("cnPrincipal", atComplain.getCnPrincipal());
		}
		if(atComplain.getCnStatus() >= 0){
			map.put("cnStatus", atComplain.getCnStatus());
		}
		if(!StringUtil.isEmtryStr(atComplain.getOperator())){
			map.put("operator", atComplain.getOperator() );
		}
		if(!StringUtil.isEmtryStr(atComplain.getRemark())){
			map.put("remark", "%" + atComplain.getRemark() + "%");
		}
		// 数据总量查询
		page.setSumCloum(atComplainMapper.findByCount(map));
		map.put("page", page);
		//返回分页结果
		return atComplainMapper.findByPage(map);
	}

	@Override
	public int changeCnStatus(AtComplain atComplain) {
		int status = atComplain.getCnStatus();//状态
		//设置信息
		if(status == 3){//如果投诉调查已经完成
			String cnInquire = atComplain.getCnInquire();//投诉调查内容
			atComplain.setCnInquire(cnInquire);
		}else if(status == 4){//如果调查处理结果已经完成
			String cnResult = atComplain.getCnResult();//投诉调查处理结果
			atComplain.setCnResult(cnResult);
		}
		//修改投诉记录信息
		this.modAtComplain(atComplain);
		//返回修改后的状态
		return Integer.valueOf(status);
	}

}
