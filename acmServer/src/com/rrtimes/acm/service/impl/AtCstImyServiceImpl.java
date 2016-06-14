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
import com.rrtimes.acm.serviceI.AtCstImyService;
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
	
	/**
	 * 新增客户质量赔付记录
	 * @throws Exception 
	 * 
	 * */
	@Override
	public int addAtCstImy(AtCstImy atCstImy) throws Exception {
		return atCstImyMapper.insert(atCstImy)>0?0:1;
	}

	/**
	 * 修改客户质量赔付记录
	 * @throws Exception 
	 * 
	 * */
	@Override
	public int modAtCstImy(AtCstImy atCstImy) throws Exception {
		atCstImy.setUpdateTime(new Date());
		return atCstImyMapper.update(atCstImy)>0?0:1;
	}

	/**
	 * 删除客户质量赔付记录
	 * @throws Exception 
	 * 
	 * */
	@Override
	public int delAtCstImy(int id) throws Exception {
		return atCstImyMapper.delete(id)>0?0:1;
	}

	/**
	 * 查询客户质量赔付记录详情
	 * @throws Exception 
	 * 
	 * */
	@Override
	public AtCstImy queryDetailInfo(int id) throws Exception {
		return atCstImyMapper.findById(id);
	}

	/**
	 * 查询客户质量赔付记录列表(分页)
	 * @throws Exception 
	 * 
	 * */
	@Override
	public List<AtCstImy> queryListByPage(AtCstImy atCstImy, PageObject page) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		//参数
		if(!StringUtil.isEmtryStr(atCstImy.getCpCode())){//所属代账机构
			map.put("cpCode", atCstImy.getCpCode());
		}
		if(!StringUtil.isEmtryStr(atCstImy.getCnIdentifer())){//所属客户编号
			map.put("cnIdentifer", atCstImy.getCnIdentifer());
		}
		if(atCstImy.getPayType() > 0){//赔付支付方式
			map.put("payType", atCstImy.getPayType());
		}
		if(atCstImy.getImyForm() > 0){//赔付信息来源
			map.put("imyFrom", atCstImy.getImyForm());
		}
		if(atCstImy.getImyStatus() > 0){//赔付记录状态
			map.put("imyStatus", atCstImy.getImyStatus());
		}
		if(!StringUtil.isEmtryStr(atCstImy.getOperator())){//操作员
			map.put("operator", atCstImy.getOperator() );
		}
		if(!StringUtil.isEmtryStr(atCstImy.getRemark())){//备注
			map.put("remark", atCstImy.getRemark());
		}
		// 数据总量查询
		page.setSumCloum(atCstImyMapper.findByCount(map));
		map.put("page", page);
		//返回分页结果
		return atCstImyMapper.findByPage(map);
	}

	/**
	 * 修改质量赔付状态
	 * @return
	 * @throws Exception 
	 */
	@Override
	public int changeImyStatus(AtCstImy atCstImy) throws Exception {
		//修改投诉记录信息
		this.modAtCstImy(atCstImy);
		//返回修改后的状态
		return atCstImy.getImyStatus();
	}
	
	/**
	 * 查询所有数据
	 * @return
	 */
	@Override
	public List<AtCstImy> findAll() throws Exception {
		return atCstImyMapper.findAll();
	}

	/**
	 * 批量删除
	 * @return
	 * @throws Exception 
	 */
	@Override
	public int batchDeleteAtCstImy(int[] ids) throws Exception {
		return atCstImyMapper.batchDeleteAtCstImy(ids)>0?0:1;
	}

}
