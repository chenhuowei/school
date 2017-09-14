package test;

import java.util.Date;

public class TestUser {

	private String name;
	private String className;
	private Date birth;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	@Override
	public String toString() {
		return "TestUser [name=" + name + ", className=" + className + ", birth=" + birth + "]";
	}
	public TestUser() {
		super();
		
	}
	public TestUser(String name, String className, Date birth) {
		super();
		this.name = name;
		this.className = className;
		this.birth = birth;
	}
	
	
	
}
