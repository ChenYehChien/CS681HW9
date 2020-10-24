package edu.umb.cs681.hw09.APFS;

public class ApfsCountingVisitor implements ApfsFSVisitor {
	private int dirNum  = 0;
	private int fileNum = 0; 
	private int linkNum = 0;
	
	public void visit(ApfsLink link) {
		linkNum++;
	}

	
	public void visit(ApfsDirectory dir) {
		dirNum++;
	}

	
	public void visit(ApfsFile file) {
		fileNum++;
	}
	
	public int getDirNum() {
		return dirNum;
	}
	
	public int getFileNum() {
		return fileNum;
	}
	
	public int getLinkNum() {
		return linkNum;
	}
	
}