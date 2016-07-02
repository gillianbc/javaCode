package com.gill.Notes;

import java.util.Comparator;

public class NoteComparerTypeSeq implements Comparator<Note> {
	// compare by type, the sequence
	@Override
	public int compare(Note e1, Note e2) {
		String a = e1.getNoteType();
		String b = e2.getNoteType();
		int aSeq = e1.getSequence();
		int bSeq = e2.getSequence();
		if (a.equals(b)) {
			if (aSeq == bSeq)
				return 0;
			else {
				if (aSeq > bSeq)
					return 1;
				else
					return -1;
			}
		}
		else
			return a.compareTo(b);
	}
}
