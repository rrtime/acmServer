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

import com.rrtimes.acm.domain.AtComplain;
import com.rrtimes.acm.domain.PageObject;
import com.rrtimes.acm.persistence.AtComplainMapper;
import com.rrtimes.acm.serviceI.AtComplainService;
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
	
	/**
	 * 新增客户投诉信息
	 * @throws Exception 
	 * 
	 * */
	@Override
	public int addAtComplain(AtComplain atComplain) throws Exception {
		return atComplainMapper.insert(atComplain)>0?0:1;
	}

	/**
	 * 修改客户投诉信息
	 * @throws Exception 
	 * 
	 * */
	@Override
	public int modAtComplain(AtComplain atComplain) throws Exception {
		atComplain.setUpdateTime(new Date());
		return atComplainMapper.update(atComplain)>0?0:1;
	}

	/**
	 * 删除客户投诉信息
	 * @throws Exception 
	 * 
	 * */
	@Override
	public int delAtComplain(int id) throws Exception {
		return atComplainMapper.delete(id)>0?0:1;
	}

	/**
	 * 查询客户投诉信息详情
	 * @throws Exception 
	 * 
	 * */
	@Override
	public AtComplain queryDetailInfo(int id) throws Exception {
		return atComplainMapper.findById(id);
	}

	/**
	 * 查询客户投诉信息列表(分页)
	 * @throws Exception 
	 * 
	 * */
	@Override
	public List<AtComplain> queryListByPage(AtComplain atComplain, PageObject page) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		//参数
		if(!StringUtil.isEmtryStr(atComplain.getCpCode())){//所属代账机构
			map.put("cpCode", atComplain.getCpCode());
		}
		if(!StringUtil.isEmtryStr(atComplain.getCsrIdentifer())){//所属客户编号
			map.put("csrIdentifer", atComplain.getCsrIdentifer());
		}
		if(atComplain.getCnFrom() > 0){//投诉来源
			map.put("cnFrom", atComplain.getCnFrom());
		}
		if(atComplain.getCnType() > 0){//投诉方式
			map.put("cnType", atComplain.getCnType());
		}
		if(!StringUtil.isEmtryStr(atComplain.getCnTheme())){//投诉主题
			map.put("cnTheme", atComplain.getCnTheme());
		}
		if(!StringUtil.isEmtryStr(atComplain.getCnPrincipal())){//被投诉主要责任人
			map.put("cnPrincipal", atComplain.getCnPrincipal());
		}
		if(atComplain.getCnStatus() > 0){//投诉记录状态
			map.put("cnStatus", atComplain.getCnStatus());
		}
		if(!StringUtil.isEmtryStr(atComplain.getOperator())){//操作员
			map.put("operator", atComplain.getOperator() );
		}
		if(!StringUtil.isEmtryStr(atComplain.getRemark())){//备注
			map.put("remark", atComplain.getRemark());
		}
		// 数据总量查询
		page.setSumCloum(atComplainMapper.findByCount(map));
		map.put("page", page);
		//返回分页结果
		return atComplainMapper.findByPage(map);
	}

	/**
	 * 改变投诉记录状态
	 * @throws Exception 
	 */
	@Override
	public int changeCnStatus(AtComplain atComplain) throws Exception {
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

	/**
	 * 查询所有数据
	 * @return
	 */
	@Override
	public List<AtComplain> findAll() {
		return atComplainMapper.findAll();
	}

}
