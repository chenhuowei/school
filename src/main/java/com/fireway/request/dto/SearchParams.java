package com.fireway.request.dto;


public class SearchParams {
	
	
	

	private  String startBirth;
	private String endBirth;
	
		private String idCard;
	    private Boolean status;

	    /**
	     * 
	     */
	    private String num;

	    /**
	     * 
	     */
	    private String name;

	    /**
	     * 
	     */
	    private Boolean sex;

	    /**
	     * 
	     */
	    private Integer age;
	    
	    private String address;

	    /**
	     * 
	     */
	    private String mobile;

	    /**
	     * 
	     */
	   
	    private String email;

	    
	    
		public String getIdCard() {
			return idCard;
		}

		public void setIdCard(String idCard) {
			this.idCard = idCard;
		}

		public String getStartBirth() {
			return startBirth;
		}

		public void setStartBirth(String startBirth) {
			this.startBirth = startBirth;
		}

		public String getEndBirth() {
			return endBirth;
		}

		public void setEndBirth(String endBirth) {
			this.endBirth = endBirth;
		}

		public Boolean getStatus() {
			return status;
		}

		public void setStatus(Boolean status) {
			this.status = status;
		}

		public String getNum() {
			return num;
		}

		public void setNum(String num) {
			this.num = num;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Boolean getSex() {
			return sex;
		}

		public void setSex(Boolean sex) {
			this.sex = sex;
		}

		public Integer getAge() {
			return age;
		}

		public void setAge(Integer age) {
			this.age = age;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getMobile() {
			return mobile;
		}

		public void setMobile(String mobile) {
			this.mobile = mobile;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		@Override
		public String toString() {
			return "SearchParams [startBirth=" + startBirth + ", endBirth=" + endBirth + ", status=" + status + ", num="
					+ num + ", name=" + name + ", sex=" + sex + ", age=" + age + ", address=" + address + ", mobile="
					+ mobile + ", email=" + email + "]";
		}

		public boolean isNotNull(){
			if (
					sex == null && startBirth == null && status == null && endBirth == null
				    && num == null && name == null && age == null
					&& address == null && mobile == null && email == null
					
					){
				return false;
			}
			
			return true;
		}

	    

}
