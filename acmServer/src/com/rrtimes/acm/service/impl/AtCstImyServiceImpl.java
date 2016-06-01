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

import com.rrtimes.acm.domain.AtCstImy;
import com.rrtimes.acm.domain.PageObject;
import com.rrtimes.acm.persistence.AtCstImyMapper;
import com.rrtimes.acm.service.AtCstImyService;
import com.rrtimes.acm.util.StringUtil;

/**
 * @Title:       AtCstVisitServiceImpl.java
 * @Package:     com.rrtimes.acm.service.impl
 * @Description: 客户质量赔付记录 Service 实现类
 * 
 * <p>
 * 	客户质量赔付记录 Service 实现类
 * </p> 
 * 
 * @author yanxb
 * 
 */
public class AtCstImyServiceImpl implements AtCstImyService {

	@Resource
	private AtCstImyMapper atCstImyMapper;
	
	@Override
	public int addAtCstImy(AtCstImy atCstImy) {
		return atCstImyMapper.insert(atCstImy)>0?0:1;
	}

	@Override
	public int modAtCstImy(AtCstImy atCstImy) {
		atCstImy.setUpdateTime(new Date());
		return atCstImyMapper.update(atCstImy)>0?0:1;
	}

	@Override
	public int delAtCstImy(int id) {
		return atCstImyMapper.delete(id)>0?0:1;
	}

	@Override
	public AtCstImy queryDetailInfo(int id) {
		return atCstImyMapper.findById(id);
	}

	@Override
	public List<AtCstImy> queryListByPage(AtCstImy atCstImy, PageObject page) {
		Map<String, Object> map = new HashMap<String, Object>();
		//参数
		if(!StringUtil.isEmtryStr(atCstImy.getCpCode())){
			map.put("cpCode", atCstImy.getCpCode());
		}
		if(!StringUtil.isEmtryStr(atCstImy.getCnIdentifer())){
			map.put("cnIdentifer", atCstImy.getCnIdentifer());
		}
		if(atCstImy.getPayType() >= 0){
			map.put("payType", atCstImy.getPayType());
		}
		if(atCstImy.getImyForm() >= 0){
			map.put("imyFrom", atCstImy.getImyForm());
		}
		if(atCstImy.getImyStatus() >= 0){
			map.put("imyStatus", atCstImy.getImyStatus());
		}
		if(!StringUtil.isEmtryStr(atCstImy.getOperator())){
			map.put("operator", atCstImy.getOperator() );
		}
		if(!StringUtil.isEmtryStr(atCstImy.getRemark())){
			map.put("remark", atCstImy.getRemark());
		}
		// 数据总量查询
		page.setSumCloum(atCstImyMapper.findByCount(map));
		map.put("page", page);
		//返回分页结果
		return atCstImyMapper.findByPage(map);
	}

	@Override
	public int changeImyStatus(AtCstImy atCstImy) {
		//修改投诉记录信息
		this.modAtCstImy(atCstImy);
		//返回修改后的状态
		return atCstImy.getImyStatus();
	}

}
