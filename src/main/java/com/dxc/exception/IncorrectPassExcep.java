package com.dxc.exception;

public class IncorrectPassExcep extends Exception {
	String msg;

	public IncorrectPassExcep() {
		super();
	}

	public IncorrectPassExcep(String msg) {
		super(msg);
		
	}
}
