/*      						
 * Copyright 2016 Beijing RRTIMES, Inc. All rights reserved.
 * 
 * History:
 * ------------------------------------------------------------------------------
 * Date    			|  		Who  			|  		What  
 * 2016-05-03		| 	    liht 			| 	create the file                       
 */

package com.rrtimes.acm.test;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rrtimes.acm.domain.AtComplain;
import com.rrtimes.acm.domain.AtCstFee;
import com.rrtimes.acm.domain.AtCstImy;
import com.rrtimes.acm.domain.AtCstVisit;
import com.rrtimes.acm.domain.AtFieldDict;
import com.rrtimes.acm.domain.AtFieldRel;
import com.rrtimes.acm.domain.AtHoldFunction;
import com.rrtimes.acm.domain.AtModelFunction;
import com.rrtimes.acm.domain.AtSysModel;
import com.rrtimes.acm.domain.PageObject;
import com.rrtimes.acm.persistence.AtComplainMapper;
import com.rrtimes.acm.persistence.AtCstFeeMapper;
import com.rrtimes.acm.persistence.AtCstImyMapper;
import com.rrtimes.acm.persistence.AtCstVisitMapper;
import com.rrtimes.acm.persistence.AtFieldDictMapper;
import com.rrtimes.acm.persistence.AtFieldRelMapper;
import com.rrtimes.acm.persistence.AtHoldFunctionMapper;
import com.rrtimes.acm.persistence.AtModelFunctionMapper;
import com.rrtimes.acm.persistence.AtSysModelMapper;




/**
 * 
 * 测试投诉工单持久化接口
 * 
 * <p>
 * 测试投诉工单持久化接口
 * </p> 
 * 
 * @author 
 * 
 */

public class TestAllMapper {

	private AtCstVisitMapper acvm;
	
	private AtCstFeeMapper acfm;
	
	private AtCstImyMapper acim;
	
	private AtComplainMapper acm;
	
	private AtSysModelMapper asmm;
	
	private AtModelFunctionMapper amfm;
	
	private AtHoldFunctionMapper ahfm;
	
	private AtFieldDictMapper afdm;
	
	private AtFieldRelMapper afrm;
	
	
	@Before
	public void setUp(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		
		//客户回访信息
		acvm = (AtCstVisitMapper)ac.getBean("atCstVisitMapper");
		
		//客户收费记录
		acfm = (AtCstFeeMapper)ac.getBean("atCstFeeMapper");
		
		//客户质量赔付记录
		acim = (AtCstImyMapper)ac.getBean("atCstImyMapper");
		
		//客户投诉信息
		acm = (AtComplainMapper)ac.getBean("atComplainMapper");
		
		//菜单附属功能字典
		asmm = (AtSysModelMapper)ac.getBean("atSysModelMapper");
		
		//功能详细操作字典
		amfm = (AtModelFunctionMapper)ac.getBean("atModelFunctionMapper");
		
		//系统功能操作权限
		ahfm = (AtHoldFunctionMapper)ac.getBean("atHoldFunctionMapper");
		
		//系统权限字段字典
		afdm = (AtFieldDictMapper)ac.getBean("atFieldDictMapper");
		
		//用户字段权限关系
		afrm = (AtFieldRelMapper)ac.getBean("atFieldRelMapper");
	}
	
	
	
//	@Test
	public void testAtCstVisitMapperTest(){
		AtCstVisit ci = new AtCstVisit();
		Map<String, Object> map = new HashMap<String, Object>();
		// 新增测试
//		ci.setCpCode("1");
//		ci.setCnIdentifer("2");
//		ci.setCnCustomer("1");
//		ci.setCnType(1);
//		ci.setCnContact("32423");
//		try {
//			ci.setCnTime(new Date());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		ci.setCnContent("测试");
//		ci.setCnResult(1);
//		ci.setOperator("yan");
//		ci.setRemark("客户回访");
//		int rst = 0;
//		try{
//			rst = acvm.insert(ci);
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		System.out.println("---------------- Insert ----------------:"+rst);
//		// 按照 ID 查询测试
//		ci = new AtCstVisit();
//		ci = acvm.findById(2);
//		if( ci != null )
//			System.out.println("---------------- findById ----------------:"+ci.getRemark());
//		// 查询全部测试
//		System.out.println("---------------- findAll ----------------:"+acvm.findAll().size());
//		// 修改测试
//		ci = acvm.findById(2);
//		ci.setCnType(2);
//		ci.setRemark("回访修改");
//		try {
//			ci.setUpdateTime(new Date());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		rst = acvm.update(ci);
//		System.out.println("---------------- update ----------------:"+rst);
//		ci = acvm.findById(2);
//		if( ci != null )
//			System.out.println("---------------- Update Time ----------------:"+ci.getRemark());
//		// 删除测试
//		rst = acvm.delete(2);
//		System.out.println("---------------- delete ----------------:"+rst);
		// 统计测试
		PageObject page = new PageObject();
		map.put("page", page);
		map.put("cpCode", "1");
		map.put("cnIdentifer", "1");
		map.put("cnCustomer", "%12%");
		map.put("cnType", 1);
		map.put("cnResult", 1);
		map.put("operator", "yan");
		System.out.println("---------------- findByCount ----------------:"+acvm.findByCount(map));
		//分页查询测试
		page = new PageObject();
		map.put("page", page);
		map.put("cpCode", "1");
		map.put("cnIdentifer", "1");
		map.put("cnCustomer", "%1231%");
		map.put("cnType", 1);
		map.put("cnResult", 1);
		map.put("operator", "yan");
		List<AtCstVisit> custList = acvm.findByPage(map);
		System.out.println("---------------- AtCstVisit size ----------------:"+custList.size());
	}
	
//	@Test
	public void testAtComplainMapperTest(){
		AtComplain ci = new AtComplain();
		Map<String, Object> map = new HashMap<String, Object>();
		int rst = 0;
		// 新增测试
//		ci.setCpCode("1");
//		ci.setCsrIdentifer("1");
//		ci.setCnFrom(1);
//		ci.setCnType(1);
//		ci.setCnTheme("1");
//		ci.setCnContent("1");
//		ci.setCnOpt("y");
//		ci.setCnInquire("1");
//		ci.setCnResult("1");
//		ci.setCnPrincipal("yan");
//		ci.setCnStatus(3);
//		ci.setOperator("yan");
//		ci.setRemark("客户投诉");
//		try{
//			rst = acm.insert(ci);
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		System.out.println("---------------- Insert ----------------:"+rst);
//		// 按照 ID 查询测试
//		ci = new AtComplain();
//		ci = acm.findById(1);
//		if( ci != null )
//			System.out.println("---------------- findById ----------------:"+ci.getRemark());
//		// 查询全部测试
//		System.out.println("---------------- findAll ----------------:"+acm.findAll().size());
		// 修改测试
//		ci = acm.findById(1);
//		ci.setRemark("投诉修改");
//		try {
//			ci.setUpdateTime(new Date());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		try{
//			rst = acm.update(ci);
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		System.out.println("---------------- update ----------------:"+rst);
//		ci = acm.findById(1);
//		if( ci != null )
//			System.out.println("---------------- Update Time ----------------:"+ci.getRemark());
//		// 删除测试
//		rst = acm.delete(2);
//		System.out.println("---------------- delete ----------------:"+rst);
		// 统计测试
		PageObject page = new PageObject();
		map.put("page", page);
		map.put("cpCode", "1");
		map.put("csnIdentifer", "1");
		map.put("cnFrom", "1");
		map.put("cnType", 1);
		map.put("cnTheme", "%123%");
		map.put("cnPrincipal", "yan");
		map.put("operator", "yan");
		map.put("status", 3);
		map.put("remark", "%投诉修改1%");
		System.out.println("---------------- findByCount ----------------:"+acm.findByCount(map));
		//分页查询测试
		page = new PageObject();
		map.put("page", page);
		map.put("cpCode", "1");
		map.put("csnIdentifer", "1");
		map.put("cnFrom", "1");
		map.put("cnType", 1);
		map.put("cnTheme", "%123%");
		map.put("cnPrincipal", "yan");
		map.put("operator", "yan");
		map.put("status", "1");
		map.put("remark", "%投诉修改%");
		List<AtComplain> custList = acm.findByPage(map);
		System.out.println("---------------- AtComplain size ----------------:"+custList.size());
	}
	
//	@Test
	public void testAtCstImyMapperTest(){
		AtCstImy ci = new AtCstImy();
		Map<String, Object> map = new HashMap<String, Object>();
		// 新增测试
//		ci.setCpCode("1");
//		ci.setCnIdentifer("2");
//		ci.setImyForm(1);
//		ci.setCid(1);
//		ci.setImyStatus(1);
//		ci.setImyOpt("y");
//		ci.setImyReason("质量问题");
//		ci.setImyAuditRst("aaa");
//		ci.setImyResult("bbb");
//		ci.setImySum(213.03);
//		ci.setPayType(1);
//		ci.setPayTime(new Date());
//		ci.setOperator("yan");
//		ci.setRemark("质量赔付");
//		int rst = 0;
//		try{
//			rst = acim.insert(ci);
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		System.out.println("---------------- Insert ----------------:"+rst);
//		// 按照 ID 查询测试
//		ci = new AtCstImy();
//		ci = acim.findById(3);
//		if( ci != null )
//			System.out.println("---------------- findById ----------------:"+ci.getRemark());
//		// 查询全部测试
//		System.out.println("---------------- findAll ----------------:"+acim.findAll().size());
		
		// 修改测试
//		ci = acim.findById(3);
//		ci.setRemark("质量赔付修改");
//		try {
//			ci.setUpdateTime(new Date());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		int rst = acim.update(ci);
//		System.out.println("---------------- update ----------------:"+rst);
//		ci = acim.findById(3);
//		if( ci != null )
//			System.out.println("---------------- Update Time ----------------:"+ci.getRemark());
//		// 统计测试
		PageObject page = new PageObject();
		map.put("page", page);
		map.put("cpCode", "1");
		map.put("cnIdentifer", "2");
		map.put("imyForm", 1);
		map.put("cid", 1);
		map.put("imyStatus", 1);
		map.put("payType", 1);
		map.put("operator", "yan1");
		map.put("remark", "%质量赔付修改%");
		System.out.println("---------------- findByCount ----------------:"+acim.findByCount(map));
		//分页查询测试
		page = new PageObject();
		map.put("page", page);
		map.put("cpCode", "1");
		map.put("cnIdentifer", "2");
		map.put("imyForm", 1);
		map.put("cid", 1);
		map.put("imyStatus", 1);
		map.put("payType", 1);
		map.put("operator", "yan");
		map.put("remark", "%质量赔付修改%");
		List<AtCstImy> custList = acim.findByPage(map);
		System.out.println("---------------- AtCstVisit size ----------------:"+custList.get(0).getRemark());
//		// 删除测试
//		rst = acim.delete(3);
//		System.out.println("---------------- delete ----------------:"+rst);
	}
	
//	@Test
	public void testAtCstFeeMapperTest(){
		AtCstFee ci = new AtCstFee();
		Map<String, Object> map = new HashMap<String, Object>();
		// 新增测试
//		ci.setCid(1);
//		ci.setNid(1);
//		ci.setPayType(1);
//		ci.setFeeSum(100.00);
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		String date = sdf.format(new Date());
//		try {
//			ci.setStartTime(new Date());
//			ci.setEndTime(new Date());
//			ci.setFeeTime(new Date());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		ci.setOperator("yan");
//		ci.setRemark("客户收费记录");
//		int rst = 0;
//		try{
//			rst = acfm.insert(ci);
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		System.out.println("---------------- Insert ----------------:"+rst);
//		// 按照 ID 查询测试
//		ci = new AtCstFee();
//		ci = acfm.findById(1);
//		if( ci != null )
//			System.out.println("---------------- findById ----------------:"+ci.getRemark());
//		// 查询全部测试
//		System.out.println("---------------- findAll ----------------:"+acfm.findAll().size());
//		// 修改测试
//		ci = acfm.findById(1);
//		ci.setPayType(1);
//		ci.setRemark("收费修改");
//		String dateU = sdf.format(new Date());
//		try {
//			ci.setUpdateTime(sdf.parse(dateU));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		rst = acfm.update(ci);
//		System.out.println("---------------- update ----------------:"+rst);
//		ci = acfm.findById(1);
//		if( ci != null )
//			System.out.println("---------------- Update Time ----------------:"+ci.getRemark());
//		// 删除测试
//		rst = acfm.delete(1);
//		System.out.println("---------------- delete ----------------:"+rst);
		// 统计测试
		PageObject page = new PageObject();
		map.put("page", page);
		map.put("nid", 1);
		map.put("cid", 1);
		map.put("payType", 1);
		map.put("operator", "yan");
		map.put("remark", "%eee%");
		System.out.println("---------------- findByCount ----------------:"+acfm.findByCount(map));
//		分页查询测试
		page = new PageObject();
		map.put("page", page);
		map.put("nid", 2);
		map.put("cid", 2);
		map.put("payType", 2);
		map.put("operator", "y");
		map.put("remark", "%ere%");
		List<AtCstFee> atCstList = acfm.findByPage(map);
		System.out.println("---------------- AtCstFee size ----------------:"+atCstList.size());
//		//统计提醒测试
//		int days = 20;
//		String operator = "yan";
//		Calendar cal = Calendar.getInstance();
//		Date dated = new Date();
//		cal.setTime(dated);
//		cal.add(Calendar.DATE, days);
//		System.out.println(sdf.format(cal.getTime()));
//		String dateTime = sdf.format(cal.getTime());
//		Map<String,Object> paramMap = new HashMap<String,Object>();
//		paramMap.put("dateTime", dateTime);
//		paramMap.put("operator", operator);
//		try{
//			int result = acfm.getRemindFeeCount(paramMap);
//			System.out.println("---------------- countRemind ----------------:"+result);
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		//提醒列表测试
//		cal = Calendar.getInstance();
//		cal.setTime(dated);
//		cal.add(Calendar.DATE, days);
//		System.out.println(sdf.format(cal.getTime()));
//		String dateTime1 = sdf.format(cal.getTime());
//		paramMap.put("dateTime", dateTime1);
//		paramMap.put("operator", operator);
//		try{
//			List<AtCstFee> resultList = acfm.getRemindFeeList(paramMap);
//			System.out.println("---------------- List<AtCstFee> ----------------:"+resultList.size());
//		}catch(Exception e){
//			e.printStackTrace();
//		}
	}
	
//	@Test
	public void testAtSysModelMapperTest(){
		AtSysModel ci = new AtSysModel();
		Map<String, Object> map = new HashMap<String, Object>();
		int rst = 0;
		// 新增测试
//		ci.setTreeId(1);
//		ci.setMenuCode("1");
//		ci.setmName("1");
//		ci.setmDesc("1");
//		ci.setIsSystem(1);
//		ci.setCategory(1);
//		ci.setIsConShownum(1);
//		ci.setControlNum(1);
//		ci.setControlPage("1");
//		ci.setShowIndex(1);
//		ci.setRemark("1");
//		try{
//			rst = asmm.insert(ci);
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		System.out.println("---------------- Insert ----------------:"+rst);
//		// 按照 ID 查询测试
//		ci = new AtSysModel();
//		ci = asmm.findById(1);
//		if( ci != null )
//			System.out.println("---------------- findById ----------------:"+ci.getRemark());
//		// 查询全部测试
//		System.out.println("---------------- findAll ----------------:"+asmm.findAll().size());
		// 修改测试
//		ci = asmm.findById(2);
//		ci.setRemark("字典测试修改");
//		ci.setUpdateTime(new Date());
//		rst = asmm.update(ci);
//		System.out.println("---------------- update ----------------:"+rst);
//		ci = asmm.findById(2);
//		if( ci != null )
//			System.out.println("---------------- Update Time ----------------:"+ci.getRemark());
		// 删除测试
//		rst = asmm.delete(2);
//		System.out.println("---------------- delete ----------------:"+rst);
		// 统计测试
		PageObject page = new PageObject();
		map.put("page", page);
		map.put("treeId", 1);
		map.put("menuCode", "1");
		map.put("mName", "%1%");
		map.put("isConShownum", 1);
		map.put("remark", "%1%");
		System.out.println("---------------- findByCount ----------------:"+asmm.findByCount(map));
//		分页查询测试
		page = new PageObject();
		map.put("page", page);
		map.put("treeId", 1);
		map.put("menuCode", "1");
		map.put("mName", "%1%");
		map.put("isConShownum", 1);
		map.put("remark", "%2%");
		List<AtSysModel> atSysModelList = asmm.findByPage(map);
		System.out.println("---------------- AtSysModel size ----------------:"+atSysModelList.size());
		//根据菜单树ID查询菜单附属功能
		List<AtSysModel> modelList = asmm.getAtSysModelByTreeId(1);
		System.out.println("---------------- AtSysModel size ----------------:"+modelList.size());
		
	}
	
//	@Test
	public void testAtModelFunctionMapperTest(){
		AtModelFunction ci = new AtModelFunction();
		Map<String, Object> map = new HashMap<String, Object>();
		int rst = 0;
		// 新增测试
//		ci.setMenuCode("1");
//		ci.setfName("1");
//		ci.setfTitle("1");
//		ci.setTableIndex(1);
//		ci.setIsSystem(1);
//		ci.setFunCode("1");
//		ci.setFunDesc("1");
//		ci.setIdParent(1);
//		ci.setControlId(1);
//		ci.setControlType(1);
//		ci.setIsHastag(1);
//		ci.setCategory(1);
//		ci.setShowIndex(1);
//		ci.setIsConShownum(1);
//		ci.setControlNum(1);
//		ci.setControlPage("1");
//		ci.setOperator("y");
//		ci.setRemark("1");
//		try{
//			rst = amfm.insert(ci);
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		System.out.println("---------------- Insert ----------------:"+rst);
//		// 按照 ID 查询测试
//		ci = new AtModelFunction();
//		try{
//			ci = amfm.findById(1);
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		if( ci != null )
//			System.out.println("---------------- findById ----------------:"+ci.getRemark());
//		// 查询全部测试
//		System.out.println("---------------- findAll ----------------:"+asmm.findAll().size());
//		 修改测试
//		ci = amfm.findById(1);
//		ci.setRemark("2");
//		ci.setUpdateTime(new Date());
//		try{
//			rst = amfm.update(ci);
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		System.out.println("---------------- update ----------------:"+rst);
//		ci = amfm.findById(1);
//		if( ci != null )
//			System.out.println("---------------- Update Time ----------------:"+ci.getRemark());
		// 统计测试
//		PageObject page = new PageObject();
//		map.put("page", page);
//		map.put("menuCode", "1");
//		map.put("fName", "%1%");
//		map.put("controlType", 1);
//		map.put("isHastag", 1);
//		map.put("isConShownum", 1);
//		map.put("operator", "y");
//		map.put("isConShownum", 1);
//		map.put("remark", "%2%");
//		System.out.println("---------------- findByCount ----------------:"+amfm.findByCount(map));
////		分页查询测试
//		page = new PageObject();
//		map.put("page", page);
//		map.put("menuCode", "1");
//		map.put("fName", "%2%");
//		map.put("controlType", 1);
//		map.put("isHastag", 1);
//		map.put("operator", "y");
//		map.put("isConShownum", 1);
//		map.put("remark", "%2%");
//		List<AtModelFunction> atModelFunctionList = amfm.findByPage(map);
//		System.out.println("----------- AtModelFunction size ---------:"+atModelFunctionList.size());
//		 删除测试
//		rst = amfm.delete(1);
//		System.out.println("---------------- delete ----------------:"+rst);
		//
//		List<AtModelFunction> atModelFunctionList2 = amfm.findModelFunctionByMenuCode("1");
//		System.out.println("----------- AtModelFunction size ---------:"+atModelFunctionList2.size());
		//
		try{
			List<Map<String,Object>> list = amfm.findModelFunctionByTreeId(1);
			System.out.println("----------- AtModelFunction size ---------:"+list.size());
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void testAtHoldFunctionMapperTest(){
		AtHoldFunction ci = new AtHoldFunction();
		Map<String, Object> map = new HashMap<String, Object>();
		int rst = 0;
		// 新增测试
//		ci.setMenuCode("1");
//		ci.setFunName("1");
//		ci.setIsUserGroup(1);
//		ci.setFunId(1);
//		ci.setActorId(1);
//		ci.setOperator("y");
//		ci.setRemark("1");
//		try{
//			rst = ahfm.insert(ci);
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		System.out.println("---------------- Insert ----------------:"+rst);
//		// 按照 ID 查询测试
//		ci = new AtHoldFunction();
//		try{
//			ci = ahfm.findById(1);
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		if( ci != null )
//			System.out.println("---------------- findById ----------------:"+ci.getRemark());
//		// 查询全部测试
//		System.out.println("---------------- findAll ----------------:"+asmm.findAll().size());
////		 修改测试
//		ci = ahfm.findById(1);
//		ci.setRemark("2");
//		ci.setUpdateTime(new Date());
//		try{
//			rst = ahfm.update(ci);
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		System.out.println("---------------- update ----------------:"+rst);
//		ci = ahfm.findById(1);
//		if( ci != null )
//			System.out.println("---------------- Update Time ----------------:"+ci.getRemark());
		// 统计测试
//		PageObject page = new PageObject();
//		map.put("page", page);
//		map.put("menuCode", "1");
//		map.put("funName", "%1%");
//		map.put("funId", 1);
//		map.put("actorId", 1);
//		map.put("operator", "y");
//		map.put("remark", "%1%");
//		System.out.println("---------------- findByCount ----------------:"+ahfm.findByCount(map));
////		分页查询测试
//		page = new PageObject();
//		map.put("page", page);
//		map.put("menuCode", "1");
//		map.put("funName", "%1%");
//		map.put("funId", 1);
//		map.put("actorId", 1);
//		map.put("operator", "y");
//		map.put("remark", "%2%");
//		List<AtHoldFunction> atModelFunctionList = ahfm.findByPage(map);
//		System.out.println("----------- AtModelFunction size ---------:"+atModelFunctionList.size());
//		 删除测试
//		rst = ahfm.delete(1);
//		System.out.println("---------------- delete ----------------:"+rst);
//		List<AtHoldFunction> atModelFunctionList = ahfm.findHoldFunctionByMenuCode("1");
//		System.out.println("---------------- atModelFunctionList ----------------:"+atModelFunctionList.size());
//		List<AtHoldFunction> atModelFunctionList1 = ahfm.findHoldFunctionByFunId(1);
//		System.out.println("---------------- atModelFunctionList ----------------:"+atModelFunctionList1.size());
//		List<AtModelFunction> atModelFunctionList2 = ahfm.findModelFunctionByActorId("1");
//		System.out.println("---------------- atModelFunctionList ----------------:"+atModelFunctionList2.size());
//		List<AtSysModel> atModelFunctionList3 = ahfm.findAtSysModelByActorId("1");
//		System.out.println("---------------- atModelFunctionList ----------------:"+atModelFunctionList3.size());
//		Map<String,Object> map1 = new HashMap<String,Object>();
//		map1.put("actorId", 1);
//		map1.put("menuCode", "1");
//		List<AtHoldFunction> atModelFunctionList4 = ahfm.findHoldFunctionByActorIdAndMenuCode(map1);
//		System.out.println("---------------- atModelFunctionList ----------------:"+atModelFunctionList4.size());
//		List<AtSysMenu> atModelFunctionList5 = ahfm.findAtSysMenuByActorId(1);
//		System.out.println("---------------- atModelFunctionList ----------------:"+atModelFunctionList5.size());
//		Map<String,Object> mapT = new HashMap<String,Object>();
//		mapT.put("actorId", 1);
//		mapT.put("treeId", 1);
//		List<Map<String,Object>> list = ahfm.getModelFunctionByActorIdAndTreeId(mapT);
//		System.out.print(list.size());
		try{
			Map<String,Object> map1 = new HashMap<String,Object>();
			map1.put("actorId", 1);
			map1.put("treeId", 1);
			int i = ahfm.delHoldFunctionByActorIdAndTreeId(map1);
			System.out.print(i);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
//	@Test
	public void testAtFieldDictMapperTest(){
		AtFieldDict ci = new AtFieldDict();
		Map<String, Object> map = new HashMap<String, Object>();
		int rst = 0;
		// 新增测试
//		ci.setMenuCode("1");
//		ci.setfName("1");
//		ci.setfTitle("1");
//		ci.setOrderIndex(1);
//		ci.setIsSystem(1);
//		ci.setIsInauth(1);
//		ci.setIsHasread(1);
//		ci.setIsHasupdate(0);
//		ci.setViewType(1);
//		ci.setCateGory(1);
//		ci.setIdParent(1);
//		ci.setfDesc("1");
//		ci.setRemark("测试");
//		try{
//			rst = afdm.insert(ci);
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		System.out.println("---------------- Insert ----------------:"+rst);
		// 按照 ID 查询测试
//		ci = new AtFieldDict();
//		try{
//			ci = afdm.findById(2);
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		if( ci != null )
//			System.out.println("---------------- findById ----------------:"+ci.getRemark());
//		// 查询全部测试
//		System.out.println("---------------- findAll ----------------:"+afdm.findAll().size());
////		 修改测试
//		ci = afdm.findById(2);
//		ci.setIsHasupdate(1);
//		ci.setRemark("测试修改");
//		ci.setUpdateTime(new Date());
//		try{
//			rst = afdm.update(ci);
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		System.out.println("---------------- update ----------------:"+rst);
//		ci = afdm.findById(2);
//		if( ci != null )
//			System.out.println("---------------- Update Time ----------------:"+ci.getRemark());
		// 统计测试
//		PageObject page = new PageObject();
//		map.put("page", page);
//		map.put("menuCode", "1");
//		map.put("fName", "%1%");
//		map.put("fTitle", "%1%");
//		map.put("remark", "%测试%");
//		System.out.println("---------------- findByCount ----------------:"+afdm.findByCount(map));
////		分页查询测试
//		page = new PageObject();
//		map.put("page", page);
//		map.put("menuCode", "1");
//		map.put("fName", "%1%");
//		map.put("fTitle", "%1%");
//		map.put("remark", "%测试修改%");
//		try{
//			List<AtFieldDict> atFieldDictList = afdm.findByPage(map);
//			System.out.println("----------- AtFieldDict size ---------:"+atFieldDictList.size());
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		 删除测试
//		rst = ahfm.delete(1);
//		System.out.println("---------------- delete ----------------:"+rst);
		List<Map<String,Object>> list = afdm.findAtFieldDictByTreeId(1);
		System.out.print(list.size());
	}
	
//	@Test
	public void testAtFieldRelMapperTest(){
		AtFieldRel ci = new AtFieldRel();
		Map<String, Object> map = new HashMap<String, Object>();
		int rst = 0;
		// 新增测试
//		ci.setMenuCode("1");
//		ci.setrName("1");
//		ci.setPrivilegeType(1);
//		ci.setFid(1);
//		ci.setUid(1);
//		ci.setIsUserGroup(1);
//		ci.setOperator("yan");
//		ci.setRemark("测试yh");
//		try{
//			rst = afrm.insert(ci);
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		System.out.println("---------------- Insert ----------------:"+rst);
//		 按照 ID 查询测试
//		ci = new AtFieldRel();
//		try{
//			ci = afrm.findById(3);
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		if( ci != null )
//			System.out.println("---------------- findById ----------------:"+ci.getRemark());
//		// 查询全部测试
//		System.out.println("---------------- findAll ----------------:"+afrm.findAll().size());
////		 修改测试
//		ci = afrm.findById(3);
//		ci.setRemark("测试yh修改");
//		ci.setUpdateTime(new Date());
//		try{
//			rst = afrm.update(ci);
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		System.out.println("---------------- update ----------------:"+rst);
//		ci = afrm.findById(3);
//		if( ci != null )
//			System.out.println("---------------- Update Time ----------------:"+ci.getRemark());
//		PageObject page = new PageObject();
//		// 统计测试
//		map.put("page", page);
//		map.put("menuCode", "1");
//		map.put("rName", "%1%");
//		map.put("privilegeType", 1);
//		map.put("fid", 1);
//		map.put("uid", 1);
//		map.put("remark", "%测试yh%");
//		System.out.println("---------------- findByCount ----------------:"+afrm.findByCount(map));
//		分页查询测试
//		page = new PageObject();
//		map.put("page", page);
//		map.put("menuCode", "1");
//		map.put("rName", "%1%");
//		map.put("privilegeType", 1);
//		map.put("fid", 1);
//		map.put("uid", 1);
//		map.put("remark", "%测试yh修改%");
//		try{
//			List<AtFieldRel> atFieldRelList = afrm.findByPage(map);
//			System.out.println("----------- AtFieldRel size ---------:"+atFieldRelList.size());
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		 删除测试
		try{
			Map<String,Object> map1 = new HashMap<String,Object>();
			map1.put("uid", 1);
			map1.put("treeId", 1);
			rst = afrm.delAtFieldRelByUidAndTreeId(map1);
			System.out.println("---------------- delete ----------------:"+rst);
		}catch(Exception e){
			e.printStackTrace();
		}
//		try{
//			Map<String,Object> mapT = new HashMap<String,Object>();
//			mapT.put("uid", 1);
//			mapT.put("treeId", 1);
//			List<Map<String,Object>> list = afrm.findAtFieldRelByUidAndTreeId(mapT);
//			System.out.print(list.size());
//		}catch(Exception e){
//			e.printStackTrace();
//		}
	}
	
}
