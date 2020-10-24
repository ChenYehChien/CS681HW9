package edu.umb.cs681.hw09.APFS;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

import edu.umb.cs681.hw09.APFS.AlphabeticalComparator;


public class ApfsDirectory extends ApfsElement {
	private LinkedList<ApfsElement> children = new LinkedList<ApfsElement>();
	private int totalSize = 0;
	
	public ApfsDirectory(ApfsDirectory parent, String name, int size, LocalDateTime creationTime) {
		super(parent, name, size, creationTime);
	}
	
	public LinkedList<ApfsElement> getChildren() {
		return this.children;
	}
	
	public void appendChild(ApfsElement child) {
		this.children.add(child);
		child.setParent(this);
		//hw12
		Collections.sort(this.children, new AlphabeticalComparator());
	}
	
	public int countChildren() {
		return children.size();
	}
	
	public LinkedList<ApfsDirectory> getSubDirectories() {
		LinkedList<ApfsDirectory> directoryList = new LinkedList<ApfsDirectory>();
		
		for (ApfsElement child: children) {
			if (child.isDirectory())
				directoryList.add((ApfsDirectory) child);
		}
		
		return directoryList;
	}
	
	public LinkedList<ApfsFile> getFiles() {
		LinkedList<ApfsFile> fileList = new LinkedList<ApfsFile>();
		
		for (ApfsElement child: children) {
			if (!child.isDirectory())
				fileList.add((ApfsFile) child);
		}
		
		return fileList;
	}
	
	public int getTotalSize() {
		for (ApfsElement child: children) {
			if (child.isDirectory()) {
				//recursively call when it is a directory
				ApfsDirectory childD = (ApfsDirectory) child;
				totalSize = childD.getTotalSize();
			}
			else {
				totalSize += child.getSize();
			}
		}
		
		return totalSize;
	}
	
	public boolean isDirectory() {
		return true;
	}

	//hw10
	public void accept(ApfsFSVisitor v) {
		v.visit(this);
		for (ApfsElement e: children) {
			e.accept(v);
		}
	}
	
	//hw12
	public LinkedList<ApfsElement> getChildren(Comparator<ApfsElement> comparator) {
		LinkedList<ApfsElement> sortedChildren = this.getChildren();
		Collections.sort(sortedChildren, comparator);
		return sortedChildren;
	}
	public LinkedList<ApfsDirectory> getSubDirectories(Comparator<ApfsElement> comparator) {
		LinkedList<ApfsDirectory> sortedSubDirectory = this.getSubDirectories();
		Collections.sort(sortedSubDirectory, comparator);
		return sortedSubDirectory;
	}
	public LinkedList<ApfsFile> getFiles(Comparator<ApfsElement> comparator) {
		LinkedList<ApfsFile> sortedFiles = this.getFiles();
		Collections.sort(sortedFiles, comparator);
		return sortedFiles;
	}
		
	
	
	
	
	
}