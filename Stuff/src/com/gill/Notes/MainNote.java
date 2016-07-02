package com.gill.notes;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class MainNote {
	private static TreeSet<Note> noteSet = new TreeSet<Note>(new NoteComparerTypeSeq());
	private static NoteUtils utility = new NoteUtils();
	public static void main(String[] args){
		utility.makeSampleNotesSet(noteSet);
		utility.printNoteSet(noteSet);
		Set<Note> reducedNotes = utility.reduceNotes(noteSet);
		utility.printNoteSet(reducedNotes);
		
	}
	
	
}
