package com.fireway.utils;

public class ContantsUtil {
	
	public static final String USER = "user";
		
	 
	public static final String[] userPropertys = new String[]{"userNum","name","sex","age","birth","address","idCard",
			"mobile","homeTel","email","joinDate","status","password2","remark"};
	public static final String[] userColumnNames = new String[]{"工号","姓名","性别","年龄","出生日期","居住地址","身份证","手机号码",
			"家庭电话","电子邮箱","入职日期","账号状态","原密码","备注"};
	
	public static final String[] teacherPropertys = new String[]{"teacherNum","name","sex","age","birth","nativePlace","idCard",
			"academyName","academicDegree","mobile","homeTel","email",
			"joinDate","status","password2","remark"};
	public static final String[] teacherColumnNames = new String[]{"工号","姓名","性别","年龄","出生日期","籍贯","身份证",
			"任职学院","学历","手机号码",
			"家庭电话","电子邮箱","入职日期","账号状态","原密码","备注"};
	
	public static final String[] studentPropertys = new String[]{"studentNum","name","sex","age","birth","nativePlace","idCard",
			"academyName","grade","className","mobile","homeTel","email",
			"admissionDate","status","password2","remark"};
	public static final String[] studentColumnNames = new String[]{"学号","姓名","性别","年龄","出生日期","籍贯","身份证",
			"学院","年级","班别","手机号码",
			"家庭电话","电子邮箱","入学日期","账号状态","原密码","备注"};
	
	public static final String[] academyPropertys = new String[]{"code","name","head","headMobile","officAddress",
			"officTel","status","remark"};
	public static final String[] academyColumnNames = new String[]{"学院代码","名称","负责人","负责人手机","办公地址","办公电话",
			"状态","备注"};
	
	public static final String[] dictionaryPropertys = new String[]{"type","name","value","isEdit","status","remark"};
	public static final String[] dictionaryColumnNames = new String[]{"字典类型","字典名","字典值","是否可编辑","状态","备注"
			};

}
