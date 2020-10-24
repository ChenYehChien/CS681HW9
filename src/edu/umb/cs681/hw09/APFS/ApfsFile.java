package edu.umb.cs681.hw09.APFS;

import java.time.LocalDateTime;

public class ApfsFile extends ApfsElement {
	
	public ApfsFile (ApfsDirectory parent, String name, int size, LocalDateTime creationTime) {
		super(parent, name, size, creationTime);
	}
	
	public boolean isDirectory() {
		return false;
	}

	//hw10
	public void accept(ApfsFSVisitor v) {
		v.visit(this);
		
	}
	
}