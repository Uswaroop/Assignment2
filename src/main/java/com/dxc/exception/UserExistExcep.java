package com.dxc.exception;

public class UserExistExcep extends Exception {
	String msg;

	public UserExistExcep() {
		super();
	}

	public UserExistExcep(String msg) {
		super(msg);
		
	}
}
