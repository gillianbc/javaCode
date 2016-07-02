package com.gill.notes;

import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.BeforeClass;
import static org.hamcrest.CoreMatchers.*;

/*
 * See http://www.tutorialspoint.com/junit/junit_parameterized_test.htm
 */
public class NoteTest {
	private NoteUtils utility = new NoteUtils();

	private TreeSet<Note> makeSet1() {
		TreeSet<Note> noteSet = new TreeSet<Note>(new NoteComparerTypeSeq());
		noteSet.add(new Note("Cherry", "Red-", 5));
		noteSet.add(new Note("Cherry", "Blue-", 1));
		noteSet.add(new Note("Apple", "Red-", 2));
		System.out.println("Set before merging texts is: ");
		utility.printNoteSet(noteSet);
		TreeSet<Note> finalSet = new TreeSet<Note>(new NoteComparerTypeSeq());
		finalSet = utility.reduceNotes(noteSet);
		utility.printNoteSet(finalSet);
		return finalSet;
	}

	@Test
	public void checkSet1() {
		TreeSet<Note> finalSet = makeSet1();
		
		assertThat("Check there are exactly 2 notes in the result set",finalSet.stream().count(),is(2L));
		assertThat("Check just one Apple with text Red-", finalSet.stream()
			.filter(noteInStream -> noteInStream.getNoteType().equals("Apple"))
			.filter(noteInAppleStream -> noteInAppleStream.getNoteText().equals("Red-"))
			.count(),is(1L));
		assertThat("Check just one Cherry with text Blue-Red-", finalSet.stream()
			.filter(note -> note.getNoteType().equals("Cherry"))
			.filter(note -> note.getNoteText().equals("Blue-Red-"))
			.count(),is(1L));
	}
	
	private TreeSet<Note> makeSet2() {
		TreeSet<Note> noteSet = new TreeSet<Note>(new NoteComparerTypeSeq());
		noteSet.add(new Note("Apple", "Red-", 2));
		System.out.println("Set before merging texts is: ");
		utility.printNoteSet(noteSet);
		TreeSet<Note> finalSet = new TreeSet<Note>(new NoteComparerTypeSeq());
		finalSet = utility.reduceNotes(noteSet);
		utility.printNoteSet(finalSet);
		return finalSet;
	}
	
	@Test
	public void checkSet2() {
		TreeSet<Note> finalSet = makeSet2();
		
		assertThat("Check there is exactly 1 note in the result set",finalSet.stream().count(),is(1L));
		assertThat("Check just one Apple with text Red-", finalSet.stream()
			.filter(noteInStream -> noteInStream.getNoteType().equals("Apple"))
			.filter(noteInAppleStream -> noteInAppleStream.getNoteText().equals("Red-"))
			.count(),is(1L));
	}
	
	private TreeSet<Note> makeSet3() {
		TreeSet<Note> noteSet = new TreeSet<Note>(new NoteComparerTypeSeq());
		noteSet.add(new Note("Cherry", "Red-", 5));
		noteSet.add(new Note("Pear", "Grey-", 2));
		noteSet.add(new Note("Cherry", "Blue-", 1));
		noteSet.add(new Note("Apple", "Red-", 2));
		noteSet.add(new Note("Cherry", "Green-", 3));
		noteSet.add(new Note("Pear", "Orange-", 5));
		System.out.println("Set before merging texts is: ");
		utility.printNoteSet(noteSet);
		TreeSet<Note> finalSet = new TreeSet<Note>(new NoteComparerTypeSeq());
		finalSet = utility.reduceNotes(noteSet);
		utility.printNoteSet(finalSet);
		return finalSet;
	}
	
	@Test
	public void checkSet3() {
		TreeSet<Note> finalSet = makeSet3();
		
		assertThat("Check there are exactly 3 notes in the result set",finalSet.stream().count(),is(3L));
		assertThat("Check just one Apple with text Red-", finalSet.stream()
			.filter(noteInStream -> noteInStream.getNoteType().equals("Apple"))
			.filter(noteInAppleStream -> noteInAppleStream.getNoteText().equals("Red-"))
			.count(),is(1L));
		assertThat("Check just one Cherry with text Blue-Green-Red-", finalSet.stream()
				.filter(note -> note.getNoteType().equals("Cherry"))
				.filter(note -> note.getNoteText().equals("Blue-Green-Red-"))
				.count(),is(1L));
		assertThat("Check just one Pear with text Grey-Orange-", finalSet.stream()
				.filter(note -> note.getNoteType().equals("Pear"))
				.filter(note -> note.getNoteText().equals("Grey-Orange-"))
				.count(),is(1L));
	}
}
