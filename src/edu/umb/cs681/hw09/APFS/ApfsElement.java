package edu.umb.cs681.hw09.APFS;

import java.time.LocalDateTime;

import edu.umb.cs681.hw09.FSFoundation.FSElement;

public abstract class ApfsElement extends FSElement {
	
	protected ApfsDirectory parent;
	protected String ownerName;
	protected LocalDateTime lastModified;
	
	public ApfsElement(ApfsDirectory parent, String name, int size, LocalDateTime creationTime) {
		this.parent = parent;
		this.name = name;
		this.size = size;
		this.creationTime = creationTime;
	}
	
	public ApfsDirectory getParent() {
		lock.lock();
		try {
			return this.parent;
		}
		finally {
			lock.unlock();
		}
	}
	
	public void setParent(ApfsDirectory parent) {
		lock.lock();
		try {
			this.parent = parent;
		}
		finally {
			lock.unlock();
		}
	}
	
	//new added
	public String getOwnerName() {
		lock.lock();
		try {
			return this.ownerName;
		}
		finally {
			lock.unlock();
		}
	}
			
	public void setOwnerName(String ownerName) {
		lock.lock();
		try {
			this.ownerName = ownerName;
		}
		finally {
			lock.unlock();
		}
	}
			
	public LocalDateTime getLastModifiedTime() {
		lock.lock();
		try {
			return this.lastModified;
		}
		finally {
			lock.unlock();
		}
	}
			
	public void setLastModifiedTime(LocalDateTime lastModified) {
		lock.lock();
		try {
			this.lastModified = lastModified;
		}
		finally {
			lock.unlock();
		}
	}
	
	public abstract void accept(ApfsFSVisitor v);
	
	public abstract boolean isDirectory();
	
}