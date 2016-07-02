package com.gill.Notes;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Example of using a TreeSet which is sorted in the order defined in my
 * Comparator
 * 
 * The Notelette class that I am sorting has 2 string fields; a notetype and
 * some note text. It also has an integer field called sequence.
 * <p>
 * I want them sorted by notetype first then notetext. I merge the texts of 2
 * notes if the notetype is the same
 * </p>
 * 
 * I can then do the same exercise to sort them by type and then sequence just
 * by using a different comparator i.e. merge notes of same note type in order
 * of sequence
 * 
 * @author gillian
 *
 */
public class tryNotes {

	public static void main(String a[]) {
		// By using name comparator (String comparison)
		//Just swap between MyComparer and MyComparer2 here to see the effects of different
		//sort order in the TreeSet
		TreeSet<Notelette> noteSet = new TreeSet<Notelette>(new MyComparer2());
		noteSet.add(new Notelette("Crish", "Z", 41));
		noteSet.add(new Notelette("Berry", "A", 23));
		noteSet.add(new Notelette("Berry", "B", 31));
		noteSet.add(new Notelette("Apple", "X", 0));
		noteSet.add(new Notelette("Dunk", "D", 1));
		noteSet.add(new Notelette("Apple", "F", 2));
		noteSet.add(new Notelette("Berry", "C", 3));
		noteSet.add(new Notelette("Crish", "X", 4));
		noteSet.add(new Notelette("Berry", "E", 5));
		noteSet.add(new Notelette("Berry", "D", 30));
		noteSet.add(new Notelette("Dunk", "A", 11));
		noteSet.add(new Notelette("Dunk", "C", 111));
		noteSet.add(new Notelette("Dunk", "B", 112));
		noteSet.add(new Notelette("Emo", "X", 113));
		// noteSet.add(new Notelette("Emo", "A", 115));

		for (Notelette e : noteSet) {
			System.out.println(e);
		}

		Set<Notelette> noteSet2 = new LinkedHashSet<>();
		Notelette n1 = null;
		Notelette n2 = null;
		StringBuffer strBuf = null;
		for (Iterator<Notelette> iterator = noteSet.iterator(); iterator.hasNext();) {
			n2 = (Notelette) iterator.next();
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
		System.out.println("===========================");
		for (Notelette e : noteSet2) {
			System.out.println(e);
		}
		System.out.println("===========================");
	}

	private static StringBuffer startNewBuffer(Notelette n1) {
		StringBuffer strBuf;
		strBuf = new StringBuffer();
		strBuf.append(n1.getNoteText());
		return strBuf;
	}
}

class MyComparer implements Comparator<Notelette> {

	@Override
	public int compare(Notelette e1, Notelette e2) {
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

class MyComparer2 implements Comparator<Notelette> {
	// compare by type, the sequence
	@Override
	public int compare(Notelette e1, Notelette e2) {
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

class Notelette {

	private String noteType;
	private String noteText;
	private int sequence;

	public Notelette(String n, String s, int sequence) {
		this.noteType = n;
		this.noteText = s;
		this.sequence = sequence;
	}

	public Notelette() {
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
		return "Type: " + this.noteType + " Text: " + this.noteText + " Seq " + this.sequence;
	}

	public int getSequence() {
		return sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}
}
