package com.gill.notes;

import java.util.Comparator;

public class NoteComparerTypeText implements Comparator<Note> {

	@Override
	public int compare(Note e1, Note e2) {
		String a = e1.getNoteType() + e1.getNoteText();
		String b = e2.getNoteType() + e2.getNoteText();
		if (a.compareTo(b) > 0) {
			return 1;
		}
		else {
			return -1;
		}
	}
}
