package edu.umb.cs681.hw09.FSFoundation;

import java.util.LinkedList;

public abstract class FileSystem {
	protected String name;
	protected int capacity;
	protected int id;
	//private or protected
	private LinkedList<FSElement> rootDirs = new LinkedList<FSElement>();
	
	public FSElement initFileSystem(String name, int capacity) {
		this.name 	  = name;
		this.capacity = capacity;
		FSElement root = createDefaultRoot();
		if (root.isDirectory() && capacity >= root.getSize()) {
			setRoot(root);
			this.id = root.hashCode();
			return root;
		}
		else {
			return null;
			//or throw an exception
		}
	}
	
	protected abstract FSElement createDefaultRoot();
	
	protected void setRoot(FSElement root) {
		rootDirs.add(root);
	}
	
	protected int getCapacity() {
		return this.capacity;
	}
	
	protected void setName(String name) {
		this.name = name;
	}
	
	protected String getName() {
		return this.name;
	}
	
	protected void setId(int id) {
		this.id = id;
	}
	
	protected int getId() {
		return this.id;
	}
	
	
	
	
	

	
}