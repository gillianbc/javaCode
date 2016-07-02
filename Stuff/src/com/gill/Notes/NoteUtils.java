package com.gill.Notes;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class NoteUtils {
	public Set<Note> reduceNotes(TreeSet<Note> setOfNotes){
		Set<Note> noteSet2 = new LinkedHashSet<>();
		Note n1 = null;
		Note n2 = null;
		StringBuffer strBuf = null;
		for (Iterator<Note> iterator = setOfNotes.iterator(); iterator.hasNext();) {
			n2 = (Note) iterator.next();
			if (n1 == null) {
				n1 = n2;
				strBuf = startNewBuffer(n1);
			}
			else
				if (n2.getNoteType() == n1.getNoteType())
					strBuf.append(n2.getNoteText());
				else {
					n1.setNoteText(strBuf.toString());
					noteSet2.add(n1);
					n1 = n2;
					strBuf = startNewBuffer(n1);
				}
		}
		n1.setNoteText(strBuf.toString());
		noteSet2.add(n1);
		return noteSet2;
	}
	private StringBuffer startNewBuffer(Note n1) {
		StringBuffer strBuf;
		strBuf = new StringBuffer();
		strBuf.append(n1.getNoteText());
		return strBuf;
	}
	public void printNoteSet(Set<Note> setOfNotes){
		for (Note n : setOfNotes) {
			System.out.println(n);
		}
		System.out.println(" ====== End of Set ======");
	}
	public void makeNoteSet(TreeSet<Note> noteSet){
		noteSet.add(new Note("Crish", "Z", 41));
		noteSet.add(new Note("Berry", "A", 23));
		noteSet.add(new Note("Berry", "B", 31));
		noteSet.add(new Note("Apple", "X", 0));
		noteSet.add(new Note("Dunk", "D", 1));
		noteSet.add(new Note("Apple", "F", 2));
		noteSet.add(new Note("Berry", "C", 3));
		noteSet.add(new Note("Crish", "X", 4));
		noteSet.add(new Note("Berry", "E", 5));
		noteSet.add(new Note("Berry", "D", 30));
		noteSet.add(new Note("Dunk", "A", 11));
		noteSet.add(new Note("Dunk", "C", 111));
		noteSet.add(new Note("Dunk", "B", 112));
		noteSet.add(new Note("Emo", "X", 113));
	}
}
