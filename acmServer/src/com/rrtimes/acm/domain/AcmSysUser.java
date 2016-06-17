package com.rrtimes.acm.domain;

import java.sql.Timestamp;
import java.util.Date;

public class AcmSysUser {
     private int Id;                     //主键ID
     private String LoginName;           //登录账号
     private String LoginPwd;            //登录密码
     private String UserName;            //用户姓名
     private int Sex;                    //性别
     private String WorkerNo;            //员工编号
     private int Oid;                    //所属部门
     private int Rid;                    //系统角色
     private int IsDiyrule;              //是否自定义权限
     private int IsFiledRule;            //是否控制字段权限
     private String JobDuty;             //岗位职务
     private String Telno;               //手机号码
     private String Email;               //电子邮箱
     private Date Birthday;              //出生日期
     private int IsMarry;                //婚姻状况
     private String University;          //毕业院校
     private String Specialty;           //专业
     private String Education;           //学历
     private String JobTitles;           //专业职称及资格
     private Date WorkTime;              //参加工作时间
     private Date InTime;                //入职时间
     private int Status;                 //用户状态
     private String LoginIp;             //用户登录IP
     private String LoginTime;           //用户登录时段
     private Timestamp CreateTime;       //创建时间
     private Date UpdateTime;            //修改时间
     private String Remark;              //备注
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getLoginName() {
		return LoginName;
	}
	public void setLoginName(String loginName) {
		LoginName = loginName;
	}
	public String getLoginPwd() {
		return LoginPwd;
	}
	public void setLoginPwd(String loginPwd) {
		LoginPwd = loginPwd;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public int getSex() {
		return Sex;
	}
	public void setSex(int sex) {
		Sex = sex;
	}
	public String getWorkerNo() {
		return WorkerNo;
	}
	public void setWorkerNo(String workerNo) {
		WorkerNo = workerNo;
	}
	public int getOid() {
		return Oid;
	}
	public void setOid(int oid) {
		Oid = oid;
	}
	public int getRid() {
		return Rid;
	}
	public void setRid(int rid) {
		Rid = rid;
	}
	public int getIsDiyrule() {
		return IsDiyrule;
	}
	public void setIsDiyrule(int isDiyrule) {
		IsDiyrule = isDiyrule;
	}
	public int getIsFiledRule() {
		return IsFiledRule;
	}
	public void setIsFiledRule(int isFiledRule) {
		IsFiledRule = isFiledRule;
	}
	public String getJobDuty() {
		return JobDuty;
	}
	public void setJobDuty(String jobDuty) {
		JobDuty = jobDuty;
	}
	public String getTelno() {
		return Telno;
	}
	public void setTelno(String telno) {
		Telno = telno;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public Date getBirthday() {
		return Birthday;
	}
	public void setBirthday(Date birthday) {
		Birthday = birthday;
	}
	public int getIsMarry() {
		return IsMarry;
	}
	public void setIsMarry(int isMarry) {
		IsMarry = isMarry;
	}
	public String getUniversity() {
		return University;
	}
	public void setUniversity(String university) {
		University = university;
	}
	public String getSpecialty() {
		return Specialty;
	}
	public void setSpecialty(String specialty) {
		Specialty = specialty;
	}
	public String getEducation() {
		return Education;
	}
	public void setEducation(String education) {
		Education = education;
	}
	public String getJobTitles() {
		return JobTitles;
	}
	public void setJobTitles(String jobTitles) {
		JobTitles = jobTitles;
	}
	public Date getWorkTime() {
		return WorkTime;
	}
	public void setWorkTime(Date workTime) {
		WorkTime = workTime;
	}
	public Date getInTime() {
		return InTime;
	}
	public void setInTime(Date inTime) {
		InTime = inTime;
	}
	public int getStatus() {
		return Status;
	}
	public void setStatus(int status) {
		Status = status;
	}
	public String getLoginIp() {
		return LoginIp;
	}
	public void setLoginIp(String loginIp) {
		LoginIp = loginIp;
	}
	public String getLoginTime() {
		return LoginTime;
	}
	public void setLoginTime(String loginTime) {
		LoginTime = loginTime;
	}
	public Timestamp getCreateTime() {
		return CreateTime;
	}
	public void setCreateTime(Timestamp createTime) {
		CreateTime = createTime;
	}
	public Date getUpdateTime() {
		return UpdateTime;
	}
	public void setUpdateTime(Date updateTime) {
		UpdateTime = updateTime;
	}
	public String getRemark() {
		return Remark;
	}
	public void setRemark(String remark) {
		Remark = remark;
	}
} 
 