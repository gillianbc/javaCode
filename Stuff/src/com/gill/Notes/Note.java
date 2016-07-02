package com.gill.Notes;

public class Note {

		private String noteType;
		private String noteText;
		private int sequence;

		public Note(String n, String s, int sequence) {
			this.noteType = n;
			this.noteText = s;
			this.sequence = sequence;
		}

		public Note() {
			// TODO Auto-generated constructor stub
		}

		public String getNoteType() {
			return noteType;
		}

		public void setNoteType(String name) {
			this.noteType = name;
		}

		public String getNoteText() {
			return noteText;
		}

		public void setNoteText(String noteText) {
			this.noteText = noteText;
		}

		public String toString() {
			return "Type: " + this.noteType 
					+ " Seq: " + this.sequence
					+ " Text: " + this.noteText 
					;
		}

		public int getSequence() {
			return sequence;
		}

		public void setSequence(int sequence) {
			this.sequence = sequence;
		}
		
		

		
}
