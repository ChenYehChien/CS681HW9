package edu.umb.cs681.hw09.FSFoundation;

import java.time.LocalDateTime;
import java.util.concurrent.locks.ReentrantLock;

public abstract class FSElement {
	protected ReentrantLock lock = new ReentrantLock();
	
	protected String name;
	protected int size;
	protected LocalDateTime creationTime;

	public String getName() {
		lock.lock();
		try {
			return this.name;
		}
		finally {
			lock.unlock();
		}
	}
	
	public void setName(String name) {
		lock.lock();
		try {
			this.name = name;
		}
		finally {
			lock.unlock();
		}
	}
	
	public int getSize() {
		lock.lock();
		try {
			return this.size;
		}
		finally {
			lock.unlock();
		}
	}
	
	public void setSize(int size) {
		lock.lock();
		try {
			this.size = size;
		}
		finally {
			lock.unlock();
		}
	}
	
	public LocalDateTime getCreationTime() {
		return this.creationTime;
	}
	
	public void setCreationTime(LocalDateTime creationTime) {
		this.creationTime = creationTime;
	}
	//abstract method
	public abstract boolean isDirectory();
	
}