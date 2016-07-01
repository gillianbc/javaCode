package com.gill.generics;

public class StagingWriter extends ServiceWriter {
	
	public void writeOut(StagingService staging) {
		super.writeOut(staging);
		System.out.println("StagingWriter: Stage Name: " + staging.getStageName());
	}

	
	
}
