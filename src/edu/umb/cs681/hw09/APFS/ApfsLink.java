package edu.umb.cs681.hw09.APFS;

import java.time.LocalDateTime;
import java.util.concurrent.locks.ReentrantLock;

public class ApfsLink extends ApfsElement {
	private ReentrantLock lock = new ReentrantLock();
	private ApfsElement target;
	
	public ApfsLink (ApfsDirectory parent, String name, int size, LocalDateTime creationTime, ApfsElement target) {
		super(parent, name, size, creationTime);
		this.target = target;
	}
	
	public void setTarget(ApfsElement target) {
		lock.lock();
		try {
			this.target = target;
		}
		finally {
			lock.unlock();
		}
	}
	
	public ApfsElement getTarget() {
		lock.lock();
		try {
			return this.target;
		}
		finally {
			lock.unlock();
		}
	}
	
	public boolean isDirectory() {
		return false;
	}

	//hw10
	public void accept(ApfsFSVisitor v) {
		v.visit(this);
		
	}
	
}