package com.helpApp;

public class Node {
	private String longText;
	private String nameText;
	private String speakText;
	private String imageName;
	private boolean isDir;
	
	public boolean isDir() {
		return isDir;
	}
	public void setDir(boolean isDir) {
		this.isDir = isDir;
	}
	public String getNameText() {
		return nameText;
	}
	public void setNameText(String nameText) {
		this.nameText = nameText;
	}
	public String getLongText() {
		return longText;
	}
	public void setLongText(String longText) {
		this.longText = longText;
	}
	public String getSpeakText() {
		return speakText;
	}
	public void setSpeakText(String speakText) {
		this.speakText = speakText;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}



}
