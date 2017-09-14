package com.fireway.test.dao;

import org.springframework.stereotype.Repository;

@Repository
public class TestDAO {

	public TestDAO() {
		
		super();
		
		
	}

	@Override
	public String toString() {
		return "TestDAO [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]"+"testDAO loading success...";
	}

	
	
}
