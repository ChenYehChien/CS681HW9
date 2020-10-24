package edu.umb.cs681.hw09.APFS;

import java.time.LocalDateTime;

import edu.umb.cs681.hw09.FSFoundation.FSElement;
import edu.umb.cs681.hw09.FSFoundation.FileSystem;

//design as singleton
public class APFS extends FileSystem {
	private APFS() {}
	private static APFS instance = null;
	private ApfsDirectory rootDir;
	
	public static APFS getAPFS() {
		if (instance == null)
			instance = new APFS();
		return instance;
	}
	
	//default root info
	//default root is the only root of this filesystem
	protected FSElement createDefaultRoot() {
		rootDir = new ApfsDirectory(null, "root", 0, LocalDateTime.now());
		return rootDir;
	}
	
	//need to be verified
	public ApfsDirectory getRootDir() {
		return rootDir;
	}
	
}