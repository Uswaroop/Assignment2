package com.dxc.exception;

public class NoteExistExcep extends Exception{
	String msg;

	public NoteExistExcep() {
		super();
	}

	public NoteExistExcep(String msg) {
		super(msg);
		
	}
}
