package com.gill.Notes;

import java.util.Comparator;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

public class Note {
	private String noteType;
	private String noteText;
	private int sequence;

	public Note(String noteType, String noteText, int sequence) {
		this.noteType = noteType;
		this.noteText = noteText;
		this.sequence = sequence;
	}

	public int getSequence() {
		return sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

	public Note() {
		// TODO Auto-generated constructor stub
	}

	public String getNoteType() {
		return noteType;
	}

	public void setNoteType(String noteType) {
		this.noteType = noteType;
	}

	public String getNoteText() {
		return noteText;
	}

	public void setNoteText(String noteText) {
		this.noteText = noteText;
	}

	
	
}
